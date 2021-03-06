package chapter2;

/**
 * 读取dept.txt数据插入到dept表中
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class TestInsertDept {

	public static void main(String[] args) throws  Exception {
		
		//文件输入流
		FileReader fr=new FileReader("f:\\dept.txt");
		BufferedReader br=new BufferedReader(fr);
		String s=br.readLine();
			
		DriverManager.registerDriver(new OracleDriver());

		String url = "jdbc:oracle:thin:@localhost:1521:icss";
		String user = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, user, password);
		
		String sql="insert into dept values(?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
			
		//循环读取数据文件，分解字符串插入数据库
		while(s!=null){
			
			String[] st = s.split(",");
			
			pstmt.setInt(1, Integer.parseInt(st[0]) );
			pstmt.setString(2, st[1] );
			pstmt.setString(3, st[2] );
			
	        pstmt.executeUpdate();
	     
			s = br.readLine();			
		}
			

		pstmt.close();
		conn.close();		
	}

}
