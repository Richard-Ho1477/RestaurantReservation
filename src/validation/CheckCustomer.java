package validation;

import java.util.Scanner;

public class CheckCustomer implements Validate{

    private static CheckCustomer check_customer = null;
    private String input;
    private Scanner sc;

    private CheckCustomer(){
        sc = new Scanner(System.in);
    }

    public static synchronized CheckCustomer getCustomer(){
        if (check_customer == null) check_customer = new CheckCustomer();
        return check_customer;
    }

    public void validateId(String cabang){
        do{
            // printCustomerList(--);
            System.out.println("\nInput 0 to go back");
            System.out.print("Input ID of Reservation [10 Character]: ");
            try {
                input = sc.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                sc.nextLine();
            }
            if(input.compareTo("0") == 0) return;
        }while(input.length() != 10);
        // if(cabang.compareTo(--) == 0) return false;
        // else{
        //     return true;
        // }
        sc.close();
        return;
    }
}
