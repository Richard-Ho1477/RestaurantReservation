package edit;

import java.util.Random;
import java.util.Scanner;

import validation.EmployeeList;
import add.AddEmployee;
import delete.DeleteEmployee;
import find.FindEmployee;
import update.UpdateEmployee;
import view.ShowEmployee;

public class EditEmployee {
    public void employeeEdit(Scanner sc){

        ShowEmployee se = new ShowEmployee();
        FindEmployee fe = new FindEmployee();
        EmployeeList el = new EmployeeList();
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
                    }while(!fe.findData(idInput, "select * from employeelist"));
                    
    
                    AddEmployee ae = new AddEmployee();
                    ae.addData(idInput,nameInput,cabangInput);
                    System.out.println("Press enter to continue...");
                    sc.nextLine();
                    break;
                }
                case 2:{
                    System.out.println("");
                    if(el.listNull("-")){
                        System.out.println("There is no Employee data");
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    }
                    se.showEmployee("-");
                    do{	
                        System.out.print("Input Employee ID [5 Characters]: ");
                        try {
                            idInput = sc.nextLine();
                        } catch (Exception e) {
                            System.out.println(e);
                            sc.nextLine();
                        }
                        if(idInput.length() != 5) continue;
                        if(fe.findData(idInput, "select * from employeelist")) System.out.println("Invalid ID");
                    }while(fe.findData(idInput, "select * from employeelist"));
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
                    ue.updateData(idInput,nameInput,cabangInput);
                    System.out.println("Press enter to continue...");
                    sc.nextLine();
                    break;
                }
                case 3:{
                    System.out.println("");
                    if(el.listNull("-")){
                        System.out.println("There is no Employee data");
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    }
                    se.showEmployee("-");
                    do{	
                        System.out.print("Input Employee ID [5 Characters]: ");
                        try {
                            idInput = sc.nextLine();
                        } catch (Exception e) {
                            System.out.println(e);
                            sc.nextLine();
                        }
                        if(idInput.length() != 5) continue;
                        if(fe.findData(idInput, "select * from employeelist")) System.out.println("Invalid ID");
                    }while(fe.findData(idInput, "select * from employeelist"));
                    DeleteEmployee de = new DeleteEmployee();
                    de.deleteData(idInput);
                    System.out.println("Press enter to continue...");
                    sc.nextLine();
                    break;
                }
            }
        }while(true);
    }
}
