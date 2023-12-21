package update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateMenu {
    public void updateData(String name, int price, String story, String location, String characteristic, String cabang, int menuSelection, String oldName){
        String query = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
            if(menuSelection == 1) query = "update menulist set name = ?, price = ?,cabang = ? where name = ?";
            else if(menuSelection == 2){
                if(cabang.compareTo("Jakarta") == 0 || cabang.compareTo("Bandung") == 0 || 
                cabang.compareTo("Bali") == 0) query = "update menulist set name = ?, price = ?,cabang = ?, story = ? where name = ?";
                else query = "update menulist set name = ?, price = ?,cabang = ?, location = ?, characteristic = ? where name = ?";
            }
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.setInt(2, price);
			pst.setString(3, cabang);
            if(menuSelection == 2){
                if(cabang.compareTo("Jakarta") == 0 || cabang.compareTo("Bandung") == 0 || 
                cabang.compareTo("Bali") == 0){
                    pst.setString(4, story);
                    pst.setString(5, oldName);
                }
                else{
                    pst.setString(4, location);
                    pst.setString(5, characteristic);
                    pst.setString(6, oldName);
                }
            }
            else if(menuSelection == 1) pst.setString(4, oldName);
			if(pst.executeUpdate() != 0) System.out.println("\nMenu data updated");
			else System.out.println("\nError, Menu data is not updated");
            con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
    }
}
