package validation;

import java.util.Scanner;

public class CheckCustomer implements Validate{

    public void validateId(String cabang, Scanner sc){
        String input = "";
        do{
            // printCustomerList(--);
            System.out.println("\n\n\nInput 0 to go back");
            System.out.print("Input ID of Reservation [10 Character]: ");
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
