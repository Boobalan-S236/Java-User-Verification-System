package mainproject.com;
import java.lang.*;
import java.sql.*;
import java.util.*;

public class passwordchange {
	
	private static String new_password;
	private static String user_name;
	private static String old_password;
	private static String current_password;
	private static String confirm_pass;
	
	public static void forget_pass() throws Exception{
			Scanner scanner = new Scanner (System.in); 
			System.out.println("ENTER THE NEW PASSWORD TO PROCEED");
			new_password=scanner.nextLine();
		
		    con_pass();
		    scanner.close();
		
	}
	public static void con_pass() throws Exception{
		
			Scanner scanner = new Scanner(System.in); 
			System.out.println("CONFIRM PASSWORD:");
			confirm_pass=scanner.nextLine();
		
			if(confirm_pass.equals(new_password)) {
				connect_to_db_new_pass();
			}else {
				System.err.println("ENTER CONFORMATION PASSWORD IS WRONG");
			}
			scanner.close();
	}
	public static void connect_to_db_new_pass() throws Exception{
		
		String query="update loginhistory set user_password = ?";
		Connection con =connectiondemo.ConnectionDemo();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, new_password);
		pst.executeUpdate();
		connect_to_db_confirm_pass();
		
	}
	public static void connect_to_db_confirm_pass() throws Exception {
		
		String q="update loginhistory set confirm_pass = ?";
		Connection con=connectiondemo.ConnectionDemo();
		PreparedStatement pst = con.prepareStatement(q);
		pst.setString(1,confirm_pass);
		pst.executeUpdate();
		//Signin.check();
		System.err.println("PASSWORD WHERE CHANGED SUUCCESSFULLY"+ "\n" +"-------------------------------------------------------");
	}
	
}
