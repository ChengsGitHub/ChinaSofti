package com.icss.oa.common;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.oa.emp1.pojo.Emp1;
import com.icss.oa.emp1.service.Emp1Service;
import com.icss.oa.emp1.service.PermService;

/**
 * 自定义realm
 */
public class MyRealm extends AuthorizingRealm {
	
	@Autowired
	private Emp1Service service;
	
	@Autowired
	private PermService permService;

	/**
	 * 获得授权信息
	 */
	public AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		System.out.println("进行授权...doGetAuthorizationInfo");

		// 获得当前用户名
		String userName = (String) getAvailablePrincipal(principals);

		// 通过用户名去获得用户的所有资源，并把资源存入info中（实际开发应该查询数据库的数据，以下是写死的）
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

	
		// 设置权限
		Set<String> s = new HashSet<String>();
		List<Map<String,Object>> list = permService.qyeryPerm(userName);
		for (Map map : list) {
			System.out.println(map.get("PERM_NAME"));
			s.add((String)map.get("PERM_NAME"));
		}
		info.setStringPermissions(s);

		// 设置角色
		Set<String> r = new HashSet<String>();
		list = permService.qyeryRole(userName);
		for (Map map : list) {
			System.out.println(map.get("ROLE_NAME"));
			r.add((String)map.get("ROLE_NAME"));
		}
		info.setRoles(r);
		
		// 返回此用户的授权信息
		return info;
	}

	/**
	 * 获得认证信息
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		System.out.println("进行登陆验证...doGetAuthenticationInfo");

		// token中储存着输入的用户名和密码
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		String password = String.valueOf(upToken.getPassword());

		
		Emp1 emp1 = new Emp1();
		emp1.setUsername(username);
		emp1.setPassword(password);
		Map map = service.checkUser(emp1);
		int flag = (Integer) map.get("flag");
		
		if (flag == 1) {
			//账号不存在
			throw new UnknownAccountException();
		} else if (flag == 2) {
			//密码错误
			throw new IncorrectCredentialsException();
		} else {			
			// 登录成功则返回info
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,
					password.toCharArray(), getName());

			return info;
		}
		
	}

	/**
	 * 删除当前用户的缓存
	 * 
	 * @param userId
	 */
	public void removeUserCache(String userId) {
		SimplePrincipalCollection pc = new SimplePrincipalCollection();
		pc.add(userId, super.getName());
		super.clearCachedAuthorizationInfo(pc);
	}

}