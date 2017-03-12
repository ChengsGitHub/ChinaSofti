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
import com.icss.oa.asserts.pojo.Warehouse;
import com.icss.oa.asserts.service.WarehouseService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/warehouse")
@Results({@Result(name = "success", location = "/warehouse/query.action", type = "redirect")})
public class WarehouseAction extends BaseAction implements ModelDriven<Warehouse> {

	private Warehouse warehouse = new Warehouse();
	
	private int pageNum;// Ò³Âë

	@Autowired
	private WarehouseService service;

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setOffsup(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	
	
	@Override
	public Warehouse getModel() {
		return warehouse;
	}

	@Action("insert")
	public String insert() {
		service.insert(warehouse);
		return "success";
	}
	
	@Action("delete")
	public String delete() {
		service.delete(warehouse.getWarehouseId());
		return "success";
	}
	
	@Action(value="toUpdate", results = { @Result(name = "success", location = "/pages/offsup/UpdateOffsup.jsp", type = "dispatcher") })
	public String toUpdate() {
		Warehouse warehouseObj = service.queryById(warehouse.getWarehouseId());
		request.setAttribute("warehouse", warehouseObj);
		return "success";
	}
	
	@Action("update")
	public String update() {
		service.update(warehouse);
		return "success";
	}

	@Action(value = "query", results = { @Result(name = "success", location = "/pages/offsup/QueryWarehouse.jsp", type = "dispatcher") })
	public String query() {
		Pager pager = new Pager(service.getContentCount(), pageNum);
		List<Warehouse> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}

	@Action("getOffsupJson")
	public String getOffsupJson() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
				
		Warehouse warehouseObj = service.queryById(warehouse.getWarehouseId());
		Gson gson = new Gson();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", warehouseObj.getWarehouseName());
		out.write(gson.toJson(map));
		
		return null;
	}
}