package com.controller.reservation;

import com.dao.ReservationDAO;
import com.model.Reservation;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateReservationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    // Retrieve updated form data
	    String resIdString = request.getParameter("resId");
 	    String fullName = request.getParameter("fullName");
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phone");
	    
        int resId = Integer.parseInt(resIdString);
	    // Create a Reservation object with the updated data
	    Reservation updatedReservation = new Reservation(resId, fullName, email, phone);

	    // Update the reservation
	    ReservationDAO reservationDAO = new ReservationDAO();
	    boolean success = reservationDAO.updateReservation(updatedReservation);

	    if (success) {
	        request.setAttribute("updateSuccess", true);
	        request.getRequestDispatcher("userdash.jsp").forward(request, response);
	    } else {
	        // Update failed
	        request.setAttribute("updateFailure", true);
	        request.getRequestDispatcher("error.jsp").forward(request, response);
	    }
	}

}

