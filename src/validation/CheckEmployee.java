package validation;

import java.util.Scanner;
import get.GetEmployeeCabang;
import page.EmployeePage;
import view.ShowEmployee;

public class CheckEmployee implements Validate{

    public void validateId(String cabang, Scanner sc){
        ShowEmployee se = new ShowEmployee();
        GetEmployeeCabang ge = new GetEmployeeCabang();
        EmployeeList el = new EmployeeList();
        String input = "", cabangS = "";

        System.out.println("");

        if(el.listNull(cabang)){
            System.out.println("There is no Employee in Cabang " + cabang);
            System.out.println("Press enter to continue...");
            sc.nextLine();
            return;
        }
        se.showEmployee(cabang);
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
            cabangS = ge.getData(input, "select * from employeelist");
            if(cabangS.compareTo(cabang) != 0) System.out.println("Wrong ID for Cabang " + cabang);
        }while(cabangS.compareTo(cabang) != 0);
        EmployeePage ep = new EmployeePage();
        ep.employeePage(cabangS, sc);
        return;
    }
}
