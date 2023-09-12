package com.schoolapplication.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;
import com.schoolapplication.helper.Helper;

@WebServlet("/createadmindata")
public class SaveAdmin extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		//by using Wrapper Class can be used a auto-focus concept :
		int id1 = Integer.parseInt(id);
		
		//by using a random class can be used :
		Random r1 = new Random();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","Sarvesh@1234");
			PreparedStatement ps = con.prepareStatement("insert into admin1(id,email,password)values(?,?,?)");
			
			
					
			
			ps.setInt(1, id1);
			ps.setString(2, email);
			ps.setString(3,password);
//		    Statement rs = con.createStatement(); 
			ResultSet rs = ps.executeQuery();
			
			
				
				if(rs.next()) {
					PrintWriter pout = resp.getWriter();
					pout.println("<h1 admin account created Successfully </h1>");
					RequestDispatcher rd=req.getRequestDispatcher("customeroperation.html");
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
		}
		
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		PrintWriter pout = resp.getWriter();
		
		pout.print("<h1 align='center',style='color:red'>Admin Account created successfully</h1>");
//		
		RequestDispatcher rd = req.getRequestDispatcher("createadmin.html");
		rd.include(req, resp);
	}
}
		
		
		
	


