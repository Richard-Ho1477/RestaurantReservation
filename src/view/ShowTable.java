package view;

import java.sql.*;

public class ShowTable {
    public int showTable(Connection con, String query, String type, String id, int i) {
        try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				if(id.compareTo(rs.getString(id)) == 0) {
                    i++;
                    System.out.println(i+". "+type);
                }
			}
		} catch (Exception e) {
			e.printStackTrace();
	    }
        return i;
    }
}
