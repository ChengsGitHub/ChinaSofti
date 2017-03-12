package Job3;

/**
 * 猜拳规则
 * @author Administrator
 *
 */
public class Rule {
	
	int count = 0;
	
	Computer computer;//系统
	
	Person person;//用户

	/**
	 * 判断猜拳输赢
	 */
	public void ruleFist() {
		if (computer.num == person.num) {
			System.out.println("和局，真衰！嘿嘿，等着瞧吧！");
		} else {
			
			if (person.num == 1) {
				if (computer.num == 3) {
					System.out.println("恭喜，你赢了!");
					person.score++;
				} else {
					System.out.println("^_^，你输了，真笨！");
					computer.score++;
				}
			}
			
			if (person.num == 2) {
				if (computer.num == 1) {
					System.out.println("恭喜，你赢了!");
					person.score++;
				} else {
					System.out.println("^_^，你输了，真笨！");
					computer.score++;
				}
			}
			
			if (person.num == 3) {
				if (computer.num == 2) {
					System.out.println("恭喜，你赢了!");
					person.score++;
				} else {
					System.out.println("^_^，你输了，真笨！");
					computer.score++;
				}
			}
		}
	}

	/**
	 * 积分比较
	 */
	public void showResult() {
		if (computer.score > person.score) {
			System.out.println("结果：呵呵，笨笨，下次加油啊！");
		} else if (computer.score < person.score) {
			System.out.println("结果：轻松胜利");
		} else if (computer.score == person.score) {
			System.out.println("结果：平手，下次再战");
		}
	}
}
