package get;

import java.sql.*;

public class GetTableType {
    public String getData(String id, String index) {
        int i = Integer.valueOf(index);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tablelist");
            while(rs.next()) {
                if(id.compareTo(rs.getString("id")) == 0 && rs.getString("status").compareTo("IN RESERVE") == 0) i--;
                if(i == 0) return rs.getString("type");
            }
            return null;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
}
