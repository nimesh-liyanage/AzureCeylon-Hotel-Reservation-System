package com.controller.reservation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ReservationDAO;
import com.model.Reservation;
import java.io.IOException;

public class ReservationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String username = request.getParameter("username");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String checkInDate = request.getParameter("checkInDate");
        String checkOutDate = request.getParameter("checkOutDate");
        int hotelId = Integer.parseInt(request.getParameter("hotelId").trim());
        String roomSelection = request.getParameter("roomSelection").trim();
        int numberOfRooms = Integer.parseInt(request.getParameter("numberOfRooms").trim());
        int numberOfGuests = Integer.parseInt(request.getParameter("numberOfGuests").trim());
        int dateCount = Integer.parseInt(request.getParameter("dateCount"));
        double totalCost = Double.parseDouble(request.getParameter("totalCost"));

        // Create a Reservation object
        Reservation reservation = new Reservation(username, fullName, email, phone, checkInDate, checkOutDate, hotelId, roomSelection, numberOfRooms, numberOfGuests, dateCount,  totalCost, "reserved");

        // Save the reservation in the database
        ReservationDAO reservationDAO = new ReservationDAO();
        boolean success = reservationDAO.saveReservation(reservation);
        reservationDAO.updateReservationStatus();


        if (success) {
            // Reservation successful, set a success attribute and redirect to userdash.jsp
            request.setAttribute("reservationSuccess", true);
            String redirectURL = "userdash.jsp";
            response.sendRedirect(redirectURL);
        } else {
            // Reservation failed, set a failure attribute and redirect to userdash.jsp
            request.setAttribute("reservationFailure", true);
            String redirectURL = "userdash.jsp";
            response.sendRedirect(redirectURL);
        }

    }
}
