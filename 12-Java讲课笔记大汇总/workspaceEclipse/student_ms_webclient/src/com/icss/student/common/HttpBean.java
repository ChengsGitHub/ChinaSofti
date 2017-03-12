package com.icss.student.common;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/**
 * 返回单例HttpClient
 * @author Administrator
 *
 */
public class HttpBean {
	
	private static HttpClient httpClient;
	
	public static HttpClient getHttpClient() {
		
		if (httpClient == null) {
		
			// 设置访问超时时间
			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams, 30000);
			HttpConnectionParams.setSoTimeout(httpParams, 30000);
	
			// 创建HttpClient，并传入超时设置
			httpClient = new DefaultHttpClient(httpParams);
			
		}
		
		return httpClient;

	}

}