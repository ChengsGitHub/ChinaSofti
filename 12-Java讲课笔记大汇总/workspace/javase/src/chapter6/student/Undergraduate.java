package chapter6.student;

public class Undergraduate extends Student {
	
	private String specialty;//רҵ
	private String grade;//�꼶
		
	public Undergraduate(String name, int age, String specialty, String grade) {
		super(name,age);
		this.specialty = specialty;
		this.grade = grade;
	}

	public String getSpecialty() {
		return specialty;
	}

	public String getGrade() {
		return grade;
	}

}