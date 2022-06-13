package jdbc.com.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Studentjdbc {
	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost:3306/demo";
			String userName = "root";
			String password = "12345";
			Connection con = DriverManager.getConnection(url, userName, password);
			System.out.println("Connected Successfully !!!!");
			Statement st = con.createStatement();
			String sql = "create table studentData(Student_Id int primary key,Student_Name varchar(20) not null, Student_Branch varchar(5) not null)";
			st.executeUpdate(sql);
			System.out.println("Successfully Table Created");
			st.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
}
