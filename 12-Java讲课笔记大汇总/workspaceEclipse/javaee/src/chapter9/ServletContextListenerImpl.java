package chapter9;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerImpl implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println(arg0.getServletContext().getContextPath() + "Ӧ�ñ��ر�...");				
	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println(arg0.getServletContext().getContextPath() + "Ӧ�ñ�����...");		
	}

}