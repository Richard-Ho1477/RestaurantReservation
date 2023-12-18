package main;

import java.sql.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int user = 0, cabang = 0;
		boolean call = true;

		do{
			do{
				System.out.println("LaperAh");
				System.out.println("1. Employee");
				System.out.println("2. Customer");
				System.out.println("3. Edit Employee");
				System.out.println("4. Edit Customer");
				System.out.print("Choose: ");
				try {
					user = sc.nextInt();
				} catch (Exception e) {
					System.out.println(e);
				}
				sc.nextLine();
			}while(user < 1 || user > 4);

			do{
				System.out.println("Pilih Cabang");
				System.out.println("1. Surabaya");
				System.out.println("2. Bandung");
				System.out.println("3. Jakarta");
				System.out.println("4. Samarinda");
				System.out.println("5. Padang");
				System.out.println("6. Bali");
				System.out.println("7. Back");
				System.out.print("Choose: ");
				try {
					cabang = sc.nextInt();
				} catch (Exception e) {
					System.out.println(e);
				}
				sc.nextLine();
			}while(cabang < 1 || cabang > 7);
			if(cabang == 7) continue;

			if(user == 1){
				System.out.println("hello");
			}
			else if(user == 2){
				System.out.println("test");
			}
			else if(user == 3){
				System.out.println("tes");
			}
			else if(user == 4){
				System.out.println("helo");
			}
		}while(call);
	}
	

}