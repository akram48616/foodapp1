package menulaunch;
import java.util.*;

import com.menu.menu;
import com.menudaoimpl.menudaoimpl;
public class launch {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the restaid");
		int restaid=sc.nextInt();
		sc.nextLine();
		System.out.println("enter the item name");
		String itemname=sc.nextLine();
		System.out.println("enter the discription");
		String discription=sc.nextLine();
		System.out.println("enter the price");
		float price=sc.nextFloat();
		System.out.println("enter the available");
		boolean available=sc.nextBoolean();
		System.out.println("enter the rating");
		float rating=sc.nextFloat();
		sc.nextLine();
		System.out.println("enter the imagepath");
		String imagepath=sc.nextLine();
		System.out.println("enter the menucol");
		String menucol=sc.nextLine();
		menu m=new menu(restaid,itemname,discription,price,available,rating,imagepath,menucol);
		menudaoimpl doa=new menudaoimpl();
		doa.addmenu(m);
		
		
		
	}

}
