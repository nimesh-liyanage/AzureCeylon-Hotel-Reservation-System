package com.model;

public class Room {
	private int RoomID;
	private int HotelID;
    private String RoomNumber;
    private String RoomType;
    private float PricePerNight;
    private boolean Availability;
    
	public Room(int roomID, int hotelID, String roomNumber, String roomType, float pricePerNight, boolean availability) {
		RoomID = roomID;
		HotelID = hotelID;
		RoomNumber = roomNumber;
		RoomType = roomType;
		PricePerNight = pricePerNight;
		Availability = availability;
	}
	
	public Room(int roomID, int hotelID, String roomNumber, String roomType, float pricePerNight) {
		RoomID = roomID;
		HotelID = hotelID;
		RoomNumber = roomNumber;
		RoomType = roomType;
		PricePerNight = pricePerNight;
	}
	
	public Room(int hotelID, String roomNumber, String roomType, float pricePerNight) {
		HotelID = hotelID;
		RoomNumber = roomNumber;
		RoomType = roomType;
		PricePerNight = pricePerNight;
	}

	public int getRoomID() {
		return RoomID;
	}

	public int getHotelID() {
		return HotelID;
	}

	public String getRoomNumber() {
		return RoomNumber;
	}

	public String getRoomType() {
		return RoomType;
	}

	public float getPricePerNight() {
		return PricePerNight;
	}

	public boolean isAvailability() {
		return Availability;
	}

	public void setRoomID(int roomID) {
		RoomID = roomID;
	}

	public void setHotelID(int hotelID) {
		HotelID = hotelID;
	}

	public void setRoomNumber(String roomNumber) {
		RoomNumber = roomNumber;
	}

	public void setRoomType(String roomType) {
		RoomType = roomType;
	}

	public void setPricePerNight(float pricePerNight) {
		PricePerNight = pricePerNight;
	}

	public void setAvailability(boolean availability) {
		Availability = availability;
	}
    
    
}
