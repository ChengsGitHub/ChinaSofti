package chapter9;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionListenerImpl implements HttpSessionListener,HttpSessionAttributeListener {

	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("�Ự������" + arg0.getSession().getId());		
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("�Ự������" + arg0.getSession().getId());
	}

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println("���Ӽ�ֵ��" + arg0.getName() + "=" + arg0.getValue());	
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("ɾ����ֵ��" + arg0.getName() + "=" + arg0.getValue());
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("�滻��ֵ��" + arg0.getName() + "=" + arg0.getValue());
	}
	
}