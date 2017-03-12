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
 * ���ݷ��ʶ���
 * 
 * @author Ambow
 */
public class StudentDao {

	private Context context;

	public StudentDao(Context context) {
		this.context = context;
	}

	/**
	 * ��������
	 * 
	 * @param stu
	 */
	public void insert(Student stu) throws Exception {

		
			HttpClient client = HttpBean.getHttpClient();
			String url = "http://" + Global.IP
					+ "/student_webserver/stu/androidInsert.action";
			// ����URL������POST�������
			HttpPost httpPost = new HttpPost(url);

			// ʹ��NameValuePair������Ҫ���ݵ�Post����
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			// �򼯺������Ӽ�ֵ��
			params.add(new BasicNameValuePair("stuCode", String.valueOf(stu
					.getStuCode())));
			params.add(new BasicNameValuePair("stuName", stu.getStuName()));
			params.add(new BasicNameValuePair("stuPhone", stu.getStuPhone()));

			// ��������ʵ�岢�����ַ���
			HttpEntity httpEntity = new UrlEncodedFormEntity(params, "utf-8");
			// ���������ʵ��
			httpPost.setEntity(httpEntity);

			// �������󣬷���response����
			HttpResponse response = client.execute(httpPost);

			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				throw new Exception("����ʧ��");
			}
		
	}

	/**
	 * �޸�����
	 * 
	 * @param stu
	 */
	public void update(Student stu) throws Exception {

		
			HttpClient client = HttpBean.getHttpClient();
			String url = "http://" + Global.IP
					+ "/student_webserver/stu/androidUpdate.action";
			// ����URL������POST�������
			HttpPost httpPost = new HttpPost(url);

			// ʹ��NameValuePair������Ҫ���ݵ�Post����
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			// �򼯺������Ӽ�ֵ��
			params.add(new BasicNameValuePair("id", String.valueOf(stu.getId())));
			params.add(new BasicNameValuePair("stuCode", String.valueOf(stu
					.getStuCode())));
			params.add(new BasicNameValuePair("stuName", stu.getStuName()));
			params.add(new BasicNameValuePair("stuPhone", stu.getStuPhone()));

			// ��������ʵ�岢�����ַ���
			HttpEntity httpEntity = new UrlEncodedFormEntity(params, "utf-8");
			// ���������ʵ��
			httpPost.setEntity(httpEntity);

			// �������󣬷���response����
			HttpResponse response = client.execute(httpPost);

			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				throw new Exception("����ʧ��");
			}

	}

	/**
	 * ɾ������
	 * 
	 * @param id
	 */
	public void delete(int id) throws Exception {

		/* �������� */
		HttpClient client = HttpBean.getHttpClient();

		String url = "http://" + Global.IP
				+ "/student_webserver/stu/androidDelete.action?id=" + id;

		HttpGet httpGet = new HttpGet(url);

		HttpResponse response = client.execute(httpGet);

		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			throw new Exception("����ʧ��");
		}

	}

	/**
	 * ��ѯ����JSON����
	 * 
	 * @param id
	 * @return
	 */
	public String queryById(int id) throws Exception {

		/* ����������json���� */
		HttpClient client = HttpBean.getHttpClient();

		String url = "http://" + Global.IP
				+ "/student_webserver/stu/androidToUpdate.action?id=" + id;

		HttpGet httpGet = new HttpGet(url);

		HttpResponse response = client.execute(httpGet);

		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			throw new Exception("����ʧ��");
		}

		String jsonStr = EntityUtils.toString(response.getEntity());

		return jsonStr;
	}

	/**
	 * ��ҳ��ѯ�������ݣ�����JSON����
	 * 
	 * @return
	 */
	public String query(int pageNum) throws Exception {

		/* ����������json���� */
		HttpClient client = HttpBean.getHttpClient();

		String url = "http://" + Global.IP
				+ "/student_webserver/stu/androidQuery.action?pageNum=" + pageNum;

		HttpGet httpGet = new HttpGet(url);

		HttpResponse response = client.execute(httpGet);

		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			throw new Exception("����ʧ��");
		}

		String jsonStr = EntityUtils.toString(response.getEntity());

		return jsonStr;

	}

}