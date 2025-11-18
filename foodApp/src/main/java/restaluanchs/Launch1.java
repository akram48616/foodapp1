package restaluanchs;
import java.util.*;

import com.rest.food.app.rest;
import com.restdaoimpl.foodapp.restdaoimpl;

public class Launch1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the name");
		String name=sc.nextLine();
		System.out.println("enter the address");
		String address=sc.nextLine();
		System.out.println("enter the phonenumber");
		String phonenumber=sc.nextLine();
		System.out.println("enter the cuisinetype");
		String cuisine_type=sc.nextLine();
		System.out.println("enter the deliverytime");
		String deliverytime=sc.nextLine();
		
		System.out.println("enter the reting");
		String rating=sc.nextLine();
		
		System.out.println("enter the isactive");
		String isactive=sc.nextLine();
		System.out.println("enter the imagepath");
		String image=sc.nextLine();
		System.out.println("enter the userid");
		String userid=sc.nextLine();
		rest u=new rest(name,address,phonenumber,cuisine_type,deliverytime,rating,isactive,image,userid);
		restdaoimpl doao=new restdaoimpl();
		doao.addresta(u);
		
	}

}
