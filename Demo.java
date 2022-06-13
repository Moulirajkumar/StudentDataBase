package jdbc.com.pack;
import java.sql.*;
public class Demo 
{
	public static void main(String[] args) throws Exception
	{
		String url="jdbc:mysql://localhost:3306/demo";
		String userName="root";
		String password="12345";
		String querry="select * from studenttable";
//		Class.forName("com.mysql.jdbc.Drivers");
		Connection con=DriverManager.getConnection(url,userName, password);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(querry);
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}
		st.close();
		con.close();
		rs.close();
	}
}
