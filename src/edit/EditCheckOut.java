package edit;

import java.util.Scanner;

import validation.CustomerList;
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
        CustomerList cl = new CustomerList();
        ShowTable st = new ShowTable();

        System.out.println("");
        if(cl.listNull(cabang)){
            System.out.println("There is no Customer in Cabang " + cabang);
            System.out.println("Press enter to continue...");
            sc.nextLine();
            return;
        }
        scu.showCustomer(cabang);
        System.out.println("\nInput 0 to go back");
        do{
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
            if(totalTable == 0){
                System.out.println("No table is IN ORDER");
                System.out.println("Press enter to continue...");
                sc.nextLine();
                return;
            }
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

        System.out.println("\nYour Bill:");
        ShowBill sb = new ShowBill();
        sb.showBill(id,type,cabang);
        System.out.println("Press enter to continue...");
        sc.nextLine();
    }
}
