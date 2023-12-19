package page;

import java.util.ArrayList;
import java.util.Scanner;

import find.FindMenu;
import menu.Menu;
import view.*;

public class CustomerPage {
    public void customerPage(String cabang, String id, Scanner sc) {
        ShowCustomerTable ct = new ShowCustomerTable();
        ShowMenu sm = new ShowMenu();
        FindMenu fm = new FindMenu();
        int input = 0;
        int totalTable = 0;
        String orderInput = "";
        String order = "";

        do {
            System.out.println("\n\n\nYour Table");
            totalTable = ct.customerTable(id);
            System.out.print("\nTable to order: ");
            try {
                input = sc.nextInt();
            } catch (Exception e) {
                System.out.println(e);
            }
            sc.nextLine();
        }while(input < 1 || input > totalTable);

        do {
            sm.showMenu(cabang);
            do {
                System.out.print("Input menu's name you want to order (input 0 to finish order): ");
                try {
                    orderInput = sc.nextLine();
                } catch (Exception e) {
                    System.out.println(e);
                    sc.nextLine();
                }
                if(orderInput.compareTo("0") == 0) break;
            } while(!fm.findData(orderInput, cabang));
            if(orderInput.compareTo("0") == 0) break;
            order = order.concat(", "+orderInput);
        } while(true);

        
    }
}
