package employee;

import java.sql.*;

public class ReadEmployee {
    public boolean findEmployee(String id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employeelist");
            while(rs.next()) {
                if(id.compareTo(rs.getString("id")) == 0) return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }

        return true;
    }
}