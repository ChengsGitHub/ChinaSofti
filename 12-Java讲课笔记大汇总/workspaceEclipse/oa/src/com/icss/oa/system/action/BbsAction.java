package com.icss.oa.system.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.oa.common.BaseAction;
import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Bbs;
import com.icss.oa.system.service.BbsService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/bbs")
@Results({@Result(name = "success", location = "/bbs/queryByTime1.action", type = "redirect")})
public class BbsAction extends BaseAction implements ModelDriven<Bbs>{
	
	private Bbs bbs=new Bbs();

	private int pageNum;
	private int source;
	private int setTopId;
	public Bbs getBbs() {
		return bbs;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public void setBbs(Bbs bbs) {
		this.bbs = bbs;
	}

	public int getSetTopId() {
		return setTopId;
	}

	public void setSetTopId(int setTopId) {
		this.setTopId = setTopId;
	}

	@Autowired
	private BbsService service;
	
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public Bbs getModel() {

		return bbs;
	}
	
	@Action("insert")
	public String insert() {
		service.insert(bbs);
		return "success";

	}
	@Action(value="queryOne",results = { @Result(name = "success", location = "/pages/bbs/ReadAnno.jsp", type = "dispatcher")})
	public String queryOne() {
		Bbs bbsObj = service.queryById(bbs.getBbsId());
		String s;
        s= DateFormat.getDateInstance().format(bbsObj.getBbsTime());
        bbsObj.setTime(s);
		request.setAttribute("bbs", bbsObj);
		return "success";
	}
	
    @Action(value="query", results={@Result(name = "manage", location = "/pages/bbs/ManaAnno.jsp",type="dispatcher"),
            @Result(name = "user", location = "/pages/bbs/UserAnno.jsp",type="dispatcher")})
		public String query() {
		int a=2;
		Pager pager = new Pager(service.getCount(),pageNum);
		List<Bbs> list = service.queryByTime(pager);
		String []s=new String[list.size()];
		for(int    i=0;    i<list.size();    i++)    {   
		Bbs    bbs    =    list.get(i);  
		s[i]= DateFormat.getDateInstance().format(bbs.getBbsTime());
		bbs.setTime(s[i]);
		} 
		request.setAttribute("a", a);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		if(source==1)
		return "user";
		else
		return "manage";
		}

    
	@Action(value="queryByTime1", results={@Result(name = "manage", location = "/pages/bbs/ManaAnno.jsp",type="dispatcher"),
              @Result(name = "user", location = "/pages/bbs/UserAnno.jsp",type="dispatcher")})
	public String queryByTime1() {
		int a=1;
		Pager pager = new Pager(service.getCount(),pageNum);
		List<Bbs> list = service.queryByTime1(pager);
		String []s=new String[list.size()];
		   for(int    i=0;    i<list.size();    i++)    {   
		       Bbs    bbs    =    list.get(i);  
		       s[i]= DateFormat.getDateInstance().format(bbs.getBbsTime());
		       bbs.setTime(s[i]);
		   } 
		request.setAttribute("a", a);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		if(source==1)
		return "user";
		else
		return "manage";
	}
    
	
    
    @Action(value="queryByCondition", results={@Result(name = "manage", location = "/pages/bbs/ManaAnno.jsp",type="dispatcher"),
            @Result(name = "user", location = "/pages/bbs/UserAnno.jsp",type="dispatcher")})
	public String queryByCondition() throws Exception {
		String bbsCont=new String(bbs.getBbsCont().getBytes("iso-8859-1"),"utf-8");
		bbs.setBbsCont(bbsCont);
		int a=3;
		Pager pager = new Pager(service.getConditionCount(bbs.getBbsCont()), pageNum );
		List<Bbs> list = service.querByCondition(pager, bbs.getBbsCont());
		String []s=new String[list.size()];
		   for(int    i=0;    i<list.size();    i++)    {   
		       Bbs    bbs    =    list.get(i);  
		       s[i]= DateFormat.getDateInstance().format(bbs.getBbsTime());
		       bbs.setTime(s[i]);
		   } 
		request.setAttribute("a", a);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);	
		if(source==1)
		return "user";
		else
		return "manage";
	}

	@Action(value = "delete", results = { @Result(name = "success", location = "/bbs/queryByTime1.action", type = "redirect") })
	public String delete() {
		service.delete(bbs.getBbsId());
		return "success";
	}
	@Action(value="toUpdate", results = { @Result(name = "success", location = "/pages/bbs/EditAnno.jsp", type = "dispatcher") })
	public String toUpdate() {
		int a=1;
		Bbs bbsObj = service.queryById(bbs.getBbsId());
		request.setAttribute("bbs", bbsObj);
		request.setAttribute("a", a);
		return "success";
	}
	@Action(value = "update", results = { @Result(name = "success", location = "/bbs/queryByTime1.action", type = "redirect") })
	public String update() {
    	System.out.println("打印BBSTOP");
    	System.out.println(bbs.getBbsTop());
    	System.out.println("打印BBSID");
    	System.out.println(bbs.getBbsId());
		service.update(bbs);
		return "success";
	}
	@Action(value = "setTop", results = { @Result(name = "success", location = "/bbs/queryByTime1.action", type = "redirect") })
	public String setTop() {
		service.setTop(setTopId);;
		return "success";
	}
	@Action(value = "cancelTop", results = { @Result(name = "success", location = "/bbs/queryByTime1.action", type = "redirect") })
	public String cancelTop() {
		service.cancelTop(setTopId);
		return "success";
	}
	
	/**
	 * 提供手机端数据访问接口，返回员工JSON数据
	 * @throws IOException 
	 */
	@Action(value = "androidQuery", results = { @Result(name = "success", location = "/pages/bbs/UserAnno.jsp", type = "dispatcher") })
	public String androidQuery() throws IOException {
		
		/*HttpSession session = request.getSession();
		Integer empId = (Integer) session.getAttribute("emp1Id");*/
		
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Pager pager = new Pager(service.getCount(), pageNum);
		List<Bbs> list = service.query(pager);
		
		List<Map> list2 = new ArrayList<Map>();
		
		for (Bbs s : list) {
			HashMap<String, Object> map = new HashMap<String,Object>();
			map.put("bbsId", s.getBbsId());
			map.put("bbsTime", s.getBbsTime());
			map.put("bbsCont", s.getBbsCont());
			list2.add(map);
		}
		
		Gson gson = new GsonBuilder()  
		  .setDateFormat("yyyy-MM-dd")  
		  .create();  
		
		HashMap jsonMap = new HashMap();
		jsonMap.put("pageCount", pager.getPageCount());
		jsonMap.put("list", list2);
		
		String jsonStr = gson.toJson(jsonMap);
		
		System.out.println(jsonStr);
		

		out.write(jsonStr);
		
		
		
		return null;
	}

}
