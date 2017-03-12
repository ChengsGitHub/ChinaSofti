package chapter9;

/**
 * Bean类，封装学生数据
 * @author Administrator
 *
 */

public class Student {

	private int id;
	
	private String name;
	
	private String sex;

	public Student() {
		super();
	}

	public Student(int id, String name, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
	}

	@MyAnnotation(id=1001,name="tom")
	public int getId() {
		return id;
	}

	@MyAnnotation(id=1002,name="jack")
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@MyAnnotation(id=1003,name="rose")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String toString() {
		return this.id + "," + this.name + "," + this.sex;
	}

}