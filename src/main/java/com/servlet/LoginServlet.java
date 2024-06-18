package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.JspValidationServlet;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String usr = request.getParameter("user");
		String pass = request.getParameter("pass");

		JspValidationServlet obj = new JspValidationServlet();
		ResultSet rs = obj.DatabaseValidation(usr, pass);
		boolean flag = true;
		
		String tbl_usr = null, tbl_pass= null;
		try {
			while (rs.next()) {
				
				tbl_usr = rs.getString(1);
				tbl_pass = rs.getString(2);
				
				if (tbl_usr.equalsIgnoreCase(usr) && tbl_pass.equalsIgnoreCase(pass)) {

					out.println("<html><head><title>");
					out.println("jspValidationServlet </title>");
					out.println("<link rel='stylesheet' href='loginStyle.css' >");
					out.println("<body> <form>");
					out.println("<h1>jsp data on servlet!!! </h1>");
					out.println("<h2>User_Id: </h2>" + tbl_usr);
					out.println("<h3>Password: </h3>" + tbl_pass);
					out.println("</form></body></html>");
					flag = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			out.println("Invalid Credentials! Try Again!");
		}
	}
}