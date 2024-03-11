package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.derby.client.am.SqlException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String query = "INSERT INTO CLIENT(PATIENT_NAME,PATIENT_EMAIL,PATIENT_PASSWORD) VALUES(?,?,?)";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		//GET THE INFORMATION IN SIGN UP
		
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		//LOAD JDBC 
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String host = "jdbc:derby://localhost:1527/Hospital_Database;create=true";
        String uName = "admin";
        String uPass= "admin";
		//generate the conn
		try(Connection con = DriverManager.getConnection(host, uName, uPass);

				PreparedStatement ps = con.prepareStatement(query);){
				ps.setString(1, username);
				ps.setString(2, email);
				ps.setString(3, password);
				int count = ps.executeUpdate();
				if(count==1) {
					pw.print("<h2>RECORD IS REGISTERED SUCCESSFULLY</h2><br>");
					pw.print("<a href=Index.jsp>LOGIN</a>");
				}else {
					pw.print("<h2>RECORD IS NOT REGISTERED!!");
				}
				
				
		}catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1>"+ e.getMessage()+ "</h2>");
		}
//		pw.print("<a href='index.jsp'>Login</a>");
//		pw.println("<br>");
//		pw.println("<a href='Appointment'>Appointments:</a>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}
}
