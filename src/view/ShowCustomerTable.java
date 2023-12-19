package view;

import java.sql.*;

public class ShowCustomerTable {
    public int customerTable(String id) {
        int i = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
            ShowTable st = new ShowTable();
            i = st.showTable(con, "select * from romantictable", "Romantic", id, i);
            i = st.showTable(con, "select * from generaltable", "General", id, i);
            i = st.showTable(con, "select * from familytable", "Family", id, i);
            con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
        return i;
    }
}
