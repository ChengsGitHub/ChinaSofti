package chapter6.student;

/*
 *  3.  学生和大学生 2.png
 */
public class TestStudent {
	
	public static void main(String[] args) {

		Undergraduate m = new Undergraduate("tom", 21, "计算机科学与技术", "大三");
		
		System.out.println(m.getName() + "," + m.getAge() + ","
				+ m.getSpecialty() + "," + m.getGrade());

	}

}