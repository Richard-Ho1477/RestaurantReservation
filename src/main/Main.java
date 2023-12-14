package main;

import java.sql.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Start connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocerystore","root","");
			// ambil data
			getData(con,"select * from items");
			//insert data
//			insertData(con, "insert into items (name,price,id) values (?,?,?)", "teh pucuk", 6000, 4);
			// Update data
//			updateData(con, "update items set name = ?, price = ? where id = ?", "Sabun mandi", 7000, 1);
			//Delete Data
//			deleteData(con, "delete from items where name = ?", "teh pucuk");
			//close connection to db
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void getData(Connection con, String query) {
		try {
			// Select query
			Statement stmt = con.createStatement();
			// Query yang kita mau panggil
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println("Name: " + rs.getString("name"));
				System.out.println("Price: " + rs.getInt("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insertData(Connection con, String query, String name, int price, int id) {
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.setInt(2, price);
			pst.setInt(3, id);
			int check = pst.executeUpdate(); // value klo 0 berarti ga ada yang nambah
			if(check != 0) System.out.println("Data inserted");
			else System.out.println("Data not inserted");
			getData(con,"select * from items");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateData(Connection con, String query, String name, int price, int id) {
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.setInt(2, price);
			pst.setInt(3, id);
			int check = pst.executeUpdate(); // value klo 0 berarti ga ada yang ke update
			if(check != 0) System.out.println("Data updated");
			else System.out.println("Data not udpated");
			getData(con,"select * from items");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteData(Connection con, String query, String name) {
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, name);
			int check = pst.executeUpdate(); // value klo 0 berarti ga ada yang ke delete
			if(check != 0) System.out.println("Data deleted");
			else System.out.println("Data not deleted");
			getData(con,"select * from items");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}