package employee;

import java.util.Random;
import java.util.Scanner;

public class EditEmployee {
    public void employeeEdit(){

        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        int input = 0;
        String cabangInput = "", nameInput = "", idInput = "";
        do{
            System.out.println("\n\n\nChoose Option");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Back");
            try {
                input = sc.nextInt();
            } catch (Exception e) {
                System.out.println(e);
            }
            sc.nextLine();
        }while(input < 1 || input > 4);
        if(input == 4) {sc.close();return;}
        switch (input) {
            case 1:{
                do{	
                    System.out.print("\nInput Employee Name [3 - 30 Characters]: ");
                    try {
                        nameInput = sc.nextLine();
                    } catch (Exception e) {
                        System.out.println(e);
                        sc.nextLine();
                    }
                }while(nameInput.length() < 3 || nameInput.length() > 30);
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

                idInput = String.format("%c%c%c%d%d%dE", (char) ('A' + rd.nextInt(26))
                , (char) ('A' + rd.nextInt(26)), (char) ('A' + rd.nextInt(26))
                , rd.nextInt(10),rd.nextInt(10),rd.nextInt(10));

                AddEmployee ae = new AddEmployee();
                ae.addEmployee(idInput,nameInput,cabangInput);
                break;
            }
            case 2:{
                // printEmployeeList(--);
                ReadEmployee re = new ReadEmployee();
                do{	
                    System.out.print("\nInput Employee ID [7 Characters]: ");
                    try {
                        idInput = sc.nextLine();
                    } catch (Exception e) {
                        System.out.println(e);
                        sc.nextLine();
                    }
                    if(idInput.length() != 7) continue;
                }while(re.findEmployee(idInput));
                do{	
                    System.out.print("\nInput New Employee Name [3 - 30 Characters]: ");
                    try {
                        nameInput = sc.nextLine();
                    } catch (Exception e) {
                        System.out.println(e);
                        sc.nextLine();
                    }
                }while(nameInput.length() < 3 || nameInput.length() > 30);
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

                break;
            }
            case 3:{
                // printEmployeeList(--);
                ReadEmployee re = new ReadEmployee();
                do{	
                    System.out.print("\nInput Employee ID [7 Characters]: ");
                    try {
                        idInput = sc.nextLine();
                    } catch (Exception e) {
                        System.out.println(e);
                        sc.nextLine();
                    }
                    if(idInput.length() != 7) continue;
                }while(re.findEmployee(idInput));
                DeleteEmployee de = new DeleteEmployee();
                de.deleteEmployee(idInput);
            }
        }

        sc.close();
    }
}
