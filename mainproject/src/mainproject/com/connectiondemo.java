package mainproject.com;
import java.sql.*;

public class connectiondemo {

	private static final String url="jdbc:mysql://localhost:3306/login";
	private static final String name="root";
	private static final String password="Password@123";
	public static Connection ConnectionDemo() throws Exception{
		
		return DriverManager.getConnection(url,name,password);
		
	}
	
}
