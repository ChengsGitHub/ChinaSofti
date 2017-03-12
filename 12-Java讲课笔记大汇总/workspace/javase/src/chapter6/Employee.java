package chapter6;

public class Employee {
	
	private String name;
	private double salary;
	private String birthDate;
	
	public Employee() {
		
	}
		
	public Employee(String name) {
		this(name,0.0);				
	}
	
	public Employee(String name, double salary) {
		this(name,salary,null);//调用本类其他重载的构造方法，减少冗余代码		
	}	

	public Employee(String name, double salary, String birthDate) {		
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getDetails() {
		return name + "," + salary + "," + birthDate;
	}
	
	public String toString(){
		return this.name + "," + salary + "," + birthDate;
	}
		
}