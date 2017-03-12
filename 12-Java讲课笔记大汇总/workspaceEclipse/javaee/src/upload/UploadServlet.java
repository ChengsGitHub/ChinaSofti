package upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * �ļ��ϴ�
 */
public class UploadServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// ���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// ���Servlet�����Ķ���
		ServletContext context = this.getServletContext();

		// �����ļ��б�������
		DiskFileItemFactory fact = new DiskFileItemFactory();

		// Servlet�ļ��ϴ�����
		ServletFileUpload upload = new ServletFileUpload(fact);

		try {
			// ��������ϴ��ļ���СΪ10M��������С�ᷢ���쳣
			upload.setSizeMax(1024 * 1024 * 50);

			// ��������ϴ��ļ����󼯺�
			List<FileItem> list = upload.parseRequest(request);

			// ��õ�һ����Ԫ��
			FileItem item = list.get(0);

			// ��õڶ�����Ԫ��
			FileItem item2 = list.get(1);
			String info = item2.getString();
			info = new String(info.getBytes("iso-8859-1"),"utf-8");
			System.out.println("info=" + info);

			// �ļ���С
			long fileSize = item.getSize();

			// �ͻ����ļ�·��
			String fullName = item.getName();

			// ԭʼ�ļ�����
			String oldFileName = fullName
					.substring(fullName.lastIndexOf("\\") + 1);

			// ��չ��
			String extName = oldFileName
					.substring(oldFileName.lastIndexOf("."));

			// �������ļ�����(��ǰ����������1~1000�����)
			String newFileName = System.currentTimeMillis() + ""
					+ (int) ((10000 - 1 + 1) * Math.random() + 1) + extName;

			// �����ϴ��ļ��к���ʱ�ļ��е�����·��
			String uploadPath = context.getRealPath("/myupload");

			// �ж�Ŀ¼�Ƿ���ڣ���������ڣ��Զ�����
			File dir = new File(uploadPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}

			// �����ļ�����
			File file = new File(uploadPath + File.separator + newFileName);

			// д���ļ����ϴ��ļ���
			item.write(file);

			// ɾ����ʱ�ļ�
			item.delete();

			// ����ϴ��ļ���Ϣ
			out.println("ԭʼ�ļ���:" + oldFileName);
			out.println("<br>");
			out.println("�����ļ���:" + newFileName);
			out.println("<br>");
			out.println("�ļ���С��" + fileSize);
			out.println("<br>");
			out.println("���λ�ã�" + uploadPath);
			out.println("<br>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}