package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.DBconn;


public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        Connection conn = null;
        
        try {         
            
             conn = DBconn.getConnection();
            
            String query = "SELECT * FROM users WHERE username=? AND password=? AND user_type=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password); 
            ps.setString(3, "customer"); 
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
            	
            	
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("userdash.jsp"); 
            } else {
            	//Admin login
                ps.setString(3, "admin");
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    response.sendRedirect("admin-dash.jsp");
                } else {
                    // Invalid login, display an error message
                    request.setAttribute("error", "Invalid username or password");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
                       
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBconn.closeConnection(conn);
        }
	}
}
