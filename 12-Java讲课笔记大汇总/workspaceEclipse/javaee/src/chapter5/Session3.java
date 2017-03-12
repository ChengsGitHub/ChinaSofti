package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Session3 extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// ���session����
		HttpSession session = request.getSession();
		
		//���ó�ʱʱ������Ϊ��λ�����Ե�ǰ�Ự��Ч��������Ӱ��ȫ�֣�
		session.setMaxInactiveInterval(10);
		
		//���س�ʱʱ��
		out.println("��ʱʱ����" + session.getMaxInactiveInterval());

		out.println("sessionID=" + session.getId());

	}

}