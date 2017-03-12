package com.icss.cwj;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * ��������WebSocket��
 * @author Administrator
 *
 */
@ServerEndpoint("/mywebsocket")
public class MyWebSocket {
	
	/**
	 * ���ͻ��˷�������ʱ�¼��ص�
	 * @param message
	 * @param session
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@OnMessage
	public void onMessage(String message, Session session) throws IOException,
			InterruptedException {

		// Print the client message for testing purposes
		System.out.println("Received: " + message);

		// ��ͻ��˷�����Ϣ
		session.getBasicRemote().sendText("���ǵ�1����������Ϣ");

		// ÿ�������ӷ���һ����Ϣ������3��
		int sentMessages = 0;		
		
		while (sentMessages < 3) {
			Thread.sleep(2000);
			session.getBasicRemote().sendText("���������Ϣ����: " + sentMessages);
			sentMessages++;
		}

		//��ͻ��˷�����Ϣ
		session.getBasicRemote().sendText("�������1����������Ϣ");
		
//		session.close();//�ر����ӣ����Բ��أ���������ڹر��Զ��ᴥ���ر�����
	}

	/**
	 * �ͻ������ӳɹ��¼��ص�
	 */
	@OnOpen
	public void onOpen() {
		System.out.println("���ӱ���");
	}
	
	/**
	 * ���ӱ��ر��¼��ص�
	 */
	@OnClose
	public void onClose() {
		System.out.println("���ӱ��ر�");
	}

}