package chapter4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PdfServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//������Ӧ��MIME���ͺͱ���
		response.setContentType("application/pdf;charset=gbk");
		
		//������
		String url = this.getServletContext().getRealPath("/download/JDBC.pdf");
		FileInputStream fis = new FileInputStream(url);
		
		//�����
		OutputStream out = response.getOutputStream();
		
		byte[] b = new byte[1024 * 8];
		
		int length = fis.read(b);
		
		while (length != -1) {
			out.write(b, 0, length);
			length = fis.read(b);
		}
		
		out.close();
		fis.close();
	}

}