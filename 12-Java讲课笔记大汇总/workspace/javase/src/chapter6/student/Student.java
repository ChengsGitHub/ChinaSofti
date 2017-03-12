package chapter6.student;

public class Student {
	private String name;// 学生姓名
	private int age;// 年龄
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

}