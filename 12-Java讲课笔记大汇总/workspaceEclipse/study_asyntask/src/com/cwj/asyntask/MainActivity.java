package com.cwj.asyntask;

import java.io.BufferedReader;
import java.io.FileReader;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    
	private Button startTaskButton;
	private TextView text1;
	private ProgressDialog progress;//进度条对话框
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        startTaskButton = (Button) this.findViewById(R.id.startTask);       
        text1 = (TextView) this.findViewById(R.id.text1);
        
        //单击按钮执行启动异步任务
        startTaskButton.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				
				//异步任务内部类，三个泛型参数请参照讲义
			    class MyTask extends AsyncTask<String, Integer, String> {
			    	
			    	//构造方法，参数默认是上下文
			    	public MyTask(Context context) {
			    		progress = new ProgressDialog(context);
			    	}
			    	
			    	//任务执行前回调方法
					@Override
					protected void onPreExecute() {	
						//progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//带进度条的样式
						progress.setTitle("提示");
						progress.setMessage("异步任务进行中"); 
						progress.show();
					}

					//任务执行中回调方法
					@Override
					protected String doInBackground(String... params) {			
						//此时param[0]就是1.txt
						System.out.println(params[0]);
						
						StringBuffer sb = new StringBuffer("abcdefg");
						
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {				
							e.printStackTrace();
						}
									
						return sb.toString();
					}
					
					/*任务进行中更新进度条的回调方法,参数就是任务的进度值
					 * 需要在doInBackground方法中手动调用publishProgress(xxx values)把值传过来
					*/
					@Override
					protected void onProgressUpdate(Integer... values) {
						//此语句形同虚设，删除也可以
						progress.setProgress(values[0]);
					}

					//任务结束后回调方法
					@Override
					protected void onPostExecute(String result) {
						progress.dismiss();//去掉进度条
						Toast.makeText(MainActivity.this, "异步任务执行完毕",3000).show();
						text1.setText(result);//把返回值进行使用
					}	
			    	
			    }
				
				MyTask myTask = new MyTask(MainActivity.this);
				myTask.execute("1.txt");//1.txt是执行任务时传入的一到多个参数，可以有可以无，不是必须穿参数
				//myTask.execute();
			}
		});
    }
    
    
    
}