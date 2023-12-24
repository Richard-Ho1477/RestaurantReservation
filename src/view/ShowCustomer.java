package view;

import java.sql.*;

public class ShowCustomer {
    public void showCustomer(String cabang) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customerlist");
            System.out.println("-----------------------------------------------");
            System.out.printf("| %-7s | %-20s | %-10s |\n", "ID", "Name", "Cabang");
            System.out.println("-----------------------------------------------");
			while(rs.next()) {
				if(cabang.compareTo(rs.getString("cabang")) == 0){
					System.out.printf("| %-7s | %-20s | %-10s |\n", rs.getString("id"), rs.getString("name")
					, rs.getString("cabang"));
				}
			}
            System.out.println("-----------------------------------------------");
            con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
