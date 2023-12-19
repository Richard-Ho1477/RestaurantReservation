package edit;

import java.util.Random;
import java.util.Scanner;

import add.AddCustomer;
import find.FindCustomer;

public class EditReservation {
    public void addReservation(String cabang, Scanner sc){
        Random rd = new Random();
        FindCustomer fc = new FindCustomer();
        String nameInput = "", tTypeInput = "", idInput = ""; 
        int nTable = 0, nPeople = 0, nMax = 0;
        do{
            System.out.println("");
            do{
                System.out.println("Input Reservation Name [3 - 20 Character]: ");
                try {
                    nameInput = sc.nextLine();
                } catch (Exception e) {
                    System.out.println(e);
                    sc.nextLine();
                }
            }while(nameInput.length() < 3 ||  nameInput.length() > 20);
            do{
                System.out.println("Input Table Amount [1 - 5 Table]: ");
                try {
                    nTable = sc.nextInt();
                } catch (Exception e) {
                    System.out.println(e);
                }
                sc.nextLine();
            }while(nTable < 1 ||  nTable > 5);
            for(int i = 0;i < nTable; i++){
                do{
                    System.out.println("Input Table " +  i+1 + " Type [Romantic, General, Family]: ");
                    try {
                        tTypeInput = sc.nextLine();
                    } catch (Exception e) {
                        System.out.println(e);
                        sc.nextLine();
                    }
                }while(tTypeInput.compareTo("Romantic") != 0 && tTypeInput.compareTo("General") != 0 && tTypeInput.compareTo("Family") != 0);

                if(tTypeInput.compareTo("Romantic") == 0) nMax = 2;
                else if(tTypeInput.compareTo("General") == 0) nMax = 4;
                else nMax = 10;

                do{
                    System.out.println("Input Amount of People [Max "+nMax+" People]: ");
                    try {
                        nPeople = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    sc.nextLine();
                }while(nPeople < 1 ||  nPeople > nMax);
                // AddTable
            }
            do{
                idInput = String.format("%c%d%d%dE", nameInput.toUpperCase().charAt(0)
                , rd.nextInt(10),rd.nextInt(10),rd.nextInt(10));
            }while(!fc.findData(idInput));

            AddCustomer ac = new AddCustomer();
            ac.addData(idInput, nameInput, cabang);

        }while(true);

    }
}
