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
 * �Զ���realm
 */
public class MyRealm extends AuthorizingRealm {
	
	@Autowired
	private Emp1Service service;
	
	@Autowired
	private PermService permService;

	/**
	 * �����Ȩ��Ϣ
	 */
	public AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		System.out.println("������Ȩ...doGetAuthorizationInfo");

		// ��õ�ǰ�û���
		String userName = (String) getAvailablePrincipal(principals);

		// ͨ���û���ȥ����û���������Դ��������Դ����info�У�ʵ�ʿ���Ӧ�ò�ѯ���ݿ�����ݣ�������д���ģ�
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

	
		// ����Ȩ��
		Set<String> s = new HashSet<String>();
		List<Map<String,Object>> list = permService.qyeryPerm(userName);
		for (Map map : list) {
			System.out.println(map.get("PERM_NAME"));
			s.add((String)map.get("PERM_NAME"));
		}
		info.setStringPermissions(s);

		// ���ý�ɫ
		Set<String> r = new HashSet<String>();
		list = permService.qyeryRole(userName);
		for (Map map : list) {
			System.out.println(map.get("ROLE_NAME"));
			r.add((String)map.get("ROLE_NAME"));
		}
		info.setRoles(r);
		
		// ���ش��û�����Ȩ��Ϣ
		return info;
	}

	/**
	 * �����֤��Ϣ
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		System.out.println("���е�½��֤...doGetAuthenticationInfo");

		// token�д�����������û���������
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		String password = String.valueOf(upToken.getPassword());

		
		Emp1 emp1 = new Emp1();
		emp1.setUsername(username);
		emp1.setPassword(password);
		Map map = service.checkUser(emp1);
		int flag = (Integer) map.get("flag");
		
		if (flag == 1) {
			//�˺Ų�����
			throw new UnknownAccountException();
		} else if (flag == 2) {
			//�������
			throw new IncorrectCredentialsException();
		} else {			
			// ��¼�ɹ��򷵻�info
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,
					password.toCharArray(), getName());

			return info;
		}
		
	}

	/**
	 * ɾ����ǰ�û��Ļ���
	 * 
	 * @param userId
	 */
	public void removeUserCache(String userId) {
		SimplePrincipalCollection pc = new SimplePrincipalCollection();
		pc.add(userId, super.getName());
		super.clearCachedAuthorizationInfo(pc);
	}

}