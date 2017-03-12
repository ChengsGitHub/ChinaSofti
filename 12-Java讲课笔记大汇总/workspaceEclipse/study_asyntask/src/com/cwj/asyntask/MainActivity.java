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
	private ProgressDialog progress;//�������Ի���
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        startTaskButton = (Button) this.findViewById(R.id.startTask);       
        text1 = (TextView) this.findViewById(R.id.text1);
        
        //������ťִ�������첽����
        startTaskButton.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				
				//�첽�����ڲ��࣬�������Ͳ�������ս���
			    class MyTask extends AsyncTask<String, Integer, String> {
			    	
			    	//���췽��������Ĭ����������
			    	public MyTask(Context context) {
			    		progress = new ProgressDialog(context);
			    	}
			    	
			    	//����ִ��ǰ�ص�����
					@Override
					protected void onPreExecute() {	
						//progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//������������ʽ
						progress.setTitle("��ʾ");
						progress.setMessage("�첽���������"); 
						progress.show();
					}

					//����ִ���лص�����
					@Override
					protected String doInBackground(String... params) {			
						//��ʱparam[0]����1.txt
						System.out.println(params[0]);
						
						StringBuffer sb = new StringBuffer("abcdefg");
						
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {				
							e.printStackTrace();
						}
									
						return sb.toString();
					}
					
					/*��������и��½������Ļص�����,������������Ľ���ֵ
					 * ��Ҫ��doInBackground�������ֶ�����publishProgress(xxx values)��ֵ������
					*/
					@Override
					protected void onProgressUpdate(Integer... values) {
						//�������ͬ���裬ɾ��Ҳ����
						progress.setProgress(values[0]);
					}

					//���������ص�����
					@Override
					protected void onPostExecute(String result) {
						progress.dismiss();//ȥ��������
						Toast.makeText(MainActivity.this, "�첽����ִ�����",3000).show();
						text1.setText(result);//�ѷ���ֵ����ʹ��
					}	
			    	
			    }
				
				MyTask myTask = new MyTask(MainActivity.this);
				myTask.execute("1.txt");//1.txt��ִ������ʱ�����һ����������������п����ޣ����Ǳ��봩����
				//myTask.execute();
			}
		});
    }
    
    
    
}