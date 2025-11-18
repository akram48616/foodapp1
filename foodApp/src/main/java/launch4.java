import java.util.List;


import com.food.model.user;
import com.tap.daoimp.userdaoimpl;

public class launch4 {
	public static void main(String[] args) {
	userdaoimpl udao = new userdaoimpl();
    List<user> users = udao.getAllUsers();

    System.out.println("All Registered Users:");
    for (user u : users) {
        System.out.println(u);
    }
	}

		

}
