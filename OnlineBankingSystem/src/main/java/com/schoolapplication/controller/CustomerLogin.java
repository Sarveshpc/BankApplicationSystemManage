package com.schoolapplication.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.schoolapplication.helper.*;

@WebServlet("/loginvalidate")
public class CustomerLogin extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String accountnumber = req.getParameter("accountnumber");
		String pin = req.getParameter("pin");
		
		
		//by using Wrapper Class of concept using a Autofocus concept :
		long accountnum1 =  Long.parseLong(accountnumber);
		int pin1 = Integer.parseInt(pin);
		
		try {
		
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = Helper.getConnect();
			PreparedStatement ps = con.prepareStatement("select * from accountnumber where accountnumber=? and pin=?");
			
			ps.setLong(1, accountnum1);
			ps.setInt(2, pin1);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				PrintWriter pout = resp.getWriter();
				pout.println("<h1 Login Successfully </h1>");
				RequestDispatcher rd=req.getRequestDispatcher("customeroption.html");
				rd.include(req, resp);
				
			}
			else {
				PrintWriter pout = resp.getWriter();
				pout.println("<h1 align='Center' style='color:purple'> Invalid credentials</h1>");
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.include(req, resp);
				
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		} catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
		}
	}
}
		
	

		

