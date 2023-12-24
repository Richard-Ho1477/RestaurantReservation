package view;

import java.sql.*;

public class ShowEmployee {
    public void showEmployee(String cabang) {
		boolean trigger = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employeelist");
            System.out.println("-----------------------------------------------");
            System.out.printf("| %-7s | %-20s | %-10s |\n", "ID", "Name", "Cabang");
            System.out.println("-----------------------------------------------");
			if(cabang.compareTo("-") == 0) trigger = true;
			while(rs.next()) {
				if(trigger) cabang = rs.getString("cabang");
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
