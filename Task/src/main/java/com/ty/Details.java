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

@WebServlet("/details")
public class Details extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	String phoneNo = (String) request.getSession().getAttribute("phone_no");
        String url = "jdbc:postgresql://localhost:5432/task?user=postgres&password=root";

		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(url);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE phone_no = ?");
            stmt.setString(1, phoneNo);

            ResultSet rs = stmt.executeQuery();

//            if (rs.next()) {
//                response.getWriter().println("Name: " + rs.getString("name"));
//                response.getWriter().println("Email: " + rs.getString("email"));
//                response.getWriter().println("Phone No: " + rs.getString("phone_no"));
//            } else {
//                response.getWriter().println("User not found.");
//            }
            
            if (rs.next()) {
                request.setAttribute("name", rs.getString("name"));
                request.setAttribute("email", rs.getString("email"));
                request.setAttribute("phone_no", rs.getString("phone_no"));
            } else {
                request.setAttribute("error", "User not found.");
            }
            request.getRequestDispatcher("/Details.jsp").forward(request, response);



            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

