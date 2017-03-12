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
 * 文件上传
 */
public class UploadServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 获得Servlet上下文对象
		ServletContext context = this.getServletContext();

		// 磁盘文件列表工厂对象
		DiskFileItemFactory fact = new DiskFileItemFactory();

		// Servlet文件上传对象
		ServletFileUpload upload = new ServletFileUpload(fact);

		try {
			// 设置最大上传文件大小为10M，超出大小会发生异常
			upload.setSizeMax(1024 * 1024 * 50);

			// 获得所有上传文件对象集合
			List<FileItem> list = upload.parseRequest(request);

			// 获得第一个表单元素
			FileItem item = list.get(0);

			// 获得第二个表单元素
			FileItem item2 = list.get(1);
			String info = item2.getString();
			info = new String(info.getBytes("iso-8859-1"),"utf-8");
			System.out.println("info=" + info);

			// 文件大小
			long fileSize = item.getSize();

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
					+ (int) ((10000 - 1 + 1) * Math.random() + 1) + extName;

			// 设置上传文件夹和临时文件夹的物理路径
			String uploadPath = context.getRealPath("/myupload");

			// 判断目录是否存在，如果不存在，自动创建
			File dir = new File(uploadPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}

			// 创建文件对象
			File file = new File(uploadPath + File.separator + newFileName);

			// 写入文件（上传文件）
			item.write(file);

			// 删除临时文件
			item.delete();

			// 输出上传文件信息
			out.println("原始文件名:" + oldFileName);
			out.println("<br>");
			out.println("现在文件名:" + newFileName);
			out.println("<br>");
			out.println("文件大小：" + fileSize);
			out.println("<br>");
			out.println("存放位置：" + uploadPath);
			out.println("<br>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}