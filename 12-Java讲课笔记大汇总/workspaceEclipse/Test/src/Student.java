
public class Student implements Comparable<Student> {

	private int sid;
	
	private String sname;

	public Student(int sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", getSid()="
				+ getSid() + ", getSname()=" + getSname() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public int compareTo(Student o) {
		
		if (this.sid > o.sid)
			return 1;
		else if (this.sid < o.sid)
			return -1;		
		
		return 0;
	}
		
}
