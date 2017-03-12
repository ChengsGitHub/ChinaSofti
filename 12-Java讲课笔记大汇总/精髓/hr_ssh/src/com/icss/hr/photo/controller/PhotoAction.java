package com.icss.hr.photo.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.icss.hr.common.BaseAction;
import com.icss.hr.photo.po.Photo;
import com.icss.hr.photo.service.PhotoService;
import com.icss.hr.photo.vo.PhotoVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class PhotoAction extends BaseAction implements ModelDriven<PhotoVo> {

	private PhotoVo vo = new PhotoVo();

	private PhotoService service;

	public PhotoVo getVo() {
		return vo;
	}

	public void setVo(PhotoVo vo) {
		this.vo = vo;
	}

	public void setService(PhotoService service) {
		this.service = service;
	}

	@Override
	public PhotoVo getModel() {

		return vo;
	}

	public String add() throws IOException {

		/*上传文件*/
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		if (vo.getPhoto() == null) {
			out.println("<script>alert('请选择一个有效的文件');history.back();</script>");
			return null;
		}

		// 上传目录物理路径
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");

		// 扩展名
		String extName = vo.getPhotoFileName().substring(
				vo.getPhotoFileName().lastIndexOf("."));

		if (!".gif".equals(extName.toLowerCase())
				&& !".jpg".equals(extName.toLowerCase())
				&& !".jpeg".equals(extName.toLowerCase())) {
			out.println("<script>alert('上传类型只能是gif和jpg格式');history.back();</script>");
			return null;
		}

		// 生成新文件名称(当前毫秒数连接1~1000随机数)
		String newFileName = System.currentTimeMillis() + ""
				+ (int) ((1000 - 1 + 1) * Math.random() + 1) + extName;
		
		vo.setPhotoPath(newFileName);

		// 保存的新文件
		File file = new File(path, newFileName);

		// 复制文件数据
		FileUtils.copyFile(vo.getPhoto(), file);
		
		/*数据库插入*/
		service.add(vo);

		return Action.SUCCESS;
	}

	public String delete() {
		//删除硬盘文件
		File file = new File(context.getRealPath("/upload/" + vo.getPhotoPath()));
		file.delete();
		
		service.delete(vo.getPhotoId());
		return Action.SUCCESS;
	}

	public String query() {
		List<Photo> list = service.query(vo.getEmpId());
		request.setAttribute("list", list);
		return Action.SUCCESS;
	}
	
}