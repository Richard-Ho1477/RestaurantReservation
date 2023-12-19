package main;

import java.util.*;

import employee.*;
import validation.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int user = 0, cabang = 0;
		boolean call = true;
		String cabangS = "";

		do{
			do{
				System.out.println("\n\n\nLaperAh");
				System.out.println("1. Employee Page");
				System.out.println("2. Customer Page");
				System.out.println("3. Edit Employee List");
				System.out.println("4. Edit Customer List");
				System.out.println("5. Exit");
				System.out.print("Choose: ");
				try {
					user = sc.nextInt();
				} catch (Exception e) {
					System.out.println(e);
				}
				sc.nextLine();
			}while(user < 1 || user > 5);

			if(user == 1 || user == 2){
				do{
					System.out.println("\n\n\nPilih Cabang");
					System.out.println("1. Bandung");
					System.out.println("2. Jakarta");
					System.out.println("3. Bali");
					System.out.println("4. Surabaya");
					System.out.println("5. Samarinda");
					System.out.println("6. Padang");
					System.out.println("7. Back");
					System.out.print("Choose: ");
					try {
						cabang = sc.nextInt();
					} catch (Exception e) {
						System.out.println(e);
					}
					sc.nextLine();
				}while(cabang < 1 || cabang > 7);

				if(cabang == 1) cabangS = "Bandung";
				else if(cabang == 2) cabangS = "Jakarta";
				else if(cabang == 3) cabangS = "Bali";
				else if(cabang == 4) cabangS = "Surabaya";
				else if(cabang == 5) cabangS = "Samarinda";
				else if(cabang == 6) cabangS = "Padang";
				else continue;
	
				if(user == 1){
					CheckEmployee ce = new CheckEmployee();
					ce.validateId(cabangS, sc);
				}
				else if(user == 2){
					CheckCustomer cc = new CheckCustomer();
					cc.validateId(cabangS, sc);
				}
			}
			else if(user == 3){
				EditEmployee ed = new EditEmployee();
				ed.employeeEdit(sc);
			}
			else if(user == 4);
			else if(user == 5) call = false;
		}while(call);

		sc.close();
	}
}