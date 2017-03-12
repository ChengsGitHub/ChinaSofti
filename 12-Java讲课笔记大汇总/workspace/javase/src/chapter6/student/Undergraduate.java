package chapter6.student;

public class Undergraduate extends Student {
	
	private String specialty;//专业
	private String grade;//年级
		
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