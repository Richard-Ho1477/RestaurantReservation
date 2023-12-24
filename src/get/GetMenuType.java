package get;

import java.sql.*;

public class GetMenuType implements Get{
    public String getData(String name, String cabang) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from menulist");
            while(rs.next()) {
                if(name.compareTo(rs.getString("name")) == 0 && cabang.compareTo(rs.getString("cabang")) == 0){
                    if(rs.getString("story") != null) return "Special Menu";
                    else if(rs.getString("location") != null) return "Local Menu";
                    else return "Menu";
                }
            }
            System.out.println("Invalid Name");
            return null;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
}
