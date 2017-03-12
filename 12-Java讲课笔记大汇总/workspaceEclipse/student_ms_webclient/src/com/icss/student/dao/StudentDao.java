package com.icss.student.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;

import com.icss.student.common.Global;
import com.icss.student.common.HttpBean;
import com.icss.student.pojo.Student;

/**
 * 数据访问对象
 * 
 * @author Ambow
 */
public class StudentDao {

	private Context context;

	public StudentDao(Context context) {
		this.context = context;
	}

	/**
	 * 增加数据
	 * 
	 * @param stu
	 */
	public void insert(Student stu) throws Exception {

		
			HttpClient client = HttpBean.getHttpClient();
			String url = "http://" + Global.IP
					+ "/student_webserver/stu/androidInsert.action";
			// 传入URL，创建POST请求对象
			HttpPost httpPost = new HttpPost(url);

			// 使用NameValuePair来保存要传递的Post参数
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			// 向集合中增加键值对
			params.add(new BasicNameValuePair("stuCode", String.valueOf(stu
					.getStuCode())));
			params.add(new BasicNameValuePair("stuName", stu.getStuName()));
			params.add(new BasicNameValuePair("stuPhone", stu.getStuPhone()));

			// 创建请求实体并设置字符集
			HttpEntity httpEntity = new UrlEncodedFormEntity(params, "utf-8");
			// 设置请求的实体
			httpPost.setEntity(httpEntity);

			// 发出请求，返回response对象
			HttpResponse response = client.execute(httpPost);

			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				throw new Exception("请求失败");
			}
		
	}

	/**
	 * 修改数据
	 * 
	 * @param stu
	 */
	public void update(Student stu) throws Exception {

		
			HttpClient client = HttpBean.getHttpClient();
			String url = "http://" + Global.IP
					+ "/student_webserver/stu/androidUpdate.action";
			// 传入URL，创建POST请求对象
			HttpPost httpPost = new HttpPost(url);

			// 使用NameValuePair来保存要传递的Post参数
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			// 向集合中增加键值对
			params.add(new BasicNameValuePair("id", String.valueOf(stu.getId())));
			params.add(new BasicNameValuePair("stuCode", String.valueOf(stu
					.getStuCode())));
			params.add(new BasicNameValuePair("stuName", stu.getStuName()));
			params.add(new BasicNameValuePair("stuPhone", stu.getStuPhone()));

			// 创建请求实体并设置字符集
			HttpEntity httpEntity = new UrlEncodedFormEntity(params, "utf-8");
			// 设置请求的实体
			httpPost.setEntity(httpEntity);

			// 发出请求，返回response对象
			HttpResponse response = client.execute(httpPost);

			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				throw new Exception("请求失败");
			}

	}

	/**
	 * 删除数据
	 * 
	 * @param id
	 */
	public void delete(int id) throws Exception {

		/* 发出请求 */
		HttpClient client = HttpBean.getHttpClient();

		String url = "http://" + Global.IP
				+ "/student_webserver/stu/androidDelete.action?id=" + id;

		HttpGet httpGet = new HttpGet(url);

		HttpResponse response = client.execute(httpGet);

		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			throw new Exception("请求失败");
		}

	}

	/**
	 * 查询单条JSON数据
	 * 
	 * @param id
	 * @return
	 */
	public String queryById(int id) throws Exception {

		/* 发出请求获得json数据 */
		HttpClient client = HttpBean.getHttpClient();

		String url = "http://" + Global.IP
				+ "/student_webserver/stu/androidToUpdate.action?id=" + id;

		HttpGet httpGet = new HttpGet(url);

		HttpResponse response = client.execute(httpGet);

		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			throw new Exception("请求失败");
		}

		String jsonStr = EntityUtils.toString(response.getEntity());

		return jsonStr;
	}

	/**
	 * 分页查询多条数据，返回JSON数据
	 * 
	 * @return
	 */
	public String query(int pageNum) throws Exception {

		/* 发出请求获得json数据 */
		HttpClient client = HttpBean.getHttpClient();

		String url = "http://" + Global.IP
				+ "/student_webserver/stu/androidQuery.action?pageNum=" + pageNum;

		HttpGet httpGet = new HttpGet(url);

		HttpResponse response = client.execute(httpGet);

		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			throw new Exception("请求失败");
		}

		String jsonStr = EntityUtils.toString(response.getEntity());

		return jsonStr;

	}

}