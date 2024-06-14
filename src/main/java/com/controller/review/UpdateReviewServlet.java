package com.controller.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ReservationDAO;
import com.dao.ReviewDAO;
import com.model.Reservation;
import com.model.Review;

public class UpdateReviewServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    // Retrieve updated form data
	    String reviewIdString = request.getParameter("reviewId");
	    String ratingString = request.getParameter("rating");
	    String reviewText = request.getParameter("review-text");

	    // Parse the parameters to the appropriate data types
        int reviewId = Integer.parseInt(reviewIdString);
        double rating = Double.parseDouble(ratingString);

	    // Create a Reservation object with the updated data
	    Review updatedReview = new Review(reviewId, rating, reviewText);

	    // Update the review
	    ReviewDAO reviewDAO = new ReviewDAO();
	    boolean success = reviewDAO.updateReview(updatedReview);

	    if (success) {
	        request.setAttribute("updateSuccess", true);
	        request.getRequestDispatcher("reviews.jsp").forward(request, response);
	    } else {
	        // Update failed
	       request.setAttribute("updateFailure", true);
	       request.getRequestDispatcher("login.jsp").forward(request, response);

	    }
	}

}

