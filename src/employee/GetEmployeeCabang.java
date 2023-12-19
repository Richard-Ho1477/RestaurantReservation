package employee;

import java.sql.*;

public class GetEmployeeCabang {
    public String employeeCabang(String id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employeelist");
            while(rs.next()) {
                if(id.compareTo(rs.getString("id")) == 0) return rs.getString("cabang");
            }
            System.out.println("Invalid ID");
            return null;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
}
