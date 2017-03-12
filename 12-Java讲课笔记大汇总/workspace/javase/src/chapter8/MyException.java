package chapter8;

/**
 * 自定义异常类 
 */
public class MyException extends Exception {

	private int errorId;//错误号

	public MyException(String message, int errorId) {
		super(message);
		this.errorId = errorId;
	}

	public int getErrorId() {
		return errorId;
	}

	//测试
	public static void main(String[] args) {
		MyException mye = new MyException("这是一个XX异常",1001);
		try {
			throw mye;
		} catch (MyException e) {
			System.out.println("异常信息：" + e.getMessage() + ",错误号：" + e.getErrorId());
		}
	}
	
}