package edit;

import java.util.Scanner;

import add.AddMenu;
import find.FindMenu;
import view.ShowMenu;

public class EditMenu {
    public void menuEdit(String cabang, Scanner sc){
        ShowMenu sm = new ShowMenu();
        FindMenu fm = new FindMenu();
        int input = 0, priceInput = 0, menuSelection = 0;
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
                        System.out.println("1. Normal Menu");
                        if(cabang.compareTo("Jakarta") == 0 || cabang.compareTo("Bandung") == 0 || 
                        cabang.compareTo("Bali") == 0) System.out.println("2. Special Menu");
                        else System.out.println("2. Local Menu");
                        System.out.print("Select Menu Type: ");
                        try {
                            menuSelection = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        sc.nextLine();
                    }while(menuSelection < 1 || menuSelection > 2);
                    do{	
                        System.out.print("Input Menu Name [3 - 30 Characters]: ");
                        try {
                            nameInput = sc.nextLine();
                        } catch (Exception e) {
                            System.out.println(e);
                            sc.nextLine();
                        }
                        if(nameInput.length() < 3 || nameInput.length() > 30) continue;
                    }while(fm.findData(nameInput, cabang));
                    do{	
                        System.out.print("Input Menu Price [1-1000000]: ");
                        try {
                            priceInput = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        sc.nextLine();
                    }while(priceInput < 1 || priceInput > 1000000);
                    
                    if(menuSelection == 2){
                        if(cabang.compareTo("Jakarta") == 0 || cabang.compareTo("Bandung") == 0 || 
                        cabang.compareTo("Bali") == 0){
                            do{	
                                System.out.print("Input Menu Story [5 - 100 Characters]: ");
                                try {
                                    storyInput = sc.nextLine();
                                } catch (Exception e) {
                                    System.out.println(e);
                                    sc.nextLine();
                                }
                            }while(storyInput.length() < 5 || storyInput.length() > 100);
                        }
                        else{
                            do{	
                                System.out.print("Input Menu Location [3 - 30 Characters]: ");
                                try {
                                    locationInput = sc.nextLine();
                                } catch (Exception e) {
                                    System.out.println(e);
                                    sc.nextLine();
                                }
                            }while(locationInput.length() < 3 || locationInput.length() > 30);
                            do{	
                                System.out.print("Input Menu Characteristic [5 - 100 Characters]: ");
                                try {
                                    characteristicInput = sc.nextLine();
                                } catch (Exception e) {
                                    System.out.println(e);
                                    sc.nextLine();
                                }
                            }while(characteristicInput.length() < 5 || characteristicInput.length() > 100);
                        }
                    }
                    AddMenu am = new AddMenu();
                    am.addData(nameInput, priceInput, storyInput, locationInput, characteristicInput, cabang, menuSelection);
                    System.out.println("Press enter to continue...");
                    sc.nextLine();

                    break;
                }
                case 2:{
                    sm.showMenu(cabang);
                    do{	
                        System.out.print("Input Menu Name [3 - 30 Characters]: ");
                        try {
                            nameInput = sc.nextLine();
                        } catch (Exception e) {
                            System.out.println(e);
                            sc.nextLine();
                        }
                    }while(fm.findData(nameInput, cabang));
                    break;
                }
            }
        }while(true);
    }
}
