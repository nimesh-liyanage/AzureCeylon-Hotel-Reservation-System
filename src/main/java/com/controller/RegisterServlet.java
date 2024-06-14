package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.model.Customer;
import com.util.DBconn;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("userName");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (!password.equals(confirmPassword)) {
            response.getWriter().println("Password and confirmation do not match.");
            return;
        }
       
        Customer customer = new Customer(username, firstName, lastName, email, phone, password);
        
     // Insert user data into the Customer table
        Connection conn = DBconn.getConnection();
        
        try {
            String insertQuery = "INSERT INTO users(username, first_name, last_name,email,phone_number,password,user_type) VALUES (?, ?, ?, ?, ?, ?, 'customer')";
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
          //  preparedStatement.setString(1, id);
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getPhoneNo());
            preparedStatement.setString(6, customer.getPassword());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBconn.closeConnection(conn);
        }

        // Redirect to a confirmation page or perform other actions as needed
        response.sendRedirect("login.jsp");
    }
}
