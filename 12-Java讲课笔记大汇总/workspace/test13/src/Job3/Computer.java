package Job3;

/**
 * 系统
 * @author Administrator
 *
 */
public class Computer {
	
	public int score=0;//积分
	public int num;//随机剪子1石头2布3
	public String name;//随机人物姓名
	
	/**
	 * 随机返回人物姓名
	 * @return
	 */
	public String computerHero() {
		int a = (int) ((3 - 1 + 1) * Math.random() + 1);
		if (a == 1)
			return name = "刘备";
		if (a == 2)
			return name = "孙权";
		else
			return name = "曹操";
	}

	/**
	 * 随机产生石头剪子布
	 */
	public void showFist() {
		num = (int) ((3 - 1 + 1) * Math.random() + 1);
		if (num == 1) {
			System.out.println("电脑出拳：剪刀");
		} else if (num == 2) {
			System.out.println("电脑出拳：石头");
		} else if (num == 3) {
			System.out.println("电脑出拳：布");
		}
	}
	
}