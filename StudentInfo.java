package jdbc.com.pack;

import java.sql.*;
import java.util.Scanner;
public class StudentInfo 
{
	public static void insertData() throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Student Id ");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Student Name ");
		String name=sc.nextLine();
		System.out.println("Enter the Branch");
		String branch=sc.next();
		String url="jdbc:mysql://localhost:3306/demo";
		String userName="root";
		String password="12345";
		Connection con=DriverManager.getConnection(url,userName, password);
		String querry="Insert into studentData values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(querry);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, branch);
		ps.executeUpdate();
		System.out.println("Inserted Successfully!!!! ");
		sc.close();
		con.close();
		ps.close();
	}
	public void displayData() throws SQLException
	{
		String url="jdbc:mysql://localhost:3306/demo";
		String userName="root";
		String password="12345";
		String querry="select * from studentData";
//		Class.forName("com.mysql.jdbc.Drivers");
		Connection con=DriverManager.getConnection(url,userName, password);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(querry);
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		st.close();
		con.close();
		rs.close();
	}
	public void deleteData() throws SQLException 
	{
		Scanner sc=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/demo";
		String userName="root";
		String password="12345";
		String querry="delete from studentData where Student_Id=?";
		System.out.println("Enter Id To Delete");
		int id=sc.nextInt();
		Connection con=DriverManager.getConnection(url,userName, password);
		PreparedStatement ps=con.prepareStatement(querry);
		ps.setInt(1, id);
		int i=ps.executeUpdate();
		if(i==1)
		{
			System.out.println("Deleted Successfully");
		}
		else
		{
			System.out.println("RollNumber Does Not Exists");
		}
		sc.close();
		con.close();
		ps.close();
	}
	public static void main(String[] args) throws Exception
	{
		StudentInfo obj1=new StudentInfo();
		obj1.insertData();
		obj1.displayData();
//		obj1.deleteData();
	}
}
