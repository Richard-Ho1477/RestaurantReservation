package edit;

import java.util.Scanner;

import get.GetCustomerCabang;
import get.GetTableType;
import update.UpdateStatus;
import view.*;

public class EditCheckOut {
    public void checkOutEdit(String cabang, Scanner sc){
        int totalTable = 0, input = 0;
        String type = "", cabangC = "", id = "";
        ShowCustomer scu = new ShowCustomer();
        GetCustomerCabang gc = new GetCustomerCabang();
        ShowTable st = new ShowTable();

        System.out.println("");
        do{
            scu.showCustomer();
            System.out.print("Input Customer ID[5 Character]: ");
            try {
                id = sc.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                sc.nextLine();
            }
            if(id.compareTo("0") == 0) return;
            if(id.length() != 5) continue;
            cabangC = gc.getData(id, "select * from customerlist");
            if(cabangC == null) continue;
        }while(cabangC.compareTo(cabang) != 0);

        do {
            System.out.println("\n\n\nTable of " + id);
            totalTable = st.showTable(id, "IN ORDER");
            System.out.print("\nTable to checkout: ");
            try {
                input = sc.nextInt();
            } catch (Exception e) {
                System.out.println(e);
            }
            sc.nextLine();
        }while(input < 1 || input > totalTable);
        GetTableType gt = new GetTableType();
        type = gt.getData(id, String.valueOf(totalTable), "IN ORDER");

        UpdateStatus us = new UpdateStatus();
        us.updateData(id, "FINALIZED", type);
        System.out.println("Press enter to continue...");
        sc.nextLine();

        ShowBill sb = new ShowBill();
        sb.showBill(id,type,cabang);
        System.out.println("Press enter to continue...");
        sc.nextLine();
    }
}
