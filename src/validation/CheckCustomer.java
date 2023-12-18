package validation;

import java.util.Scanner;

public class CheckCustomer implements Validate{
    public boolean validateId(String id, String cabang){
        Scanner sc = new Scanner(System.in);
        String input = "";

        do{
            // printCustomerList(--);
            System.out.println("Input 0 to go back");
            System.out.print("Input ID: ");
            try {
                input = sc.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                sc.nextLine();
            }
            if(input.compareTo("0") == 0) return true;
        }while(input.length() != 10);
        // if(cabang.compareTo(--) == 0) return false;
        // else{
        //     return true;
        // }
        return true;
    }
}
