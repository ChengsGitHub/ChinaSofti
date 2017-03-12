package chapter8;

public class TestException4 {

	public static void main(String[] args) {

		String[] names = { "tom", "jack", "rose" };

		try {
			
			for (int i = 0; i <= names.length; i++) {
				System.out.println(names[i]);
			}

			System.out.println("循环结束");

		} catch (Exception e) {
			System.out.println("发生了异常：" + e.getMessage());
			e.printStackTrace();
			//return;
		} finally {
			System.out.println("必须会执行的语句");
		}

		System.out.println("程序结束");
	}

}