package chapter12;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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