package add;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddMenu {
    public void addData(String name, int price, String story, String location, String characteristic, String cabang, int menuSelection) {
        String query = "";
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
            if(menuSelection == 1) query = "insert into menulist (name,price,cabang) values (?,?,?)";
            else if(menuSelection == 2){
                if(cabang.compareTo("Jakarta") == 0 || cabang.compareTo("Bandung") == 0 || 
                cabang.compareTo("Bali") == 0) query = "insert into menulist (name,price,cabang,story) values (?,?,?,?)";
                else query = "insert into menulist (name,price,cabang,location,characteristic) values (?,?,?,?,?)";
            }
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.setInt(2, price);
			pst.setString(3, cabang);
            if(menuSelection == 2){
                if(cabang.compareTo("Jakarta") == 0 || cabang.compareTo("Bandung") == 0 || 
                cabang.compareTo("Bali") == 0) pst.setString(4, story);
                else{
                    pst.setString(4, location);
                    pst.setString(5, characteristic);
                }
            }
			if(pst.executeUpdate() != 0) System.out.println("\nMenu data added");
			else System.out.println("\nError, Menu data is not added");
            con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
