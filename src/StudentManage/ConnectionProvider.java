package StudentManage;

import java.sql.DriverManager;

import java.sql.Connection;

public class ConnectionProvider {
	static Connection con;
	public static Connection CreateConnection() {
		try {
			
			// Load The driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Creating Connection
			String url = "jdbc:mysql://localhost:3306/student_manage";
			String user = "root";
			String password = "101845";
			
			con = DriverManager.getConnection(url,user,password);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
	}

}
