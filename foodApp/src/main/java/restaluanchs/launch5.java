package restaluanchs;
import java.util.*;

import com.rest.food.app.rest;
import com.restdaoimpl.foodapp.restdaoimpl;

public class launch5 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the id");
		int id=sc.nextInt();
		restdaoimpl dao=new restdaoimpl();
		rest r=dao.getrestaId(id);
	    dao.deleteresta(id);
	    sc.close();
		
	}

}
