package edit;

import java.util.Random;
import java.util.Scanner;

import add.AddEmployee;
import employee.DeleteEmployee;
import employee.UpdateEmployee;

public class EditMenu {
    public void menuEdit(String cabang, Scanner sc){
        int input = 0, priceInput = 0;
        String nameInput = "", locationInput = "", characteristicInput = "", storyInput = "";

        do{
            do{
                System.out.println("\n\n\nChoose Option");
                System.out.println("1. Add Menu");
                System.out.println("2. Update Menu");
                System.out.println("3. Delete Menu");
                System.out.println("4. Back");
                System.out.print("Choose: ");
                try {
                    input = sc.nextInt();
                } catch (Exception e) {
                    System.out.println(e);
                }
                sc.nextLine();
            }while(input < 1 || input > 4);
    
            if(input == 4) return;
            switch (input) {
                case 1:{
                    System.out.println("");
                    do{	
                        System.out.print("Input Menu Name [3 - 30 Characters]: ");
                        try {
                            nameInput = sc.nextLine();
                        } catch (Exception e) {
                            System.out.println(e);
                            sc.nextLine();
                        }
                    }while(nameInput.length() < 3 || nameInput.length() > 30);
                    do{	
                        System.out.print("Input Menu Price [> 0]: ");
                        try {
                            priceInput = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        sc.nextLine();
                    }while(priceInput > 0);
                    
                    break;
                }
            }
        }while(true);
    }
}
