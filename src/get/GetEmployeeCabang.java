package get;

import java.sql.*;

public class GetEmployeeCabang implements Get{
    public String getData(String id, String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
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
