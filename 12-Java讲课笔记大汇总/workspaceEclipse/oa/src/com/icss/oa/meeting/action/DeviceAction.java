package com.icss.oa.meeting.action;


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
import com.icss.oa.meeting.pojo.Device;
import com.icss.oa.meeting.service.DeviceService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/device")
@Results({@Result(name = "success", location = "/device/query.action", type = "redirect")})
public class DeviceAction extends BaseAction implements ModelDriven<Device>{

	private Device device = new Device();


	private int pageNum;// Ò³Âë

	@Autowired
	private DeviceService service;

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}
	
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	@Override
	public Device getModel(){
		return device;
	}
	
	@Action("insert")
	public String insert() throws Exception{
		service.insert(device);
		return "success";
	}
	
	@Action("delete")
	public String delete() throws Exception{
		service.delete(device.getDevId());
		return "success";
	}
	
	@Action("update")
	public String update() throws Exception{
		service.update(device);
		return "success";
	}
	
	
	@Action(value = "query", results = { @Result(name = "success", location = "/pages/meeting/Device.jsp", type = "dispatcher") })
	public String query() throws Exception {
		Pager pager = new Pager(service.getCount(), pageNum);
		List<Device> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	
	@Action(value = "querySmall", results = { @Result(name = "success", location = "/pages/meeting/QueryDeviceSmall.jsp", type = "dispatcher") })
	public String querySmall() throws Exception {
		Pager pager = new Pager(service.getCount(), pageNum,6);
		List<Device> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	
	@Action("getDeviceJson")
	public String getDeviceJson() throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
				
		Device deviceObj = service.queryById(device.getDevId());
		Gson gson = new Gson();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("devName", deviceObj.getDevName());
		out.write(gson.toJson(map));
		
		return null;
	}
}
