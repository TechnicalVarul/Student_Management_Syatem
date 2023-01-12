import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import StudentManage.Student;
import StudentManage.StudentToDB;

public class Start {

	public static void main(String[] args) throws IOException,NumberFormatException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to My Student Management App");
		System.out.println("====================================");
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		char ch ='y';
		int choice;
		
		do {
			System.out.println("1. Enter 1 for Add Student");
			System.out.println("2. Enter 2 for Delete Student");
			System.out.println("3. Enter 3 for Update Student");
			System.out.println("4. Enter 4 for Display Student");
			
			choice = Integer.parseInt(input.readLine());
			
			switch (choice) {
			case 1: 
				//Add Student
				System.out.println("Enter Student Name : ");
				String name = input.readLine();
				
				System.out.println("Enter Student City : ");
				String city = input.readLine();
				
				System.out.println("Enter Student Phone : ");
				String phone = input.readLine();
				
				// Creating Object
				Student obj = new Student(name, phone, city);
				
				if(StudentToDB.InsertStudentTODB(obj))
				{
					System.out.println("Student is Added to Database Successfully.....");
				}
				else {
					System.out.println("Something went wrong.....");
				}
				break;
				
			case 2:
				// Delete Student
				System.out.println("Enter Student ID :");
				String userId = input.readLine();
				
				if(StudentToDB.DeleteStudentFromDB(userId))
				{
					System.out.println("Student is Deleted from Database Successfully.....");
				}
				else
				{
					System.out.println("Something went wrong.....");
				}
				break;
				
			case 3:
				// Update Student
				System.out.println("Enter Student ID :");
				String Id = input.readLine();
				
				if(StudentToDB.UpdateStudent(Id))
				{
					System.out.println("Student is Updated from Database Successfully.....");
				}
				else
				{
					System.out.println("Something went wrong.....");
				}
				
			break;
			
			case 4 :
				// Display Student
				StudentToDB.showAllStudents();
				break;

			default :
				System.out.println("Invalid Input......");
				continue;
			}
			System.out.println("Do you want to continue?");
			ch = (char) input.read();
		} while (ch == 'y' || ch =='Y');
		
		System.out.println("Thank You for using My App.....");
		System.out.println("See You soon.....");

	}

}
