package menulaunch;

import java.util.List;

import com.menu.menu;
import com.menudaoimpl.menudaoimpl;

public class launch3 {
	public static void main(String[] args) {
		menudaoimpl dao=new menudaoimpl();
		List<menu> menu=dao.getmenu();
		System.out.println("all resgistered menu");
		for(menu m:menu) {
			System.out.println(m);
		}
	}

}
