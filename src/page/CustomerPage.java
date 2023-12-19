package page;

import java.util.ArrayList;
import java.util.Scanner;

import menu.Menu;
import view.*;

public class CustomerPage {
    public void customerPage(String cabang, String id, Scanner sc) {
        ShowCustomerTable ct = new ShowCustomerTable();
        ShowMenu sm = new ShowMenu();
        int input = 0;
        int totalTable;
        do {
            System.out.println("\n\n\nYour Table");
            totalTable = ct.customerTable(id);
            System.out.println("\nTable to order: ");
            try {
                input = sc.nextInt();
            } catch (Exception e) {
                System.out.println(e);
            }
            sc.nextLine();
        }while(input < 1 || input > totalTable);
       
        // ShowMenu sm = new ShowMenu();
        // ArrayList<Menu> menu = new ArrayList<>();
        // if(cabang.compareTo("Jakarta") == 0) {
        //     menu = sm.showMenu("select * from menujakarta", cabang);
        // } else if(cabang.compareTo("Bandung") == 0) {
        //     menu = sm.showMenu("select * from menubandung", cabang);
        // } else if(cabang.compareTo("Bali") == 0) {
        //     menu = sm.showMenu("select * from menubali", cabang);
        // } else if(cabang.compareTo("Surabaya") == 0) {
        //     menu = sm.showMenu("select * from menusurabaya", cabang);
        // } else if(cabang.compareTo("Samarinda") == 0) {
        //     menu = sm.showMenu("select * from menusamarinda", cabang);
        // } else if(cabang.compareTo("Padang") == 0) {
        //     menu = sm.showMenu("select * from menupadang", cabang);
        // }
    }
}
