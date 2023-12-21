package view;

import java.sql.*;

public class ShowTable {
    public int showTable(String id,String status) {
		int i = 0;
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from tablelist");
			while(rs.next()) {
				if(id.compareTo(rs.getString("id")) == 0 && rs.getString("status").compareTo(status) == 0) {
                    i++;
                    System.out.println(i+". "+rs.getString("type"));
                }
			}
		} catch (Exception e) {
			System.out.println(e);
	    }
		return i;
    }
}
