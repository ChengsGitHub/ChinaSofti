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
 * 显示学生列表的画面
 * @author Ambow
 */
public class MainActivity extends Activity {
	
	private WebView webView;//web浏览器对象
	
	private StudentDao dao = new StudentDao(this);//dao对象
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		//全屏显示
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
								
		 //获得WebView控件
        webView = (WebView) this.findViewById(R.id.webView); 
        
        //去掉右边滚动条占位
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        
        //设置支持javascript
        webView.getSettings().setJavaScriptEnabled(true);   
        
        //允许弹出对话框
        webView.setWebChromeClient(new WebChromeClient());
                
        //设置js访问的接口对象，stu就相当于js中的window,document对象一样
        webView.addJavascriptInterface(new StudentPlugin(), "stu");
        
        //加载本地网页
        webView.loadUrl("file:///android_asset/SystemParam.html"); 
	}
	
	/**
	 * js调用的接口类
	 */
	public class StudentPlugin {
		
		/*查询返回分页数据*/
		public String query(int pageNum) {
												
			String jsonArray = null;
						
			try {
				//获得学生json数据集合
				jsonArray = dao.query(pageNum);
				Log.i("syso", "调用原生query方法");
				Log.i("syso", jsonArray);
					
			} catch (Exception e) {				
				Toast.makeText(MainActivity.this, "查询数据失败" + e.getMessage(),Toast.LENGTH_LONG).show();
				e.printStackTrace();
			}	
			
			return jsonArray;
		}
		
		/*增加数据*/
		public void add(String jsonStr) {
			try {
				JSONObject json = new JSONObject(jsonStr);
				
				Log.i("syso", "调用原生add方法");
				Log.i("syso", jsonStr);
				
				Student stu = new Student();
				stu.setStuCode(json.getInt("stuCode"));
				stu.setStuName(json.getString("stuName"));
				stu.setStuPhone(json.getString("stuPhone"));
				
				dao.insert(stu);
			} catch (Exception e) {		
				Toast.makeText(MainActivity.this, "增加数据失败" + e.getMessage(), Toast.LENGTH_LONG).show();
				e.printStackTrace();
			}			
		}
		
		/*删除数据*/
		public void del(int id) {
			try {
				Log.i("syso", "调用原生del方法");
				Log.i("syso", "id=" + id);
				dao.delete(id);
			} catch (Exception e) {
				Toast.makeText(MainActivity.this, "删除数据失败" + e.getMessage(), Toast.LENGTH_LONG).show();
				e.printStackTrace();
			}
		}
		
		/*拨打电话*/
		public void call(String phoneNumber) {
			//创建一个意图
			Intent intent = new Intent();
			//设置意图的动作(打电话)			
			intent.setAction(Intent.ACTION_CALL);
			//设置意图的数据（电话号码）
			intent.setData(Uri.parse("tel:" + phoneNumber));
			
			//启动执行意图(即可以利用系统自带电话拨打服务拨打电话)
			MainActivity.this.startActivity(intent);
		}
		
		/*设置IP地址*/
		public void setIP(String ip) {
			Global.IP = ip;
		}
		
	}
		
	/**
	 * 硬件菜单	
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		menu.add(0, 1, 1, "退出系统");
		menu.add(0, 2, 2, "说明");
		
		return super.onCreateOptionsMenu(menu);
	}
	
	/**
		当菜单项被选择
	*/
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (item.getItemId() == 1) {	
			//退出当前程序
			System.exit(0);
		}else if (item.getItemId() == 2) {
			Toast.makeText(MainActivity.this, "本系统是由XXX公司制作", 0).show();
		}
		
		//固定返回值
		return super.onOptionsItemSelected(item);
	}	
	
	/**
	 * 返回键检测：退出提示
	 */
	@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		    if (keyCode == KeyEvent.KEYCODE_BACK) {
		    	
		    	//如果浏览器可以后退
		    	if (webView.canGoBack()) {
		    		webView.goBack();       
		            return true;      
		    	}
		    		
		    	AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
				.setTitle("操作提示")
				.setMessage("确定要退出本系统吗？");
							
				//设置一个确定按钮同时设置监听器
				builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						System.exit(0);											
					}					
				});
				
				//设置一个取消按钮同时设置监听器
				builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {	
					@Override
					public void onClick(DialogInterface dialog, int which) {
											
					}
				});
				
				//显示对话框
				builder.show();	
            		
                return false;
            }
            
            return super.onKeyDown(keyCode, event);
    }
	
}