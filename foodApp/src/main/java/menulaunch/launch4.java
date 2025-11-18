package menulaunch;

import java.util.Scanner;
import com.menu.menu;
import com.menudaoimpl.menudaoimpl;

public class launch4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the menu ID:");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Enter the new item name:");
        String name = sc.nextLine();

        System.out.println("Enter the new price:");
        double price = sc.nextDouble();

        menudaoimpl doa = new menudaoimpl();
        menu r = doa.getmenuId(id);

        if (r != null) {
            r.setItemname(name);
            r.setPrice(price); // or double if your model uses double
            doa.updatemenu(r);
            System.out.println("Menu item updated successfully.");
        } else {
            System.out.println("Menu item with ID " + id + " not found.");
        }

        sc.close();
    }
}