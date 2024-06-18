package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConfig implements GetConfig {

	Connection con = null;

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/springjdbc";
		String usr = "root";
		String pass = "govt";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, usr, pass);
			
			if(con != null) {
				System.out.println("database connected");
			}else {
				System.out.println("Error Occured during database connection");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}