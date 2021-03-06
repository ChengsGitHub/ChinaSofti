package chapter15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端程序 
 */
public class Server {

	public static void main(String[] args) throws IOException {
		
		System.out.println("服务器已启动.....");
		
		//创建一个服务器对象（传入端口）
		ServerSocket serverSocket = new ServerSocket(7777);
		
		while (true) {
			//接收客户端连接请求
			Socket socket = serverSocket.accept();
			
			//获得客户端的数据流
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String s = br.readLine();
			System.out.println("来自" + socket.getInetAddress() + "的消息：" + s);
			br.close();
		}

	}

}