import java.util.*;

import com.food.model.user;
import com.tap.daoimp.userdaoimpl;
public class launch2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id");
		int id=sc.nextInt();
		userdaoimpl udao=new userdaoimpl();
		user getuserid=udao.getUserId(id);
		System.out.println(getuserid);
	}

}
