package chapter6.encryptnum;

public class MyNumber {
	
	protected int  num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		if(num>=10000 || num<=999){
			System.out.println("����������һ����λ��");
		}else{
			this.num = num;
		}
		
	}
		
} 