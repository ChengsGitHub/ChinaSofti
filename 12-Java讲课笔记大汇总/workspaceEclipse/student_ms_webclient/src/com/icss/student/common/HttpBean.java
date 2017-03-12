package com.icss.student.common;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/**
 * ���ص���HttpClient
 * @author Administrator
 *
 */
public class HttpBean {
	
	private static HttpClient httpClient;
	
	public static HttpClient getHttpClient() {
		
		if (httpClient == null) {
		
			// ���÷��ʳ�ʱʱ��
			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams, 30000);
			HttpConnectionParams.setSoTimeout(httpParams, 30000);
	
			// ����HttpClient�������볬ʱ����
			httpClient = new DefaultHttpClient(httpParams);
			
		}
		
		return httpClient;

	}

}