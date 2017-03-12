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

		// 获得Servlet上下文对象
		ServletContext context = this.getServletContext();

		// 磁盘文件列表工厂对象
		DiskFileItemFactory fact = new DiskFileItemFactory();

		// Servlet文件上传对象
		ServletFileUpload upload = new ServletFileUpload(fact);
		
		PhotoService service = new PhotoServiceImpl();

		try {
			/***********上传文件****************/
			
			// 设置最大上传文件大小为2M，超出大小会发生异常
			upload.setSizeMax(1024 * 1024 * 2);

			// 获得所有上传文件对象集合
			List<FileItem> list = upload.parseRequest(request);

			// 获得第一个表单元素（上传数据）
			FileItem item = list.get(0);

			// 文件大小
			long fileSize = item.getSize();
			
			//如果长度为0，表示未选择上传文件
			if (fileSize == 0) {
				out.println("<script>alert('请选择有效的上传文件');history.back();</script>");
				return;
			}

			// 客户端文件路径
			String fullName = item.getName();

			// 原始文件名称
			String oldFileName = fullName
					.substring(fullName.lastIndexOf("\\") + 1);

			// 扩展名
			String extName = oldFileName
					.substring(oldFileName.lastIndexOf("."));

			// 生成新文件名称(当前毫秒数连接1~1000随机数)
			String newFileName = System.currentTimeMillis() + ""
					+ (int) ((1000 - 1 + 1) * Math.random() + 1) + extName;

			// 判断只能是jpg jpeg gif
			if (!".jpg".equalsIgnoreCase(extName)
					&& !".jpeg".equalsIgnoreCase(extName)
					&& !".gif".equalsIgnoreCase(extName)) {
				out.println("<script>alert('上传类型仅限于jpg,jpeg,gif格式的图片');history.back();</script>");
				return;
			}
			
			// 设置上传文件夹和临时文件夹的物理路径
			String uploadPath = context.getRealPath("/upload");

			// 创建文件对象
			File file = new File(uploadPath + File.separator + newFileName);

			// 写入文件（上传文件）
			item.write(file);

			// 删除临时文件
			item.delete();
			
			
			/***********插入数据****************/
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
		
		out.println("<script>alert('上传成功!');location.href='QueryPhotoServlet?empId=" + empId + "';</script>");
	}
}