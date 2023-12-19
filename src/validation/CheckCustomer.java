package validation;

import java.util.Scanner;

import get.GetCustomerCabang;
import get.GetEmployeeCabang;
import page.CustomerPage;
import page.EmployeePage;
import view.ShowCustomer;
import view.ShowCustomerTable;
import view.ShowEmployee;

public class CheckCustomer implements Validate{

    public void validateId(String cabang, Scanner sc){
        ShowCustomer scu = new ShowCustomer();
        GetCustomerCabang gc = new GetCustomerCabang();
        String input = "", cabangS = "";
        do{
            scu.showCustomer();
            System.out.println("\n\n\nInput 0 to go back");
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
        }while(cabangS == null);
        CustomerPage cp = new CustomerPage();
        cp.customerPage(cabangS, input, sc);
        return;
    }
}
