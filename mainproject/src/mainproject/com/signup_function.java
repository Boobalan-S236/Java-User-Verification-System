package mainproject.com;
import java.util.*;
import java.sql.*;

public class signup_function {
	private static String u_name;
	private static String u_password;
	private static String con_pass;
	private static String email;
	private static String signup;
	
	public static String getname() {
		return u_name;
	}
	public static  String getpass() {
		return u_password;
	}
	public static void function() throws Exception{
			Scanner scanner = new Scanner(System.in);
			System.out.println("ENTER USERNAME:");
			u_name=scanner.nextLine();
			System.out.println("ENTER PASSWORD");
			u_password=scanner.nextLine();
		
			signup_function.conformpass();
		
	}
	public static void conformpass() throws Exception{
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("CONFIRM PASSWORD:");
		con_pass=scanner.nextLine();
		if(u_password.equals(con_pass)) {
			System.out.println("VERIFIED YOUR PASSWORD");
			signup_function.email();
		}
		else {
			System.err.println("YOUR CONFORMATION PASSWORD IS WRONG");
		}
		
	}
	public static void email() throws Exception{
			Scanner scanner = new Scanner(System.in);
			System.out.println("ENTER EMAIL");
			email=scanner.nextLine();
		
			signup();
		
	}
	public static void signup() throws Exception{
		String s= "SIGNUP";
			Scanner scanner = new Scanner (System.in);
			System.out.println("ENTER IN CAPITAL AS SIGNUP TO PROCEED");
			signup=scanner.nextLine();
		
			if(s.equals(signup)) {
				signup_function.connect_to_db();
			}else {System.err.println("error occur while do SIGNUP");}
		
	}
	public static void connect_to_db() throws Exception{
		
		String query="insert into loginhistory values(?,?,?,?);";
		Connection con=connectiondemo.ConnectionDemo();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, u_name);
		pst.setString(2,u_password);
		pst.setString(3, con_pass);
		pst.setString(4, email);

		pst.executeUpdate();
		
		System.out.print("---------------------------------------------------------------------------------------------");
	}
}
