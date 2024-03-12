package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

	@WebServlet("/editurl")
	public class EditServlet extends HttpServlet {
		private static final String query = "UPDATE CLIENT SET APPOINTMENT_DATE = STR_TO_DATE (?, '%d/%m/%Y'),APPOINTMENT_TYPE = ?,DESCRIPTION =? WHERE APPOINTMENT_ID=?";
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			
			int id = Integer.parseInt(req.getParameter("id"));
			
			//formatter 
//			String appointmentDateStr = req.getParameter("appointment_date");
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
			
			
			//get the edit data
			String Select_appointment = req.getParameter("select_appointment");
			String ApppointmentDate = req.getParameter("appointment_date");
//			Strin AppointmentDate = Integer.parseInt(req.getParameter("appointment_date"));
			String note = req.getParameter("note");
			
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
					
					ps.setString(1,Select_appointment);
					ps.setString(2,ApppointmentDate);
					ps.setString(3,note);
					ps.setInt(1, id);
					
					int count = ps.executeUpdate();
					
					if(count==1) {
						pw.println("<h2>UPDATE SUCCESS</h2>");
					}else {
						pw.println("<h2>NOT SUCCESSFUL UPDATE</h2>");
					}
				
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
