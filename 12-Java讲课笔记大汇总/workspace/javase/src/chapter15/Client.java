package chapter15;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端程序 
 *
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("192.168.2.1",7777);

		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		PrintWriter pw = new PrintWriter(osw);
		pw.println("老师，我家有一块金劳力士，有时间拿给你呀");
		pw.close();
	}

}
