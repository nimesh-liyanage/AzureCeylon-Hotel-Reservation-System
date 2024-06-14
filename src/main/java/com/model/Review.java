package com.model;
import java.util.Date;

public class Review {
    private int ReviewID;
    private String UserName;
    private int HotelID;
    private String RoomType;
    private double Rating;
    private String ReviewText;
    private Date ReviewDate;

    public Review() {
        // Default constructor
    }

    public Review(int reviewID, String userName, int hotelID, String RoomType, double rating, String reviewText, Date reviewDate) {
        this.ReviewID = reviewID;
        this.UserName = userName;
        this.HotelID = hotelID;
        this.RoomType = RoomType;
        this.Rating = rating;
        this.ReviewText = reviewText;
        this.ReviewDate = reviewDate;
    }

    // Getters and setters for the above properties

    public Review(int reviewID, double rating, String review) {
    	this.ReviewID = reviewID;
    	this.Rating = rating;
        this.ReviewText = review;

	}

	public int getReviewID() {
        return ReviewID;
    }

    public void setReviewID(int reviewID) {
        this.ReviewID = reviewID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public int getHotelID() {
        return HotelID;
    }

    public void setHotelID(int hotelID) {
        this.HotelID = hotelID;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String RoomType) {
        this.RoomType = RoomType;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        this.Rating = rating;
    }

    public String getReviewText() {
        return ReviewText;
    }

    public void setReviewText(String reviewText) {
        this.ReviewText = reviewText;
    }

    public Date getReviewDate() {
        return ReviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.ReviewDate = reviewDate;
    }
}
