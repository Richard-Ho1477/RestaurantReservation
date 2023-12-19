package view;

import java.sql.*;

public class ShowMenu {
    public void showMenu(String cabang) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
            Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from menulist");
            int i = 0;
			while(rs.next()) {
                if(cabang.compareTo(rs.getString("cabang")) == 0){
                    i++;
                    if(rs.getString("story") != null){
                        System.out.println(i + ". Menu Name: " + rs.getString("name") + ", Price: " + rs.getInt("price"));
                        System.out.println("Story: ");
                        System.out.println(rs.getString("story"));
                    }
                    else if(rs.getString("location") != null){
                        System.out.println(i + ". Menu Name: " + rs.getString("name") + ", Price: " + rs.getInt("price")
                        + ", Location: " + rs.getString("location"));
                        System.out.println("Characteristic: ");
                        System.out.println(rs.getString("characteristic"));
                    }
                    else{
                        System.out.println(i + ". Menu Name: " + rs.getString("name") + ", Price: " + rs.getInt("price"));
                    }
                    System.out.println("");
                }
			}
            con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
    }
}
