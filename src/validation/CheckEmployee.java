package validation;
import java.util.Scanner;

public class CheckEmployee implements Validate{

    private static CheckEmployee check_employee = null;
    private String input;
    private Scanner sc;

    private CheckEmployee(){
        sc = new Scanner(System.in);
    }

    public static synchronized CheckEmployee getEmployee(){
        if (check_employee == null) check_employee = new CheckEmployee();
        return check_employee;
    }

    public void validateId(String cabang){
        do{
            // printEmployeeList(--);
            System.out.println("\n\n\nInput 0 to go back");
            System.out.print("Input ID for vertification [10 Character]: ");
            try {
                input = sc.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                sc.nextLine();
            }
            if(input.compareTo("0") == 0) return;
        }while(input.length() != 7);
        // if(cabang.compareTo(--) == 0) return false;
        // else{
        //     return true;
        // }
        sc.close();
        return;
    }
}
