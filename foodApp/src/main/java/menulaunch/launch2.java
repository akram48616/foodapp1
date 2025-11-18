package menulaunch;
import java.util.*;

import com.menu.menu;
import com.menudaoimpl.menudaoimpl;
public class launch2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		menudaoimpl dao=new menudaoimpl();
		menu getmenuId=dao.getmenuId(id);
		System.out.println(getmenuId);
		sc.close();
	}

}
