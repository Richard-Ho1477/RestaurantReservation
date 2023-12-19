package validation;
import java.util.Scanner;

import employee.ReadEmployee;
import page.EmployeePage;
import view.ShowEmployee;

public class CheckEmployee implements Validate{

    public void validateId(String cabang, Scanner sc){
        ShowEmployee se = new ShowEmployee();
        ReadEmployee re = new ReadEmployee();
        String input = "";
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
        }while(re.findEmployee(input));
        EmployeePage ep = new EmployeePage();
        ep.employeePage(input, sc);
        return;
    }
}
