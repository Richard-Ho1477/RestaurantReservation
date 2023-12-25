package page;

import java.util.Scanner;

import find.FindMenu;
import get.GetTableType;
import update.UpdateTable;
import view.*;

public class CustomerPage {
    public void customerPage(String cabang, String id, Scanner sc) {
        ShowTable st = new ShowTable();
        ShowMenu sm = new ShowMenu();
        FindMenu fm = new FindMenu();
        int input = 0;
        int totalTable = 0;
        String orderInput = "", order = "", type = "";

        do {
            System.out.println("\n\n\nYour Table");
            totalTable = st.showTable(id, "IN RESERVE");
            if(totalTable == 0){
                System.out.println("No table is IN RESERVE");
                System.out.println("Press enter to continue...");
                sc.nextLine();
                return;
            }
            System.out.print("\nTable to order: ");
            try {
                input = sc.nextInt();
            } catch (Exception e) {
                System.out.println(e);
            }
            sc.nextLine();
        }while(input < 1 || input > totalTable);
        GetTableType gt = new GetTableType();
        type = gt.getData(id, String.valueOf(totalTable), "IN RESERVE");

        System.out.println("\n\n");
        sm.showMenu(cabang);
        System.out.println("");
        do {
            System.out.print("Input menu's name you want to order (input 0 to finish order): ");
            try {
                orderInput = sc.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                sc.nextLine();
            }
            if(orderInput.compareTo("0") == 0) break;
            order = order.concat(orderInput + ",");
        } while(!fm.findData(orderInput, cabang));

        UpdateTable ut = new UpdateTable();
        ut.updateData(id, order, "IN ORDER", type);
        System.out.println("Press enter to continue...");
        sc.nextLine();

    }
}
