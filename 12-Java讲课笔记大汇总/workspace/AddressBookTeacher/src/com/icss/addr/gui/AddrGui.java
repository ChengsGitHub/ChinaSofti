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
 * GUI�û�������
 * 
 * @author Administrator
 * 
 */
public class AddrGui extends JFrame {

	private JLabel nameLabel = new JLabel("����");
	private JLabel phoneLabel = new JLabel("�绰");
	private JTextField nameTextField = new JTextField(20);
	private JTextField phoneTextField = new JTextField(20);
	private JButton addBtn = new JButton("����");// ��ť
	private JButton updateBtn = new JButton("�޸�");// ��ť
	private JButton deleteBtn = new JButton("ɾ��");// ��ť
	private JButton queryBtn = new JButton("��ѯ");// ��ť
	
	private JLabel dateLabel = new JLabel();//��ʾ��ʱ��

	private AddrDaoImpl dao = new AddrDaoImpl();// ���ݷ��ʶ���

	public AddrGui() {

		// ���ò��ַ�ʽΪ��ʽ����
		this.setLayout(new FlowLayout());

		// �������
		this.add(nameLabel);
		this.add(nameTextField);
		this.add(phoneLabel);
		this.add(phoneTextField);
		this.add(addBtn);
		this.add(updateBtn);
		this.add(deleteBtn);
		this.add(queryBtn);
		this.add(dateLabel);
		
		//����һ���µ��̣߳������߶���ʱ��
		new Thread() {
			public void run() {
				while (true) {
					Date d = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					String dateStr = sdf.format(d);
					dateLabel.setText("���ڵ�ʱ����" + dateStr);
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				}
			}			
		}.start();		

		// ע�ᰴť��ͳһ�¼�����
		BtnClickHandler btnClickHandler = new BtnClickHandler();
		addBtn.addActionListener(btnClickHandler);
		updateBtn.addActionListener(btnClickHandler);
		deleteBtn.addActionListener(btnClickHandler);
		queryBtn.addActionListener(btnClickHandler);

		// �����ڹرհ�ťע���¼�
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setTitle("�����׽�ͨѶ¼ϵͳV1.2");// ���ñ���
		this.setSize(280, 200);// ���ô�С
		this.setLocationRelativeTo(null);// ����
		this.setResizable(false);// ������ı䴰��
		this.setVisible(true);// ��ʾ����
	}

	// ��ť�����¼�������
	public class BtnClickHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String cmd = e.getActionCommand();// ��ť����

			try {
				if (cmd.equals("����")) {
					add();
				} else if (cmd.equals("�޸�")) {
					update();
				} else if (cmd.equals("ɾ��")) {
					delete();
				} else if (cmd.equals("��ѯ")) {
					query();
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				e1.printStackTrace();
			}
		}
	}

	/**
	 * ����
	 * 
	 * @throws Exception
	 */
	public void add() throws Exception {
		// ����ı����ֵ
		String name = nameTextField.getText();
		String phone = phoneTextField.getText();

		if ("".equals(name)) {
			JOptionPane.showMessageDialog(null, "��������Ϊ��");
			return;
		}

		if ("".equals(phone)) {
			JOptionPane.showMessageDialog(null, "�绰����Ϊ��");
			return;
		}

		Person person = new Person(name, phone);

		dao.add(person);

		JOptionPane.showMessageDialog(null, "��Ϣ���ӳɹ�");
	}

	/**
	 * �޸�
	 * 
	 * @throws Exception
	 */
	public void update() throws Exception {
		// ����ı����ֵ
		String name = nameTextField.getText();
		String phone = phoneTextField.getText();

		if ("".equals(name)) {
			JOptionPane.showMessageDialog(null, "��������Ϊ��");
			return;
		}

		if ("".equals(phone)) {
			JOptionPane.showMessageDialog(null, "�绰����Ϊ��");
			return;
		}

		Person person = new Person(name, phone);

		dao.update(person);

		JOptionPane.showMessageDialog(null, "��Ϣ�޸ĳɹ�");
	}

	/**
	 * ɾ��
	 * 
	 * @throws Exception
	 */
	public void delete() throws Exception {
		// ����ı����ֵ
		String name = nameTextField.getText();

		if ("".equals(name)) {
			JOptionPane.showMessageDialog(null, "��������Ϊ��");
			return;
		}

		int i = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ������Ϣ?", "��ʾ",
				JOptionPane.YES_NO_OPTION);

		if (i == 1)
			return;

		dao.delete(name);

		JOptionPane.showMessageDialog(null, "��Ϣɾ���ɹ�");
	}

	/**
	 * ��ѯ
	 * @throws Exception 
	 */
	public void query() throws Exception {

		// ����ı����ֵ
		String name = nameTextField.getText();

		if ("".equals(name)) {
			JOptionPane.showMessageDialog(null, "��������Ϊ��");
			return;
		}
		
		Person p = dao.query(name);
		
		phoneTextField.setText(p.getPhone());
		
	}

}