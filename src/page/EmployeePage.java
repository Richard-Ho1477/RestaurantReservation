package page;

import java.util.Scanner;

public class EmployeePage {
    public void employeePage(String id, Scanner sc){
        int input = 0;
        do{
            do{
                System.out.println("\n\n\nEmployee Page ~~");
                System.out.println("1. Edit Menu");
                System.out.println("2. Edit Reservation");
                System.out.println("3. Check Out");
                System.out.println("4. Back");
                try {
                    input = sc.nextInt();
                } catch (Exception e) {
                    System.out.println(e);
                }
                sc.nextLine();
            }while(input < 1 || input > 4);
            switch (input){
                case 1:{
                    
                }
                case 2:{

                }
                case 3:{

                }
                case 4:{
                    return;
                }
            }
        }while(true);
    }
}