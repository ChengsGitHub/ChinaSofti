package chapter6;

public class Manager extends Employee {
		
	private String department;

	public Manager() {
		
	}

	public Manager(String name, double salary, String birthDate,String department) {
		super(name,salary,birthDate);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDetails() {
		return super.getDetails() + "," + this.department;
	}

	@Override
	public String toString() {		
		return super.toString() + "," + this.department;
	}	

}