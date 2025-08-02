package mainproject.com;
import java.util.*;

public class userchoice {
	
	public static void choice() throws Exception{
		String l="SIGNIN";
		String s="SIGNUP";
			Scanner scanner = new Scanner(System.in); 
			System.out.println("ENTER SIGNIN OR SIGNUP to proceed \n MAKE IT IN CAPTIAL WORDS");
			String choice=scanner.nextLine();
			
			if(s.equals(choice)) {
				signup_function.function();
			}else if(l.equals(choice)) {
				Signin.signin();
			}else {System.err.print("error occur follow steps correctly");}
		
	}	
}
