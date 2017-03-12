package chapter13;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * 自定义窗体
 */
public class MyFrame extends JFrame {
	
	public JTextField t1 = new JTextField(20);//文本框
	private JButton b1 = new JButton("OK");//按钮
	private JButton b2 = new JButton("对话框");//按钮
	private JButton b3 = new JButton("确认框");//按钮
	
	public MyFrame() {
		
		//设置布局方式为流式布局
		this.setLayout(new FlowLayout());
		
		//增加组件
		this.add(t1);	
		this.add(b1);
		this.add(b2);
		this.add(b3);
		
		//给按钮注册单击事件
		b1.addActionListener(new BtnClickHandler());
		
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "电话不能为空");				
			}						
		});
		
		b3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "确定要删除此信息?", "提示",JOptionPane.YES_NO_OPTION);
				System.out.println(i);
			}						
		});
		
		//给窗口关闭按钮注册事件
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}						
		});
		
		this.setTitle("超级无敌管理系统");//设置标题
		this.setSize(400, 300);//设置大小		
		this.setLocationRelativeTo(null);//居中
		this.setVisible(true);//显示窗体
	}	
	
	//按钮单击事件处理类
	public class BtnClickHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {			 
			String msg = t1.getText();
			System.out.println(msg);
		}		
	}	
	
	public static void main(String[] args) {		
		new MyFrame();//启动窗体
	}

}