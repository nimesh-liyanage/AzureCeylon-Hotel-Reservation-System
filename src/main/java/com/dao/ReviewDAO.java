package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Review;
import com.util.DBconn;

public class ReviewDAO {
	
    Connection conn = DBconn.getConnection();

    // insert a review into the 'reviews' table
    public boolean insertReview(Review review) {

        String sql = "INSERT INTO reviews (username, hotelID, roomID, Rating, ReviewText, ReviewDate) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, review.getUserName());
            statement.setInt(2, review.getHotelID());
            statement.setString(3, review.getRoomType());
            statement.setDouble(4, review.getRating());
            statement.setString(5, review.getReviewText());
            statement.setDate(6, new java.sql.Date(review.getReviewDate().getTime()));

            // Execute the SQL query to insert the review
            int rowsAffected = statement.executeUpdate();

            // If the insertion was successful, return true; otherwise, return false
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    //retrive review details from database
    public List<Review> getReviews(String username) {
        List<Review> reviews = new ArrayList<>();

        String sql = "SELECT * FROM reviews WHERE username = ?";
        
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Review review = new Review();
                    review.setReviewID(resultSet.getInt("ReviewID"));
                    review.setHotelID(resultSet.getInt("hotelID"));
                    review.setRoomType(resultSet.getString("roomID"));
                    review.setRating(resultSet.getInt("Rating"));
                    review.setReviewText(resultSet.getString("ReviewText"));
                    review.setReviewDate(resultSet.getDate("ReviewDate"));
                    reviews.add(review);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reviews;
    }
    
    // Update reviews from the table
    public boolean updateReview(Review review) {
        String query = "UPDATE reviews SET Rating = ?, ReviewText = ? WHERE ReviewID = ?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setDouble(1, review.getRating());
            preparedStatement.setString(2, review.getReviewText());
            preparedStatement.setInt(3, review.getReviewID());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the SQL exception or log it as needed
            return false;
        }
    }

    // Delete reviews from the table
    public boolean deleteReview(int reviewId) {
        String query = "DELETE FROM reviews WHERE ReviewID = ?";
        
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setInt(1, reviewId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

