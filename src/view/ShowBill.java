package view;

import get.GetOrder;
import get.GetPrice;

public class ShowBill {
    public void showBill(String id, String type, String cabang){
        GetPrice gp = new GetPrice();
        int totalPrice = 0;

        GetOrder go = new GetOrder();
        String order = go.getData(id, type);
        int limit = order.length() - order.replace(",", "").length();
        String[] word = order.split(",",limit+1);

        for (int i = 0; i < word.length-1; i++) {
            System.out.println((i+1) + ". " + word[i] + ", Price: " + gp.getData(word[i], cabang));
            totalPrice+=gp.getData(word[i], cabang);
        }

        System.out.println("\nTotal Price: " + totalPrice);
    }
}
