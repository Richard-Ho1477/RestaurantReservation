package page;

import java.util.Scanner;

import edit.*;

public class EmployeePage {
    public void employeePage(String cabang, Scanner sc){
        int input = 0;
        do{
            do{
                System.out.println("\n\n\nEmployee Page ~~");
                System.out.println("1. Edit Menu");
                System.out.println("2. Edit Reservation");
                System.out.println("3. Check Out");
                System.out.println("4. Back");
                System.out.print("Choose: ");
                try {
                    input = sc.nextInt();
                } catch (Exception e) {
                    System.out.println(e);
                }
                sc.nextLine();
            }while(input < 1 || input > 4);
            switch (input){
                case 1:{
                    EditMenu em = new EditMenu();
                    em.menuEdit(cabang, sc);
                }
                case 2:{
                    EditReservation er = new EditReservation();
                    er.addReservation(cabang, sc);
                }
                case 3:{
                    EditCheckOut ec = new EditCheckOut();
                    ec.checkOutEdit(cabang, sc);
                }
                case 4:{
                    return;
                }
            }
        }while(true);
    }
}
