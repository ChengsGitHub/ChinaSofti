package com.icss.hr.photo.controller;

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

import com.icss.hr.photo.service.PhotoService;
import com.icss.hr.photo.service.impl.PhotoServiceImpl;
import com.icss.hr.photo.vo.PhotoVo;

public class InsertPhotoServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String empId = request.getParameter("empId");

		// ���Servlet�����Ķ���
		ServletContext context = this.getServletContext();

		// �����ļ��б�������
		DiskFileItemFactory fact = new DiskFileItemFactory();

		// Servlet�ļ��ϴ�����
		ServletFileUpload upload = new ServletFileUpload(fact);
		
		PhotoService service = new PhotoServiceImpl();

		try {
			/***********�ϴ��ļ�****************/
			
			// ��������ϴ��ļ���СΪ2M��������С�ᷢ���쳣
			upload.setSizeMax(1024 * 1024 * 2);

			// ��������ϴ��ļ����󼯺�
			List<FileItem> list = upload.parseRequest(request);

			// ��õ�һ����Ԫ�أ��ϴ����ݣ�
			FileItem item = list.get(0);

			// �ļ���С
			long fileSize = item.getSize();
			
			//�������Ϊ0����ʾδѡ���ϴ��ļ�
			if (fileSize == 0) {
				out.println("<script>alert('��ѡ����Ч���ϴ��ļ�');history.back();</script>");
				return;
			}

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
					+ (int) ((1000 - 1 + 1) * Math.random() + 1) + extName;

			// �ж�ֻ����jpg jpeg gif
			if (!".jpg".equalsIgnoreCase(extName)
					&& !".jpeg".equalsIgnoreCase(extName)
					&& !".gif".equalsIgnoreCase(extName)) {
				out.println("<script>alert('�ϴ����ͽ�����jpg,jpeg,gif��ʽ��ͼƬ');history.back();</script>");
				return;
			}
			
			// �����ϴ��ļ��к���ʱ�ļ��е�����·��
			String uploadPath = context.getRealPath("/upload");

			// �����ļ�����
			File file = new File(uploadPath + File.separator + newFileName);

			// д���ļ����ϴ��ļ���
			item.write(file);

			// ɾ����ʱ�ļ�
			item.delete();
			
			
			/***********��������****************/
			PhotoVo vo = new PhotoVo(newFileName,Integer.parseInt(empId));
			service.insert(vo);			
			
		} catch (Exception e) {
			
			if (e.getMessage().indexOf("maximum") != -1) {
				response.sendRedirect("UploadError.jsp");
				return;
			}
			
			e.printStackTrace();
			request.setAttribute("errmsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
		out.println("<script>alert('�ϴ��ɹ�!');location.href='QueryPhotoServlet?empId=" + empId + "';</script>");
	}
}