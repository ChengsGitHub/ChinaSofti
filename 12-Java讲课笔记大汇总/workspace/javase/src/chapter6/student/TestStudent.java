package chapter6.student;

/*
 *  3.  ѧ���ʹ�ѧ�� 2.png
 */
public class TestStudent {
	
	public static void main(String[] args) {

		Undergraduate m = new Undergraduate("tom", 21, "�������ѧ�뼼��", "����");
		
		System.out.println(m.getName() + "," + m.getAge() + ","
				+ m.getSpecialty() + "," + m.getGrade());

	}

}