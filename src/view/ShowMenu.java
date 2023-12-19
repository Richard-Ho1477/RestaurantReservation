package view;

import java.sql.*;
import java.util.ArrayList;
import menu.*;

public class ShowMenu {
    public ArrayList<Menu> showMenu(String query, String cabang) {
        ArrayList<Menu> menu = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
            Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
            int i = 0;
			while(rs.next()) {
                i++;
                System.out.println(i+". "+rs.getString("name"));
                if(cabang.compareTo("Jakarta") != 0 && cabang.compareTo("Bandung") != 0 
                && cabang.compareTo("Bali") != 0) menu.add(new SpecialMenu(rs.getString("id"), rs.getString("name"), rs.getInt("price"), rs.getString("story")));
                else menu.add(new LocalMenu(rs.getString("id"), rs.getString("name"), rs.getInt("price"), rs.getString("location"), rs.getString("characteristic")));
			}
            con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
        return menu;
    }
}
