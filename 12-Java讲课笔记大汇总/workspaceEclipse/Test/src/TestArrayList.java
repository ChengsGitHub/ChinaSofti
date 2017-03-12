import java.util.ArrayList;
import java.util.Collections;


public class TestArrayList {

	public static void main(String[] args) {
		
		ArrayList<Student> list = new ArrayList<Student>();
		
		list.add(new Student(111,"tom"));
		list.add(new Student(101,"jack"));
		list.add(new Student(105,"rose"));
		list.add(new Student(107,"john"));

		Collections.sort(list);
		
		for (Student stu : list) {
			System.out.println(stu);
		}
	}

}