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
 * �Զ��崰��
 */
public class MyFrame extends JFrame {
	
	public JTextField t1 = new JTextField(20);//�ı���
	private JButton b1 = new JButton("OK");//��ť
	private JButton b2 = new JButton("�Ի���");//��ť
	private JButton b3 = new JButton("ȷ�Ͽ�");//��ť
	
	public MyFrame() {
		
		//���ò��ַ�ʽΪ��ʽ����
		this.setLayout(new FlowLayout());
		
		//�������
		this.add(t1);	
		this.add(b1);
		this.add(b2);
		this.add(b3);
		
		//����ťע�ᵥ���¼�
		b1.addActionListener(new BtnClickHandler());
		
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "�绰����Ϊ��");				
			}						
		});
		
		b3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ������Ϣ?", "��ʾ",JOptionPane.YES_NO_OPTION);
				System.out.println(i);
			}						
		});
		
		//�����ڹرհ�ťע���¼�
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}						
		});
		
		this.setTitle("�����޵й���ϵͳ");//���ñ���
		this.setSize(400, 300);//���ô�С		
		this.setLocationRelativeTo(null);//����
		this.setVisible(true);//��ʾ����
	}	
	
	//��ť�����¼�������
	public class BtnClickHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {			 
			String msg = t1.getText();
			System.out.println(msg);
		}		
	}	
	
	public static void main(String[] args) {		
		new MyFrame();//��������
	}

}