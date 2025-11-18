package restaluanchs;
import java.util.*;

import com.rest.food.app.rest;
import com.restdaoimpl.foodapp.restdaoimpl;

public class launch3 {
	public static void main(String[] args) {
		restdaoimpl dao=new restdaoimpl();
		List<rest> rest=dao.getresta();
		System.out.println("All registered users");
		for(rest r:rest) {
			System.out.println(r);
		}
	}

}
