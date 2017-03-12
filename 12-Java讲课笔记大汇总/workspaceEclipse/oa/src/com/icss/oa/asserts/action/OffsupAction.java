package com.icss.oa.asserts.action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.icss.oa.common.BaseAction;
import com.icss.oa.common.Pager;
import com.icss.oa.asserts.pojo.Offsup;
import com.icss.oa.asserts.service.OffsupService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/offsup")
@Results({@Result(name = "success", location = "/offsup/query.action", type = "redirect")})
public class OffsupAction extends BaseAction implements ModelDriven<Offsup> {

	private Offsup offsup = new Offsup();
	
	private int pageNum;// 页码

	@Autowired
	private OffsupService service;

	public Offsup getOffsup() {
		return offsup;
	}

	public void setOffsup(Offsup offsup) {
		this.offsup = offsup;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	
	
	@Override
	public Offsup getModel() {
		return offsup;
	}

	@Action("insert")
	public String insert() {
		service.insert(offsup);
		return "success";
	}
	
	@Action("delete")
	public String delete() {
		service.delete(offsup.getId());
		return "success";
	}
	
	@Action(value="toUpdate", results = { @Result(name = "success", location = "/pages/offsup/UpdateOffsup.jsp", type = "dispatcher") })
	public String toUpdate() {
		Offsup offsupObj = service.queryById(offsup.getId());
		request.setAttribute("offsup", offsupObj);
		return "success";
	}
	
	@Action("update")
	public String update() {
		service.update(offsup);
		return "success";
	}

	@Action(value = "query", results = { @Result(name = "success", location = "/pages/offsup/QueryOffsup.jsp", type = "dispatcher") })
	public String query() {
		Pager pager = new Pager(service.getContentCount(), pageNum);
		List<Offsup> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	
	@Action(value = "querySmall", results = { @Result(name = "success", location = "/pages/offsup/QueryOffsupSmall.jsp", type = "dispatcher") })
	public String querySmall() {
		Pager pager = new Pager(service.getContentCount(), pageNum,6);
		List<Offsup> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}

	@Action("getOffsupJson")
	public String getOffsupJson() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
				
		Offsup offsupObj = service.queryById(offsup.getId());
		Gson gson = new Gson();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", offsupObj.getName());
		out.write(gson.toJson(map));
		
		return null;
	}
	/**
	 * 导出excel报表
	 * 
	 * @return
	 * @throws IOException
	 */
	@Action("exportExcel")
	public String exportExcel() throws IOException {

		// 通知客户端以附件形式接收数据		
		response.setHeader("content-disposition", "attachment;filename=offsup.xls");
		OutputStream os = response.getOutputStream();

		service.exportExcel(os);

		return null;
	}
}