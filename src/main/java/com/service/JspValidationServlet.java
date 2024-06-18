package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.DAO.DbConfig;

public class JspValidationServlet {

	ResultSet rs = null;
	Connection con = null;
	
	public ResultSet DatabaseValidation(String user, String password) {

		DbConfig conf = new DbConfig();
		con = conf.getConnection();
		
		String query = "select * from usrlogin";
		
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
