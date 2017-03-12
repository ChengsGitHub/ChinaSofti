package com.icss.oa.assign.action;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;

import com.icss.oa.common.BaseAction;
import com.icss.oa.common.Pager;
import com.icss.oa.assign.index.ExpinfQueryResult;
import com.icss.oa.assign.pojo.Expinf;
import com.icss.oa.assign.service.ExpinfService;
import com.icss.oa.assign.service.ImageService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/expinf")
@Results({ @Result(name = "success", location = "/expinf/query.action", type = "redirect") })
public class ExpinfAction extends BaseAction implements ModelDriven<Expinf> {

	private Expinf expinf = new Expinf();

	private File imageData;// 上传文件数据

	private String imageDataFileName;// 文件名称

	private String imageDataContentType;// 文件类型

	private Integer imageId;// 照片ID

	private int pageNum;

	private String queryStr;// 全文检索字符串

	@Autowired
	private ExpinfService service;

	@Autowired
	private ImageService imageService;

	public Expinf getExpinf() {
		return expinf;
	}

	public void setExpinf(Expinf expinf) {
		this.expinf = expinf;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public File getImageData() {
		return imageData;
	}

	public void setImageData(File imageData) {
		this.imageData = imageData;
	}

	public String getImageDataFileName() {
		return imageDataFileName;
	}

	public void setImageDataFileName(String imageDataFileName) {
		this.imageDataFileName = imageDataFileName;
	}

	public String getImageDataContentType() {
		return imageDataContentType;
	}

	public void setImageDataContentType(String imageDataContentType) {
		this.imageDataContentType = imageDataContentType;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getQueryStr() {
		return queryStr;
	}

	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}

	@Override
	public Expinf getModel() {

		return expinf;
	}

	@Action("insert")
	public String insert() throws IOException {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		service.insert(expinf);
		return "success";
	}

	@Action("update")
	public String update() throws IOException {
		
		service.update(expinf);
		return null;
	}

	@Action("delete")
	public String delete() throws IOException {
		service.delete(expinf.getExpinfId());
		return "success";
	}

	@Action(value = "toUpdate", results = { @Result(name = "success", location = "/pages/assign/ExpinfDetails.jsp", type = "dispatcher") })
	public String toUpdate() {
		Expinf expinfObj = service.queryById(expinf.getExpinfId());
		request.setAttribute("expinf", expinfObj);
		return "success";
	}

	@Action(value = "query", results = { @Result(name = "success", location = "/pages/assign/QueryExpinf.jsp", type = "dispatcher") })
	public String query() {
		Pager pager = new Pager(service.getCount(), pageNum);
		List<Expinf> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}

	/**
	 * 带条件查询
	 * 
	 * @return
	 */
	@Action(value = "queryByCondition", results = { @Result(name = "success", location = "/pages/assign/QueryConditionExpinf.jsp", type = "dispatcher") })
	public String queryByCondition() {
		Pager pager = new Pager(service.getConditionCount(expinf.getExpinfName()),
				pageNum, 6);
		List<Expinf> list = service.querByCondition(pager, expinf.getExpinfName());
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}

	/**
	 * 全文检索员工
	 * 
	 * @return
	 * @throws Exception 
	 * @throws IOException
	 */
	@Action(value = "queryByIndex", results = { @Result(name = "success", location = "/pages/assign/QueryExpinfByIndex.jsp", type = "dispatcher") })
	public String queryByIndex() throws Exception {

		Pager pager = new Pager(pageNum);
		ExpinfQueryResult queryResult = service.queryByIndex(queryStr, pager);
		request.setAttribute("queryResult", queryResult);
		request.setAttribute("pager", pager);
		return "success";
	}

	@Action(value = "uploadImg", results = { @Result(name = "success", location = "/expinf/toUpdate.action?expinfId=${expinfId}", type = "redirect") })
	public String uploadImg() throws IOException {
		
		if(this.imageData == null ) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.write("<script>alert('请选择简历');history.back();</script>");
			return null;
		}
		byte[] imageData = FileCopyUtils.copyToByteArray(this.imageData);
		
		expinf.setExpinf(imageData);
				
		service.uploadImg(expinf);
		int expinfId=expinf.getExpinfId();

		return "success";
	}

	@Action("download")
	public String download() throws IOException {
		
		Expinf expinfObj = service.download(expinf.getExpinfId());
				
		byte[] imageData = expinfObj.getExpinf();	
		if(imageData == null || imageData.length == 0) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.write("<script>alert('未找到简历');history.back();</script>");
			return null;
		}
		response.setHeader("content-disposition", "attchment;filename=data.doc");
		OutputStream out = response.getOutputStream();
		FileCopyUtils.copy(imageData, out);
		
		return null;
	}

}