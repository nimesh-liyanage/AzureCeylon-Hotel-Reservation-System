package com.controller.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ReservationDAO;
import com.dao.ReviewDAO;

public class DeleteReviewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        
        // Use ReservationDAO to delete the reservation from the database
       ReviewDAO reviewDAO = new ReviewDAO();
        boolean success = reviewDAO.deleteReview(reviewId);

        if (success) {
            // Deletion successful, you can set an attribute to display a success message
            request.setAttribute("deletionSuccess", true);
        } else {
            // Deletion failed, you can set an attribute to display an error message
            request.setAttribute("deletionFailure", true);
        }

        //Displays the reservations
        request.getRequestDispatcher("reviews.jsp").forward(request, response);
    }
}

