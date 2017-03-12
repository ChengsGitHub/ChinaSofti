package com.icss.cwj;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * 服务器端WebSocket类
 * @author Administrator
 *
 */
@ServerEndpoint("/mywebsocket")
public class MyWebSocket {
	
	/**
	 * 当客户端发送数据时事件回调
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

		// 向客户端发送消息
		session.getBasicRemote().sendText("这是第1条服务器消息");

		// 每隔两秒钟发送一次消息，发送3次
		int sentMessages = 0;		
		
		while (sentMessages < 3) {
			Thread.sleep(2000);
			session.getBasicRemote().sendText("间隔发送消息次数: " + sentMessages);
			sentMessages++;
		}

		//向客户端发送消息
		session.getBasicRemote().sendText("这是最后1条服务器消息");
		
//		session.close();//关闭连接，可以不关，浏览器窗口关闭自动会触发关闭连接
	}

	/**
	 * 客户端连接成功事件回调
	 */
	@OnOpen
	public void onOpen() {
		System.out.println("连接被打开");
	}
	
	/**
	 * 连接被关闭事件回调
	 */
	@OnClose
	public void onClose() {
		System.out.println("连接被关闭");
	}

}