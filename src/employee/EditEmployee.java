package employee;

import java.util.Random;
import java.util.Scanner;

import view.ShowEmployee;

public class EditEmployee {
    public void employeeEdit(Scanner sc){

        ShowEmployee se = new ShowEmployee();
        ReadEmployee re = new ReadEmployee();
        Random rd = new Random();

        int input = 0;
        String cabangInput = "", nameInput = "", idInput = "";

        do{

            do{
                System.out.println("\n\n\nChoose Option");
                System.out.println("1. Add Employee");
                System.out.println("2. Update Employee");
                System.out.println("3. Delete Employee");
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
                        System.out.print("Input Employee Name [3 - 20 Characters]: ");
                        try {
                            nameInput = sc.nextLine();
                        } catch (Exception e) {
                            System.out.println(e);
                            sc.nextLine();
                        }
                    }while(nameInput.length() < 3 || nameInput.length() > 20);
                    do{	
                        System.out.print("Input Employee Cabang [Jakarta, Bandung, Bali, Surabaya, Samarinda, Padang]: ");
                        try {
                            cabangInput = sc.nextLine();
                        } catch (Exception e) {
                            System.out.println(e);
                            sc.nextLine();
                        }
                    }while(cabangInput.compareTo("Jakarta") != 0 && cabangInput.compareTo("Bandung") != 0 
                    && cabangInput.compareTo("Bali") != 0 && cabangInput.compareTo("Surabaya") != 0 
                    && cabangInput.compareTo("Samarinda") != 0 && cabangInput.compareTo("Padang") != 0);
    
                    do{
                        idInput = String.format("%c%d%d%dE", nameInput.toUpperCase().charAt(0)
                        , rd.nextInt(10),rd.nextInt(10),rd.nextInt(10));
                    }while(!re.findEmployee(idInput));
                    
    
                    AddEmployee ae = new AddEmployee();
                    ae.addEmployee(idInput,nameInput,cabangInput);
                    System.out.println("Press enter to continue...");
                    sc.nextLine();
                    break;
                }
                case 2:{
                    se.showEmployee();
                    System.out.println("");
                    do{	
                        System.out.print("Input Employee ID [5 Characters]: ");
                        try {
                            idInput = sc.nextLine();
                        } catch (Exception e) {
                            System.out.println(e);
                            sc.nextLine();
                        }
                        if(idInput.length() != 5) continue;
                    }while(re.findEmployee(idInput));
                    do{	
                        System.out.print("Input New Employee Name [3 - 20 Characters]: ");
                        try {
                            nameInput = sc.nextLine();
                        } catch (Exception e) {
                            System.out.println(e);
                            sc.nextLine();
                        }
                    }while(nameInput.length() < 3 || nameInput.length() > 20);
                    do{	
                        System.out.print("Input New Employee Cabang [Jakarta, Bandung, Bali, Surabaya, Samarinda, Padang]: ");
                        try {
                            cabangInput = sc.nextLine();
                        } catch (Exception e) {
                            System.out.println(e);
                            sc.nextLine();
                        }
                    }while(cabangInput.compareTo("Jakarta") != 0 && cabangInput.compareTo("Bandung") != 0 
                    && cabangInput.compareTo("Bali") != 0 && cabangInput.compareTo("Surabaya") != 0 
                    && cabangInput.compareTo("Samarinda") != 0 && cabangInput.compareTo("Padang") != 0);
                    UpdateEmployee ue = new UpdateEmployee();
                    ue.updateEmployee(idInput,nameInput,cabangInput);
                    System.out.println("Press enter to continue...");
                    sc.nextLine();
                    break;
                }
                case 3:{
                    se.showEmployee();
                    System.out.println("");
                    do{	
                        System.out.print("Input Employee ID [5 Characters]: ");
                        try {
                            idInput = sc.nextLine();
                        } catch (Exception e) {
                            System.out.println(e);
                            sc.nextLine();
                        }
                        if(idInput.length() != 5) continue;
                    }while(re.findEmployee(idInput));
                    DeleteEmployee de = new DeleteEmployee();
                    de.deleteEmployee(idInput);
                    System.out.println("Press enter to continue...");
                    sc.nextLine();
                    break;
                }
            }
        }while(true);
    }
}
