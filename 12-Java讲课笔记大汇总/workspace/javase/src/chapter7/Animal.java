package chapter7;

public abstract class Animal {
	
	protected String name;
	
	protected int legs;
		
	public Animal(String name, int legs) {
		super();
		this.name = name;
		this.legs = legs;
	}

	public void eat() {
		System.out.println(name + "����ͳԶ���");
	}
	
	//���󷽷�
	public abstract void run(); 
	
	//ģ�巽�������ó��󷽷�
	public void catchFood() {
		run();
		System.out.println("��ʳ����");
	}

}