package validation;
import java.util.Scanner;

import get.GetEmployeeCabang;
import page.EmployeePage;
import view.ShowEmployee;

public class CheckEmployee implements Validate{

    public void validateId(String cabang, Scanner sc){
        ShowEmployee se = new ShowEmployee();
        GetEmployeeCabang ge = new GetEmployeeCabang();
        String input = "", cabangS = "";
        do{
            se.showEmployee();
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
            cabangS = ge.getData(input, "select * from employeelist");
        }while(cabangS == null);
        EmployeePage ep = new EmployeePage();
        ep.employeePage(cabangS, sc);
        return;
    }
}
