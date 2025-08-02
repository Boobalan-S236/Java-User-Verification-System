package mainproject.com;
import java.util.*;
import java.sql.*;

public class Signin {
	
	private static String user_name;
	private static String user_password;
	private static String username;
	private static String pass;
	private static String rechangepassword;
	
	public static void signin() throws Exception {
		Scanner scanner = new Scanner(System.in);
		String pass="YES";
		String p="NO";
		System.out.println("ENTER USER_NAME");
		user_name=scanner.nextLine();
		System.out.println("IF YOU FORGET THE PASSWORD NO ISSUE JUST TYPE AS YES OR NO TO CHANGE PASSWORD");
		rechangepassword=scanner.nextLine();
		if(pass.equals(rechangepassword)) {
			passwordchange.forget_pass();
		}else if(p.equals(rechangepassword)) {
		System.out.println("ENTER PASSWORD");
		user_password=scanner.nextLine();
		Signin.check();
		scanner.close();
		}else {
			System.err.println("oops !..... error occured follow the steps correctly");
		}
	}
	public static void check() throws Exception {
		
		String query="select user_name,user_password from loginhistory  ";
		Connection con=connectiondemo.ConnectionDemo();
		Statement st = con.createStatement();
		ResultSet rs=st.executeQuery(query);
		looplabel:
		while(rs.next()) {
			username=rs.getString(1);
			pass=rs.getString(2);
			
			if(username.equals(user_name) && pass.equals(user_password)) {
				String q="insert into signin values(?,?);";
				
				PreparedStatement pst = con.prepareStatement(q);
				pst.setString(1, username);
				pst.setString(2, pass);
				pst.executeUpdate();
				
				System.err.println("YOUR USER_NAME AND PASSWORD WERE VERIFIED");
				System.out.println("WELCOME !..............");
				break looplabel;
			}else  {
				System.err.println("MISS MATCHED CHECK YOU USER_NAME OR PASSWORD");
			}
			
			
		}
		
		System.out.println("-------------------------------------------------------------------------------------------");
	}
	
}
