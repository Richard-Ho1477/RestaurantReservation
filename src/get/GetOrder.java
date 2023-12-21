package get;

import java.sql.*;

public class GetOrder implements Get{
    public String getData(String id, String type){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tablelist");
            while(rs.next()) {
                if(id.compareTo(rs.getString("id")) == 0 && rs.getString("status").compareTo("FINALIZED") == 0
                && type.compareTo(rs.getString("type")) == 0){
                    return rs.getString("order");
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
    
}
