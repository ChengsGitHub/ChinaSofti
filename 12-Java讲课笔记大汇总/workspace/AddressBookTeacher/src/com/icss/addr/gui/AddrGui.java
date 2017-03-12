package com.icss.addr.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.icss.addr.dao.impl.AddrDaoImpl;
import com.icss.addr.pojo.Person;

/**
 * GUI用户界面类
 * 
 * @author Administrator
 * 
 */
public class AddrGui extends JFrame {

	private JLabel nameLabel = new JLabel("姓名");
	private JLabel phoneLabel = new JLabel("电话");
	private JTextField nameTextField = new JTextField(20);
	private JTextField phoneTextField = new JTextField(20);
	private JButton addBtn = new JButton("增加");// 按钮
	private JButton updateBtn = new JButton("修改");// 按钮
	private JButton deleteBtn = new JButton("删除");// 按钮
	private JButton queryBtn = new JButton("查询");// 按钮
	
	private JLabel dateLabel = new JLabel();//显示的时间

	private AddrDaoImpl dao = new AddrDaoImpl();// 数据访问对象

	public AddrGui() {

		// 设置布局方式为流式布局
		this.setLayout(new FlowLayout());

		// 增加组件
		this.add(nameLabel);
		this.add(nameTextField);
		this.add(phoneLabel);
		this.add(phoneTextField);
		this.add(addBtn);
		this.add(updateBtn);
		this.add(deleteBtn);
		this.add(queryBtn);
		this.add(dateLabel);
		
		//启动一个新的线程，设置走动的时间
		new Thread() {
			public void run() {
				while (true) {
					Date d = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					String dateStr = sdf.format(d);
					dateLabel.setText("现在的时间是" + dateStr);
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				}
			}			
		}.start();		

		// 注册按钮的统一事件处理
		BtnClickHandler btnClickHandler = new BtnClickHandler();
		addBtn.addActionListener(btnClickHandler);
		updateBtn.addActionListener(btnClickHandler);
		deleteBtn.addActionListener(btnClickHandler);
		queryBtn.addActionListener(btnClickHandler);

		// 给窗口关闭按钮注册事件
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setTitle("超级白金通讯录系统V1.2");// 设置标题
		this.setSize(280, 200);// 设置大小
		this.setLocationRelativeTo(null);// 居中
		this.setResizable(false);// 不允许改变窗口
		this.setVisible(true);// 显示窗体
	}

	// 按钮单击事件处理类
	public class BtnClickHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String cmd = e.getActionCommand();// 按钮文字

			try {
				if (cmd.equals("增加")) {
					add();
				} else if (cmd.equals("修改")) {
					update();
				} else if (cmd.equals("删除")) {
					delete();
				} else if (cmd.equals("查询")) {
					query();
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				e1.printStackTrace();
			}
		}
	}

	/**
	 * 增加
	 * 
	 * @throws Exception
	 */
	public void add() throws Exception {
		// 获得文本框的值
		String name = nameTextField.getText();
		String phone = phoneTextField.getText();

		if ("".equals(name)) {
			JOptionPane.showMessageDialog(null, "姓名不能为空");
			return;
		}

		if ("".equals(phone)) {
			JOptionPane.showMessageDialog(null, "电话不能为空");
			return;
		}

		Person person = new Person(name, phone);

		dao.add(person);

		JOptionPane.showMessageDialog(null, "信息增加成功");
	}

	/**
	 * 修改
	 * 
	 * @throws Exception
	 */
	public void update() throws Exception {
		// 获得文本框的值
		String name = nameTextField.getText();
		String phone = phoneTextField.getText();

		if ("".equals(name)) {
			JOptionPane.showMessageDialog(null, "姓名不能为空");
			return;
		}

		if ("".equals(phone)) {
			JOptionPane.showMessageDialog(null, "电话不能为空");
			return;
		}

		Person person = new Person(name, phone);

		dao.update(person);

		JOptionPane.showMessageDialog(null, "信息修改成功");
	}

	/**
	 * 删除
	 * 
	 * @throws Exception
	 */
	public void delete() throws Exception {
		// 获得文本框的值
		String name = nameTextField.getText();

		if ("".equals(name)) {
			JOptionPane.showMessageDialog(null, "姓名不能为空");
			return;
		}

		int i = JOptionPane.showConfirmDialog(null, "确定要删除此信息?", "提示",
				JOptionPane.YES_NO_OPTION);

		if (i == 1)
			return;

		dao.delete(name);

		JOptionPane.showMessageDialog(null, "信息删除成功");
	}

	/**
	 * 查询
	 * @throws Exception 
	 */
	public void query() throws Exception {

		// 获得文本框的值
		String name = nameTextField.getText();

		if ("".equals(name)) {
			JOptionPane.showMessageDialog(null, "姓名不能为空");
			return;
		}
		
		Person p = dao.query(name);
		
		phoneTextField.setText(p.getPhone());
		
	}

}