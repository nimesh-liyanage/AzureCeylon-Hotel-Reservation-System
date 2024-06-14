package com.controller.review;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ReviewDAO;
import com.model.Review;

public class ReviewServlet extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        // Parse the form data and create a Review object
        String userName = request.getParameter("username");
        int hotelId = Integer.parseInt(request.getParameter("hotelId"));
        String roomType = request.getParameter("roomType");
        double rating = Double.parseDouble(request.getParameter("Rating"));
        String reviewText = request.getParameter("review-text");

        // Automatically capture the current date and time
        Date reviewDate = new Date(); // Get the current date and time

        // Create a Review object
        Review review = new Review();
        review.setUserName(userName);
        review.setHotelID(hotelId);
        review.setRoomType(roomType);
        review.setRating(rating);
        review.setReviewText(reviewText);
        review.setReviewDate(reviewDate);

        // Call the insertReview method from your ReviewDAO
        ReviewDAO reviewDAO = new ReviewDAO();
        boolean success = reviewDAO.insertReview(review);

        // Redirect or forward to a response page
        if (success) {
            // Review inserted successfully
            response.sendRedirect("reviews.jsp"); 
        } else {
            // Handle the case where the review insertion fails
            response.sendRedirect("error.jsp"); // Redirect to an error page
        }
    }
}
