package StudentManage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentToDB {
	
	public static boolean InsertStudentTODB(Student st)
	{
		boolean status = false;
		
		try {
			Connection con = ConnectionProvider.CreateConnection();
			
			// Fire Query
			String q = "insert into student(sname,sphone,scity) values(?,?,?)";
			
			// Prepare Statement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			// setting Parameters
			pstmt.setString(1, st.getSname());
			pstmt.setString(2, st.getSphone());
			pstmt.setString(3, st.getScity());
			
			// Execute
			pstmt.executeUpdate();
			
			status = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}
	
	public static boolean DeleteStudentFromDB(String userId)
	{
		boolean status = false;
		
		try {
			Connection con = ConnectionProvider.CreateConnection();
			
			// Fire Query
			String q = "delete from student where sid = ?";
			
			// Prepare Statement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			// setting Parameters
			pstmt.setString(1, userId);
			
			// Execute
			pstmt.executeUpdate();
			
			status = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}

	public static void showAllStudents()
	{
		
		try {
			Connection con = ConnectionProvider.CreateConnection();
			
			// Fire Query
			String q = "select * from student";
			
			Statement stmt = con.createStatement();
			
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next())
			{
				String ID = set.getString(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(2);

				System.out.println("ID : " + ID);
				System.out.println("Name : " + name);
				System.out.println("Phone : " + phone);
				System.out.println("City : " + city);
				System.out.println("---------------------------------------------------------------");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static boolean UpdateStudent(String userId)
	{
		boolean status = false;
		
		try {
			Connection con = ConnectionProvider.CreateConnection();
			
			// Fire Query
			String q = "UPDATE student SET sname = ?, scity = ?, sphone=? WHERE sid = ?";
			
			// Prepare Statement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			// setting Parameters
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter Name :");
			String name = input.readLine();
			
			System.out.println("Enter Phone :");
			String phone = input.readLine();
			
			System.out.println("Enter City :");
			String city = input.readLine();
			
			pstmt.setString(1, name);
			pstmt.setString(2, city);
			pstmt.setString(3, phone);
			pstmt.setString(4, userId);
			
			// Execute
			pstmt.executeUpdate();
			
			status = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}

	
}
