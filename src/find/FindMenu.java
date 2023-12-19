package find;

import java.sql.*;

public class FindMenu implements Find{
    public boolean findData(String name, String cabang){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from menulist");
            while(rs.next()) {
                if(name.compareTo(rs.getString("name")) == 0 && cabang.compareTo(rs.getString("cabang")) == 0) return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }

        return true;
    }
}
