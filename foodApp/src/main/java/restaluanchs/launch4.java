package restaluanchs;
import java.util.*;

import com.rest.food.app.rest;
import com.restdaoimpl.foodapp.restdaoimpl;
public class launch4 {
	public static  void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id");
		int id=sc.nextInt();
		sc.nextLine();
		
		System.out.println("enter the address");
		String image = sc.nextLine();
		
		
		restdaoimpl doa=new restdaoimpl();
		rest r=doa.getrestaId(id);
		 if (r != null) {
	            
	            r.setImage(image);
	            doa.updateresta(r);
	            System.out.println("Restaurant updated successfully.");
	        } else {
	            System.out.println("Restaurant with ID " + id + " not found.");
	        }

	}

}
