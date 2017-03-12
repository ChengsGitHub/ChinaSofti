package chapter9;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerImpl implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println(arg0.getServletContext().getContextPath() + "应用被关闭...");				
	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println(arg0.getServletContext().getContextPath() + "应用被加载...");		
	}

}