package com.controller.reservation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ReservationDAO;

public class DeleteReservationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int reservationId = Integer.parseInt(request.getParameter("reservationId"));
        
        // Use ReservationDAO to delete the reservation from the database
        ReservationDAO reservationDAO = new ReservationDAO();
        boolean success = reservationDAO.deleteReservation(reservationId);

        if (success) {
            // Deletion successful, you can set an attribute to display a success message
            request.setAttribute("deletionSuccess", true);
        } else {
            // Deletion failed, you can set an attribute to display an error message
            request.setAttribute("deletionFailure", true);
        }

        //Displays the reservations
        request.getRequestDispatcher("reservations.jsp").forward(request, response);
    }
}

