package com.icss.oa.card.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.icss.oa.card.pojo.Card;
import com.icss.oa.card.service.CardService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/Card")
@Results({@Result(name = "success", location = "/Card/query.action", type = "redirect")})
public class CardAction extends BaseAction implements ModelDriven<Card> {

	private Card Card = new Card();

	private int pageNum;// Ò³Âë

	@Autowired
	private CardService service;

	public Card getCard() {
		return Card;
	}

	public void setCard(Card Card) {
		this.Card = Card;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public Card getModel() {
		return Card;
	}

	@Action("insert")
	public String insert() {
		
		HttpSession session = request.getSession();
		Integer empId = (Integer) session.getAttribute("emp1Id");
		Card.setEmpId(empId);
		service.insert(Card);
		return "success";
	}
	
	@Action("delete")
	public String delete() {
		service.delete(Card.getGroupId());
		return "success";
	}
	
	@Action(value="toUpdate", results = { @Result(name = "success", location = "/pages/card/UpdateCard.jsp", type = "dispatcher") })
	public String toUpdate() {
		Card CardObj = service.queryById(Card.getGroupId());
		request.setAttribute("Card", CardObj);
		return "success";
	}
	
	@Action("update")
	public String update() {
		service.update(Card);
		return "success";
	}

	@Action(value = "query", results = { @Result(name = "success", location = "/pages/card/QueryCard.jsp", type = "dispatcher") })
	public String query() {
		HttpSession session = request.getSession();
		int empId = (Integer) session.getAttribute("emp1Id");
		Pager pager = new Pager(service.getCount(empId), pageNum);
		List<Card> list = service.query(pager,empId);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	
	@Action(value = "querySmall", results = { @Result(name = "success", location = "/pages/card/QueryCardSmall.jsp", type = "dispatcher") })
	public String querySmall() {
		HttpSession session = request.getSession();
		int empId = (Integer) session.getAttribute("empId");
		Pager pager = new Pager(service.getCount(empId), pageNum,6);
		List<Card> list = service.query(pager,empId);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}

	@Action("getCardJson")
	public String getCardJson() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
				
		Card CardObj = service.queryById(Card.getGroupId());
		Gson gson = new Gson();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("CardName", CardObj.getGrouName());
		out.write(gson.toJson(map));
		
		return null;
	}
}