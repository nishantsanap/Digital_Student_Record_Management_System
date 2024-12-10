package com.ty;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/home")
public class Home extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String phoneNo = (String) request.getSession().getAttribute("phone_no");

        request.setAttribute("phone_no", phoneNo);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}


