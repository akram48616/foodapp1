package restaluanchs;
import java.util.*;

import com.rest.food.app.rest;
import com.restdaoimpl.foodapp.restdaoimpl;
public class launch2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		restdaoimpl dap=new restdaoimpl();
		rest getrestId=dap.getrestaId(id);
		System.out.println(getrestId);
	}

}
