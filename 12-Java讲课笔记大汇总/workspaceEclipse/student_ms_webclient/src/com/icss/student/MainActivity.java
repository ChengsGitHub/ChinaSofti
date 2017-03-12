package com.icss.student;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

import com.icss.student.common.Global;
import com.icss.student.dao.StudentDao;
import com.icss.student.pojo.Student;

/**
 * ��ʾѧ���б�Ļ���
 * @author Ambow
 */
public class MainActivity extends Activity {
	
	private WebView webView;//web���������
	
	private StudentDao dao = new StudentDao(this);//dao����
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		//ȫ����ʾ
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
								
		 //���WebView�ؼ�
        webView = (WebView) this.findViewById(R.id.webView); 
        
        //ȥ���ұ߹�����ռλ
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        
        //����֧��javascript
        webView.getSettings().setJavaScriptEnabled(true);   
        
        //�������Ի���
        webView.setWebChromeClient(new WebChromeClient());
                
        //����js���ʵĽӿڶ���stu���൱��js�е�window,document����һ��
        webView.addJavascriptInterface(new StudentPlugin(), "stu");
        
        //���ر�����ҳ
        webView.loadUrl("file:///android_asset/SystemParam.html"); 
	}
	
	/**
	 * js���õĽӿ���
	 */
	public class StudentPlugin {
		
		/*��ѯ���ط�ҳ����*/
		public String query(int pageNum) {
												
			String jsonArray = null;
						
			try {
				//���ѧ��json���ݼ���
				jsonArray = dao.query(pageNum);
				Log.i("syso", "����ԭ��query����");
				Log.i("syso", jsonArray);
					
			} catch (Exception e) {				
				Toast.makeText(MainActivity.this, "��ѯ����ʧ��" + e.getMessage(),Toast.LENGTH_LONG).show();
				e.printStackTrace();
			}	
			
			return jsonArray;
		}
		
		/*��������*/
		public void add(String jsonStr) {
			try {
				JSONObject json = new JSONObject(jsonStr);
				
				Log.i("syso", "����ԭ��add����");
				Log.i("syso", jsonStr);
				
				Student stu = new Student();
				stu.setStuCode(json.getInt("stuCode"));
				stu.setStuName(json.getString("stuName"));
				stu.setStuPhone(json.getString("stuPhone"));
				
				dao.insert(stu);
			} catch (Exception e) {		
				Toast.makeText(MainActivity.this, "��������ʧ��" + e.getMessage(), Toast.LENGTH_LONG).show();
				e.printStackTrace();
			}			
		}
		
		/*ɾ������*/
		public void del(int id) {
			try {
				Log.i("syso", "����ԭ��del����");
				Log.i("syso", "id=" + id);
				dao.delete(id);
			} catch (Exception e) {
				Toast.makeText(MainActivity.this, "ɾ������ʧ��" + e.getMessage(), Toast.LENGTH_LONG).show();
				e.printStackTrace();
			}
		}
		
		/*����绰*/
		public void call(String phoneNumber) {
			//����һ����ͼ
			Intent intent = new Intent();
			//������ͼ�Ķ���(��绰)			
			intent.setAction(Intent.ACTION_CALL);
			//������ͼ�����ݣ��绰���룩
			intent.setData(Uri.parse("tel:" + phoneNumber));
			
			//����ִ����ͼ(����������ϵͳ�Դ��绰������񲦴�绰)
			MainActivity.this.startActivity(intent);
		}
		
		/*����IP��ַ*/
		public void setIP(String ip) {
			Global.IP = ip;
		}
		
	}
		
	/**
	 * Ӳ���˵�	
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		menu.add(0, 1, 1, "�˳�ϵͳ");
		menu.add(0, 2, 2, "˵��");
		
		return super.onCreateOptionsMenu(menu);
	}
	
	/**
		���˵��ѡ��
	*/
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (item.getItemId() == 1) {	
			//�˳���ǰ����
			System.exit(0);
		}else if (item.getItemId() == 2) {
			Toast.makeText(MainActivity.this, "��ϵͳ����XXX��˾����", 0).show();
		}
		
		//�̶�����ֵ
		return super.onOptionsItemSelected(item);
	}	
	
	/**
	 * ���ؼ���⣺�˳���ʾ
	 */
	@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		    if (keyCode == KeyEvent.KEYCODE_BACK) {
		    	
		    	//�����������Ժ���
		    	if (webView.canGoBack()) {
		    		webView.goBack();       
		            return true;      
		    	}
		    		
		    	AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
				.setTitle("������ʾ")
				.setMessage("ȷ��Ҫ�˳���ϵͳ��");
							
				//����һ��ȷ����ťͬʱ���ü�����
				builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						System.exit(0);											
					}					
				});
				
				//����һ��ȡ����ťͬʱ���ü�����
				builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {	
					@Override
					public void onClick(DialogInterface dialog, int which) {
											
					}
				});
				
				//��ʾ�Ի���
				builder.show();	
            		
                return false;
            }
            
            return super.onKeyDown(keyCode, event);
    }
	
}