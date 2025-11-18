import java.util.*;

import com.food.model.user;
import com.tap.daoimp.userdaoimpl;
public class Launch5 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		userdaoimpl udao = new userdaoimpl();
        user u = udao.getUserId(id);
        udao.deleteUser(id);
		
	}

}
