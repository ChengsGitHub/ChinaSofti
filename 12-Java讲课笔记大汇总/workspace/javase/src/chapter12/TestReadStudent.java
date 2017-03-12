package chapter12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestReadStudent {

	public static void main(String[] args) {
				
		try {
			List<Student> list = getStudentList();
			for (Student stu : list) {
				System.out.println(stu);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	/**
	 * 读取student.txt数据文件，返回学生对象List集合	 
	 */
	public static List<Student> getStudentList() throws IOException {
		
		ArrayList<Student> list = new ArrayList<Student>();
		
		FileReader fr = new FileReader("f:\\student.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String s = br.readLine();
		
		while (s != null) {
			String[] ss = s.split("\\|");
			Student stu = new Student(Integer.parseInt(ss[0]),ss[1],ss[2]);
			list.add(stu);
			
			s = br.readLine();
		}
		
		br.close();
		
		return list;
	}
	
}