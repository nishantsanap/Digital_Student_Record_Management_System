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

@WebServlet("/edit")
public class Edit extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String phoneNo = request.getParameter("phone_no");



		request.setAttribute("phone_no", phoneNo);


		
		

		request.getRequestDispatcher("/edit.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String phoneNo = (String) request.getSession().getAttribute("phone_no");
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		String url = "jdbc:postgresql://localhost:5432/task?user=postgres&password=root";
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement stmt = conn.prepareStatement("UPDATE users SET name = ?, email = ? WHERE phone_no = ?");
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, phoneNo);

			int rowsUpdated = stmt.executeUpdate();
			if (rowsUpdated > 0) {
				response.getWriter().println("User data updated successfully.");
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
