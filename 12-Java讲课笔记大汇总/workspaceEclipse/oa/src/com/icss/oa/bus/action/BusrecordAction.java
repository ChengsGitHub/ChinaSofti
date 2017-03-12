package com.icss.oa.bus.action;


import java.util.List;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.icss.oa.bus.pojo.Busrecord;
import com.icss.oa.bus.service.BusrecordService;
import com.icss.oa.common.BaseAction;
import com.icss.oa.common.Pager;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/busrecord")
@Results({@Result(name = "success", location = "/busrecord/query.action", type = "redirect")})
public class BusrecordAction extends BaseAction implements ModelDriven<Busrecord>{

	private Busrecord busrecord = new Busrecord();


	private int pageNum;// 匈鷹

	@Autowired
	private BusrecordService service;

	
	public Busrecord getBusrecord() {
		return busrecord;
	}

	public void setBusrecord(Busrecord busrecord) {
		this.busrecord = busrecord;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	@Override
	public Busrecord getModel(){
		return busrecord;
	}
	
	@Action("insert")
	public String insert() throws Exception{
		service.insert(busrecord); 
		return "success";
	}
	
	@Action("delete")
	public String delete() throws Exception{
		service.delete(busrecord.getBrecordId());
		return "success";
	}
	
	@Action("update")
	public String update() throws Exception{
	
		service.update(busrecord);
		return "success";
	}
	
	
	@Action(value="toUpdate",results = { @Result(name = "success", location = "/pages/bus/UpdateBusRecord.jsp", type = "dispatcher")})
	public String toUpdate() throws Exception {
		Busrecord busrecordObj = service.queryById(busrecord.getBrecordId());
		System.out.println(busrecordObj.getEndTime()+"。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
		request.setAttribute("busrecord", busrecordObj);
		
		return "success";
	}
	
	@Action(value = "query", results = { @Result(name = "success", location = "/pages/bus/BusRecord.jsp", type = "dispatcher") })
	public String query() throws Exception {
		Pager pager = new Pager(service.getCount(), pageNum);
		List<Busrecord> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	
	@Action(value = "queryById" )
	public Busrecord queryById(Integer brecordId) throws Exception {
		service.queryById(brecordId);
		return busrecord;
	}
	
}
