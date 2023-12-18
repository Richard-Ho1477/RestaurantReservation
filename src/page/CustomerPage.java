package page;

import java.util.Scanner;
import view.ShowCustomerTable;

public class CustomerPage {
    public void customerPage(String cabang, String id) {
        ShowCustomerTable ct = new ShowCustomerTable();
        Scanner sc = new Scanner(System.in);
        int input = 0;
        int totalTable;
        do {
            System.out.println("\n\n\nYour Table");
            totalTable = ct.customerTable(id);
            System.out.println("\nTable to order: ");
            try {
                input = sc.nextInt();
            } catch (Exception e) {
                System.out.println(e);
            }
            sc.nextLine();
        }while(input < 1 || input > totalTable);
    }
}
