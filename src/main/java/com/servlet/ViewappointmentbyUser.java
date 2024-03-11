package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

	@WebServlet("/UserAppointment")
	public class ViewappointmentbyUser extends HttpServlet {
		private static final String query = "SELECT APPOINTMENT_ID, PATIENT_NAME ,PATIENT_EMAIL,DOCTOR_NAME, APPOINTMENT_DATE,APPOINTMENT_TYPE,DESCRIPTION FROM CLIENT";
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			
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
				java.sql.ResultSet rs = ps.executeQuery();
				pw.println("<table class='table table-striped' align='center'>");
				pw.println("<tr>");
				pw.println("<th>Appointment Id</th>");
				pw.println("<th>Patient Name</th>");
				pw.println("<th>Patient Email</th>");
				pw.println("<th>Doctor Name</th>");
				pw.println("<th>Appointment Date</th>");
				pw.println("<th>Appointment Type</th>");
				pw.println("<th>Description</th>");
				pw.println("<th>EDIT</th>");
				pw.println("<th>DELETE</th>");
				pw.println("<tr>");
				while(rs.next()) {
					pw.println("<tr>");
					pw.println("<td>" +rs.getInt(1)+"</td>");
					pw.println("<td>" +rs.getString(2)+"</td>");
					pw.println("<td>" +rs.getString(3)+"</td>");
					pw.println("<td>" +rs.getString(4)+"</td>");
					pw.println("<td>" +rs.getString(5)+"</td>");
					pw.println("<td>" +rs.getString(6)+"</td>");
					pw.println("<td>" +rs.getString(7)+"</td>");
					pw.println("<td><a href='UpdateAppointment?id="+rs.getInt(1)+"'</a>EDIT</td>");
					pw.println("<td><a href='deleteurl?id="+rs.getInt(1)+"'</a>DELETE</td>");
					pw.println("<tr>");
				}
				pw.println("</table>");
				
			}catch(Exception e) {
				e.printStackTrace();
				pw.println("<h1>"+ e.getMessage()+ "</h2>");
			}
			pw.print("<a href='index.jsp'>Login</a>");
			pw.println("<br>");
			pw.println("<a href='Appointment'>Appointments:</a>");
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(req, res);
		}
}
