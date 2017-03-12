package com.icss.oa.message.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.icss.oa.common.BaseAction;
import com.icss.oa.common.Pager;
import com.icss.oa.message.pojo.Message;
import com.icss.oa.message.service.MessageService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/message")
@Results({ @Result(name = "success", location = "/pages/Success.html", type = "redirect") })
public class MessageAction extends BaseAction implements ModelDriven<Message> {

	private Message message = new Message();

	private int pageNum = 1;

	private int flag;

	private int flag1;
	
	private int flag2;

	private Integer[] empList;

	public int getFlag2() {
		return flag2;
	}

	public void setFlag2(int flag2) {
		this.flag2 = flag2;
	}

	public int getFlag1() {
		return flag1;
	}

	public void setFlag1(int flag1) {
		this.flag1 = flag1;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Integer[] getEmpList() {
		return empList;
	}

	public void setEmpList(Integer[] empList) {
		this.empList = empList;
	}

	@Autowired
	private MessageService service;

	@Override
	public Message getModel() {
		// TODO Auto-generated method stub
		return message;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Action(value = "insert", results = { @Result(name = "success", location = "/message/queryNoSend.action", type = "redirect") })
	public String insert() {

		service.insert(message);
		return "success";
	}

	@Action(value = "insertMany", results = { @Result(name = "success", location = "/message/queryNoSend.action", type = "redirect") })
	public String insertMany() {
		if (empList != null){
			for (int i : empList) {	
				message.setRecevId(i);
				service.insert(message);
			}
		}else
			service.insert(message);
		
		return "success";
	}

	@Action(value = "delete", results = {
			@Result(name = "sendYet", location = "/message/querySendYet.action", type = "redirect"),
			@Result(name = "noSend", location = "/message/queryNoSend.action", type = "redirect"),
			@Result(name = "read", location = "/message/queryRead.action", type = "redirect"),
			@Result(name = "readYet", location = "/message/queryReadYet.action", type = "redirect"),
			@Result(name = "noRead", location = "/message/queryNoRead.action", type = "redirect"), })
	public String delete() {

		Message messageObj = service.queryById(message.getMessageId());

		if (flag == 1) {
			if(messageObj.getmRead() == 3)
				service.delete(messageObj);
			else{
				messageObj.setmSend(3);
				service.update(messageObj);
			}
			return "sendYet";
		} else if (flag == 2) {
			messageObj.setmSend(4);
			service.delete(messageObj);
			return "noSend";
		} else if (flag == 3) {
			if(messageObj.getmSend() == 3)
				service.delete(messageObj);
			else{
				messageObj.setmRead(3);
				service.update(messageObj);
			}
			return "read";
		} else if (flag == 4) {
			if(messageObj.getmSend() == 3)
				service.delete(messageObj);
			else{
				messageObj.setmRead(3);
				service.update(messageObj);
			}
			return "readYet";
		} else {
			if(messageObj.getmSend() == 3)
				service.delete(messageObj);
			else{
				messageObj.setmRead(3);
				service.update(messageObj);
			}
			return "noRead";
		}
	}

	@Action(value = "readMySend", results = {
			@Result(name = "noSend", location = "/pages/message/MessageSendDetail1.jsp", type = "dispatcher"),
			@Result(name = "sendYet", location = "/pages/message/MessageSendDetail2.jsp", type = "dispatcher") })
	public String read() {
		Map<String, Object> mapObj = service.readMySend(message.getMessageId());
		request.setAttribute("message", mapObj);
		if (flag1 == 2)
			return "noSend";
		else
			return "sendYet";
	}

	@Action(value = "read", results = { @Result(name = "success", location = "/pages/message/MessageReadDetail.jsp", type = "dispatcher") })
	public String readMySend() {
		Map<String, Object> mapObj = service.read(message.getMessageId());
		
		request.setAttribute("message", mapObj);
		return "success";
	}

	@Action(value = "update", results = { @Result(name = "success", location = "/message/queryNoSend.action", type = "redirect") })
	public String update() {
		
		Message messageObj = service.queryById(message.getMessageId());
		messageObj.setMessageCont(message.getMessageCont());
		messageObj.setRecevId(message.getRecevId());
		service.update(messageObj);
		return "success";
	}

	@Action(value = "sendOld", results = { @Result(name = "success", location = "/message/querySendYet.action", type = "redirect") })
	public String sendOld() {
		Message messageObj = service.queryById(message.getMessageId());
		messageObj.setMessageCont(message.getMessageCont());
		messageObj.setRecevId(message.getRecevId());
		service.sendOld(messageObj);
		return "success";
	}
	
	@Action(value = "sendManyOld", results = { @Result(name = "success", location = "/message/querySendYet.action", type = "redirect") })
	public String sendManyOld() {
		for (int i : empList) {	
			message.setRecevId(i);
			service.sendOld(message);
		}
		return "success";
	}

	@Action(value = "sendNew", results = { @Result(name = "success", location = "/message/querySendYet.action", type = "redirect") })
	public String sendNew() {
		
		service.sendNew(message);
		return "success";
	}
	
	@Action(value = "sendManyNew", results = { @Result(name = "success", location = "/message/querySendYet.action", type = "redirect") })
	public String sendManyNew() {
		for (int i : empList) {	
			message.setRecevId(i);
			service.sendNew(message);
		}
		return "success";
	}

//	@Action(value = "querySend", results = { @Result(name = "success", location = "/pages/message/QuerySend.jsp", type = "dispatcher") })
//	public String querySend() {
//		HttpSession session = request.getSession();
//		int empId = (Integer) session.getAttribute("empId");
//
//		Pager pager = new Pager(service.getCount(), pageNum);
//		List<Map<String, Object>> list = service.querySend(pager, empId);
//		request.setAttribute("list", list);
//		request.setAttribute("pager", pager);
//		return "success";
//	}

	@Action(value = "querySendYet", results = { @Result(name = "success", location = "/pages/message/QuerySendYet.jsp", type = "dispatcher") })
	public String querySendYet() {
		HttpSession session = request.getSession();
		int empId = (Integer) session.getAttribute("emp1Id");

		Pager pager = new Pager(service.getSendYetCount(empId), pageNum);
		List<Map<String, Object>> list = service.querySendYet(pager, empId,flag2);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}

	@Action(value = "queryNoSend", results = { @Result(name = "success", location = "/pages/message/QueryNoSend.jsp", type = "dispatcher") })
	public String queryNoSend() {
		HttpSession session = request.getSession();
		int empId = (Integer) session.getAttribute("emp1Id");

		Pager pager = new Pager(service.getNoSendCount(empId), pageNum);
		List<Map<String, Object>> list = service.queryNoSend(pager, empId,flag2);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}

	@Action(value = "queryRead", results = { @Result(name = "success", location = "/pages/message/QueryRead.jsp", type = "dispatcher") })
	public String queryRead() {
		HttpSession session = request.getSession();
		int empId = (Integer) session.getAttribute("emp1Id");
		
		Pager pager = new Pager(service.getReadCount(empId), pageNum);
		List<Map<String, Object>> list = service.queryRead(pager,empId,flag2);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}

	@Action(value = "queryReadYet", results = { @Result(name = "success", location = "/pages/message/QueryReadYet.jsp", type = "dispatcher") })
	public String queryReadYet() {
		
		

		HttpSession session = request.getSession();
		int empId = (Integer) session.getAttribute("emp1Id");

		Pager pager = new Pager(service.getReadYetCount(empId), pageNum);
		List<Map<String, Object>> list = service.queryReadYet(pager, empId,flag2);
		for (Map map : list){
			System.out.println(map);
		}
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}

	@Action(value = "queryNoRead", results = { @Result(name = "success", location = "/pages/message/QueryNoRead.jsp", type = "dispatcher") })
	public String queryNoRead() {

		HttpSession session = request.getSession();
		int empId = (Integer) session.getAttribute("emp1Id");

		Pager pager = new Pager(service.getNewCount(empId), pageNum);
		List<Map<String, Object>> list = service.queryNoRead(pager, empId,flag2);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}

	@Action("getNewCount")
	public String getNewCount() {
		int newCount = service.getNewCount(message.getRecevId());
		request.setAttribute("newCount", newCount);
		return "success";
	}

}
