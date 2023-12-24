package validation;

import java.util.Scanner;

import get.GetCustomerCabang;
import page.CustomerPage;
import view.ShowCustomer;

public class CheckCustomer implements Validate{

    public void validateId(String cabang, Scanner sc){
        ShowCustomer scu = new ShowCustomer();
        GetCustomerCabang gc = new GetCustomerCabang();
        String input = "", cabangS = "";

        System.out.println("");
        scu.showCustomer();
        System.out.println("\nInput 0 to go back");
        do{
            System.out.print("Input ID for vertification [5 Character]: ");
            try {
                input = sc.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                sc.nextLine();
            }
            if(input.compareTo("0") == 0) return;
            if(input.length() != 5) continue;
            cabangS = gc.getData(input, "select * from customerlist");
            if(cabangS.compareTo(cabang) != 0) System.out.println("Wrong ID for Cabang " + cabang);
        }while(cabangS.compareTo(cabang) != 0);
        CustomerPage cp = new CustomerPage();
        cp.customerPage(cabangS, input, sc);
        return;
    }
}
