//package com.ty;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/register")
//public class Register extends HttpServlet {
//	String url = "jdbc:postgresql://localhost:5432/task?user=postgres&password=root";
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String phoneNo = request.getParameter("phone_no");
//		String password = request.getParameter("password");
//
//		try {
//			Class.forName("org.postgresql.Driver");
//			Connection conn = DriverManager.getConnection(url);
//			PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (name, email, phone_no, password) VALUES (?, ?, ?, ?)");
//
//			stmt.setString(1, name);
//			stmt.setString(2, email);
//			stmt.setString(3, phoneNo);
//			stmt.setString(4, password);
//			stmt.executeUpdate();
//			stmt.close();
//			conn.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		response.sendRedirect("login.html");
//
//		// request.setAttribute("phone_no", phoneNo);
//		// request.setAttribute("password", password);
//		// request.getRequestDispatcher("login").forward(request, response);
//	}
//}

package com.ty;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phoneNo = request.getParameter("phone_no");
		String password = request.getParameter("password");

		String url = "jdbc:postgresql://localhost:5432/task?user=postgres&password=root";
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO users (name, email, phone_no, password) VALUES (?, ?, ?, ?)");

			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, phoneNo);
			stmt.setString(4, password);
			stmt.executeUpdate();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("login.html");



	}
}



