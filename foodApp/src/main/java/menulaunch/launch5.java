package menulaunch;
import java.util.*;

import com.menu.menu;
import com.menudaoimpl.menudaoimpl;
public class launch5 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the name of the id");
		int id=sc.nextInt();
		menudaoimpl dao=new menudaoimpl();
		menu m=dao.getmenuId(id);
		dao.deletermenu(id);
	}

}
