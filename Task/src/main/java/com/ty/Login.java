package com.ty;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String phoneNo = request.getParameter("phone_no");
		String password = request.getParameter("password");

		boolean isValidUser = false;
		
		String url = "jdbc:postgresql://localhost:5432/task?user=postgres&password=root";
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE phone_no = ? AND password = ?");
			
			stmt.setString(1, phoneNo);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				isValidUser = true;
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (isValidUser) {
			request.getRequestDispatcher("home").forward(request, response);
		} else {
			response.getWriter().println("Invalid phone number or password.");
		}
		HttpSession session = request.getSession();
		session.setAttribute("phone_no", phoneNo); 


	}
}
