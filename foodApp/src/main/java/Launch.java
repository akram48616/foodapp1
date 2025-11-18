import java.util.*;

import com.food.model.user;
import com.tap.daoimp.userdaoimpl;
public class Launch {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the name");
		String name=sc.next();
		System.out.println("enter the username");
		String username=sc.next();
		System.out.println("enter the password");
		String password=sc.next();
		System.out.println("enter the email");
		String email=sc.next();
		System.out.println("enter the phonenumber");
		String phonenumber=sc.next();
		System.out.println("enter the address");
		String address=sc.next();
		System.out.println("enter the role");
		String role=sc.next();
		user u=new user(name,username,password,email,phonenumber,address,role);
		userdaoimpl udao=new userdaoimpl();
		udao.addUser(u);
		
		
	}

}
