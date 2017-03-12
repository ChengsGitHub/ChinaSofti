package com.icss.oa.bus.action;

import java.io.File;
import java.io.OutputStream;
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

import com.icss.oa.bus.pojo.Bus;
import com.icss.oa.bus.service.BusService;
import com.icss.oa.common.BaseAction;
import com.icss.oa.common.Pager;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/bus")
@Results({@Result(name = "success", location = "/bus/query.action", type = "redirect")})
public class BusAction extends BaseAction implements ModelDriven<Bus>{

	private Bus bus = new Bus();
	
	private int pageNum;
	
	private File fileData;
	
	@Autowired
	private BusService service;
	
	@Override
	public Bus getModel() {
		return bus;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public File getFileData() {
		return fileData;
	}

	public void setFileData(File fileData) {
		this.fileData = fileData;
	}
	
	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
	@Action("insert")
	public String insert() throws Exception{
		
		
		service.insert(bus);
		return "success";
	}
	
	@Action("delete")
	public String delete() throws Exception{
		service.delete(bus.getBusId());
		return "success";
	}
	
	@Action("update")
	public String update() throws Exception{
		
		service.update(bus);
		return "success";
	}
	
	@Action(value="toUpdate",results = { @Result(name = "success", location = "/pages/bus/Bus.jsp", type = "dispatcher")})
	public String toUpdate() throws Exception {
		Bus busObj = service.queryById(bus.getBusId());
		request.setAttribute("bus", busObj);
		return "success";
	}
	
	@Action(value = "queryById")
	public Bus queryById(Integer busId) throws Exception {
		service.queryById(busId);
		return bus;
	}
	
	
	@Action(value = "query", results = { @Result(name = "success", location = "/pages/bus/Bus.jsp", type = "dispatcher") })
	public String query() throws Exception {
		Pager pager = new Pager(service.getCount(), pageNum);
		List<Bus> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	
	/**
	 * 带条件查询
	 * 
	 * @return
	 * @throws Exception 
	 */
	@Action(value = "queryByCondition", results = { @Result(name = "success", location = "/pages/bus/QueryConditionBus.jsp", type = "dispatcher") })
	public String queryByCondition() throws Exception {
		
		//get请求传递中文需要手动转码
		String busType = new String(bus.getBusType().getBytes("iso-8859-1"),"utf-8");
		bus.setBusType(busType);
		
		System.out.println("busType=" + bus.getBusType());
				
		Pager pager = new Pager(service.getConditionCount(bus.getBusType()),
				pageNum, 6);
		List<Bus> list = service.querByCondition(pager, bus.getBusType());
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}

	@Action("readImage")
	public String readImage() throws Exception {

	

		Bus busObj = service.queryById(bus.getBusId());
		OutputStream out = response.getOutputStream();

		byte[] fileData = busObj.getBusPhoto();

		FileCopyUtils.copy(fileData, out);

		return null;
	}
	@Action(value = "showImage", results = { @Result(name = "success", location = "/pages/bus/ShowBusPhoto.jsp", type = "dispatcher") })
	public String showImage() {
		List<Bus> list = service.queryByBusId(bus.getBusId());
		request.setAttribute("list", list);
		return "success";
	}
	
}
