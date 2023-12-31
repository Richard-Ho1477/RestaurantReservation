package edit;

import java.util.Scanner;

import validation.MenuList;
import add.AddMenu;
import delete.DeleteMenu;
import find.FindMenu;
import get.GetMenuType;
import update.UpdateMenu;
import view.ShowMenu;

public class EditMenu {
    public void menuEdit(String cabang, Scanner sc){
        ShowMenu sm = new ShowMenu();
        FindMenu fm = new FindMenu();
        GetMenuType gm = new GetMenuType();
        MenuList ml = new MenuList();
        int input = 0, priceInput = 0, menuSelection = 0;
        String nameInput = "", locationInput = "", characteristicInput = "", storyInput = "", confirm = "", oldName = "";

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
                    }while(nameInput.length() < 3 || nameInput.length() > 30);
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
                    if(ml.listNull(cabang)){
                        System.out.println("There is no menu data");
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    }
                    sm.showMenu(cabang);
                    do{	
                        System.out.print("Enter Menu Name To Update: ");
                        try {
                            nameInput = sc.nextLine();
                        } catch (Exception e) {
                            System.out.println(e);
                            sc.nextLine();
                        }
                    }while(fm.findData(nameInput, cabang));
                    oldName = nameInput;
                    do{	
                        System.out.print("Input New Menu Name [3 - 30 Characters]: ");
                        try {
                            nameInput = sc.nextLine();
                        } catch (Exception e) {
                            System.out.println(e);
                            sc.nextLine();
                        }
                    }while(nameInput.length() < 3 || nameInput.length() > 30);
                    do{	
                        System.out.print("Input New Menu Price [1-1000000]: ");
                        try {
                            priceInput = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        sc.nextLine();
                    }while(priceInput < 1 || priceInput > 1000000);

                    String menuType = gm.getData(oldName, cabang);
                    
                    if(menuType.compareTo("Special Menu") == 0){
                        do{	
                            System.out.print("Do you want to change story [y/n]? ");
                            try {
                                confirm = sc.nextLine();
                            } catch (Exception e) {
                                System.out.println(e);
                                sc.nextLine();
                            }
                            if(nameInput.length() < 3 || nameInput.length() > 30) continue;
                        }while(confirm.compareTo("y") != 0 && confirm.compareTo("n") != 0);
                        if(confirm.compareTo("y") == 0){
                            do{	
                                System.out.print("Input New Menu Story [5 - 100 Characters]: ");
                                try {
                                    storyInput = sc.nextLine();
                                } catch (Exception e) {
                                    System.out.println(e);
                                    sc.nextLine();
                                }
                            }while(storyInput.length() < 5 || storyInput.length() > 100);
                        }
                    }
                    else if(menuType.compareTo("Local Menu") == 0){
                        do{	
                            System.out.print("Do you want to change location and characteristic [y/n]? ");
                            try {
                                confirm = sc.nextLine();
                            } catch (Exception e) {
                                System.out.println(e);
                                sc.nextLine();
                            }
                            if(nameInput.length() < 3 || nameInput.length() > 30) continue;
                        }while(confirm.compareTo("y") != 0 && confirm.compareTo("n") != 0);
                        if(confirm.compareTo("y") == 0){
                            do{	
                                System.out.print("Input New Menu Location [3 - 30 Characters]: ");
                                try {
                                    locationInput = sc.nextLine();
                                } catch (Exception e) {
                                    System.out.println(e);
                                    sc.nextLine();
                                }
                            }while(locationInput.length() < 3 || locationInput.length() > 30);
                            do{	
                                System.out.print("Input New Menu Characteristic [5 - 100 Characters]: ");
                                try {
                                    characteristicInput = sc.nextLine();
                                } catch (Exception e) {
                                    System.out.println(e);
                                    sc.nextLine();
                                }
                            }while(characteristicInput.length() < 5 || characteristicInput.length() > 100);
                        }
                    }

                    UpdateMenu um = new UpdateMenu();
                    if(menuType.compareTo("Special Menu") == 0 || menuType.compareTo("Local Menu") == 0) 
                    um.updateData(nameInput, priceInput, storyInput, locationInput, characteristicInput, cabang, 2, oldName);
                    else um.updateData(nameInput, priceInput, storyInput, locationInput, characteristicInput, cabang, 1, oldName);
                    System.out.println("Press enter to continue...");
                    sc.nextLine();
                    break;
                }
                case 3:{
                    if(ml.listNull(cabang)){
                        System.out.println("There is no menu data");
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    }
                    sm.showMenu(cabang);
                    do{	
                        System.out.print("Enter Menu Name To Delete: ");
                        try {
                            nameInput = sc.nextLine();
                        } catch (Exception e) {
                            System.out.println(e);
                            sc.nextLine();
                        }
                    }while(fm.findData(nameInput, cabang));
                    DeleteMenu dm = new DeleteMenu();
                    dm.deleteData(nameInput, cabang);
                    System.out.println("Press enter to continue...");
                    sc.nextLine();
                    break;
                }
            }
        }while(true);
    }
}
