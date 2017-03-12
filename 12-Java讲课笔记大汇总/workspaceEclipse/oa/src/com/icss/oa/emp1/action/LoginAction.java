package com.icss.oa.emp1.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.icss.oa.common.BaseAction;
import com.icss.oa.emp1.pojo.Emp1;
import com.icss.oa.emp1.service.Emp1Service;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/login")
public class LoginAction extends BaseAction implements ModelDriven<Emp1> {

	private Emp1 emp1 = new Emp1();
	
	@Autowired
	private Emp1Service service;

	public Emp1 getEmp1() {
		return emp1;
	}

	public void setEmp1(Emp1 emp1) {
		this.emp1 = emp1;
	}

	@Override
	public Emp1 getModel() {
		
		return emp1;
	}
	
	/**
	 * 提供ajax接口，做异步用户名密码验证
	 * @return
	 * @throws IOException
	 */
	@Action("checkLogin")
	public String checkLogin() throws IOException {
				
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//封装用户名和密码
		UsernamePasswordToken token = new UsernamePasswordToken(emp1.getUsername(),emp1.getPassword());  
		//设置RememberMe
		token.setRememberMe(true);
		
		/*通过shiro登录*/
		Subject currentUser = SecurityUtils.getSubject();  
		
		try {
			currentUser.login(token);
		} catch (UnknownAccountException e) {
			out.print("1");
			return null;
		} catch (IncorrectCredentialsException e) {
			out.print("2");
			return null;
		}	
		
		//在Session范围存储用户信息
		HttpSession session = request.getSession();
		Map map = service.checkUser(emp1);
		Emp1 emp1Obj = (Emp1) map.get("emp1");
		session.setAttribute("emp1Id", emp1Obj.getEmp1Id());
		session.setAttribute("emp1Name", emp1Obj.getEmp1Name());
		
		out.print("3");
	
		return null;
	}

}