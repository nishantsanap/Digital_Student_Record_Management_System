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

@WebServlet("/delete")
public class Delete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String phoneNo = (String) request.getSession().getAttribute("phone_no");		
		String url = "jdbc:postgresql://localhost:5432/task?user=postgres&password=root";

		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM users WHERE phone_no = ?");
			stmt.setString(1, phoneNo);
			int rowsDeleted = stmt.executeUpdate();

			if (rowsDeleted > 0) {
				response.getWriter().println("User data deleted successfully.");
				
			} else {
				response.getWriter().println("User not found.");
			}

			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
