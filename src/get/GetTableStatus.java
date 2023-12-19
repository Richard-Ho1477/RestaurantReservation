package get;

import java.sql.*;

public class GetTableStatus implements Get {
    public String getData(String id, String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tablelist");
            while(rs.next()) {
                if(rs.getString("story") != null) return "Special Menu";
                else if(rs.getString("location") != null) return "Local Menu";
                else return "Menu";
            }
            System.out.println("Invalid ID");
            return null;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
}
