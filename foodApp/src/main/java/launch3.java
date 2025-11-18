import java.util.Scanner;
import com.food.model.user;
import com.tap.daoimp.userdaoimpl;

public class launch3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the user ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        userdaoimpl udao = new userdaoimpl();
        user u = udao.getUserId(id); // fetch existing user

        if (u != null) {
            System.out.println("Current User: " + u);

            // Update only selected fields
            u.setPassword("akram");
            u.setAddress("kalluru");

            udao.updateUser(u); // single update call
        } else {
            System.out.println("User not found with ID: " + id);
        }

        sc.close();
    }
}