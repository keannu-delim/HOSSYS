package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateAppointment")
public class UpdateServlet extends HttpServlet {
	private static final String query = "SELECT APPOINTMENT_TYPE, APPOINTMENT_DATE, DESCRIPTION FROM CLIENT WHERE APPOINTMENT_ID=?";
	@Override
	//UPDATE CLIENT SET TYPE_OF_APPOINTMENT = ?, APPOINTMENT_DATE = ?, DESCRIPTION = ? WHERE APPOINTMENT_ID=?
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		//get the id
		int id =Integer.parseInt(req.getParameter("id"));
//		String Type = req.getParameter("typeOfAppointment");
//		String Date = req.getParameter("date");
//		String note = req.getParameter("note");
		
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
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
		
			
			if (rs.next()) {
				
				
				//your logic...
				
				pw.println("<form action='editurl?id="+id+"' method='post'>");
				pw.println("<table align='center'>");
				pw.println("<tr>");
				pw.println("<td>Select Appointment</td>");
				pw.println("<td><input type='text' name=select_appointment value='"+rs.getString(1)+"'></td>");
				pw.println("</tr>");
				
				pw.println("<tr>");
				pw.println("<td>AppointmentDate</td>");
				pw.println("<td><input type='text' name=appointment_date value='"+rs.getString(2)+"'></td>");
				pw.println("</tr>");
//				
//				pw.println("<tr>");
//				pw.println("<td>AppointmentDate</td>");
//				pw.println("<td>< input type='text' name=select_appointment value='"+rs.getString(2)+"'></td>");
//				pw.println("</tr>");
//				
//				pw.println("<tr>");
				
				pw.println("<tr>");
				pw.println("<td>Description</td>");
				pw.println("<td><input type='text' name=note value='"+rs.getString(3)+"'></td>");
				pw.println("</tr>");

//				pw.println("<td>Description</td>");
//				pw.println("<td>< input type='text' name=select_appointment value='"+rs.getString(3)+"'></td>");
//				pw.println("</tr>");
//				
				pw.println("<tr>");
				pw.println("<td><input type='submit' value='UPDATE'></td>");
				pw.println("<td><input type='reset' value='CANCEL'></td>");
				pw.println("</tr>");
				
				
				pw.println("</table>");
				pw.println("</form>");
				}
			
			
			

			

//			ps.setString(1, Type);
//			ps.setString(2, Date);
//			ps.setString(3, note);
			
			
//			int rs = ps.executeUpdate();
//		
//			if (rs > 0) {
//			    pw.println("An existing user was updated successfully!");
//			}else {
//				pw.println("An existing user was updated unsuccessfully!");
//			}
			
//			if(count==1) {
//				pw.print("<h2>RECORD IS UPDATED SUCCESSFULLY</h2><br>");
//			}else {
//				pw.print("<h2>RECORD IS NOT UPDATED!!");
//			}
//			
		}catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1>"+ e.getMessage()+ "</h2>");
		}
		pw.print("<a href='Index.jsp'>Login</a>");
		pw.println("<br>");
		pw.println("<a href='Appointment'>Appointments:</a>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}
}