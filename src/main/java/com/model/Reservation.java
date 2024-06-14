package com.model;

public class Reservation {
	private int resId;
	private String username;
    private String fullName;
    private String email;
    private String phone;
    private String checkInDate;
    private String checkOutDate;
    private int hotelId;
    private String roomSelection;
    private int numberOfRooms;
    private int numberOfGuests;
    private int dateCount;
    private double totalCost;
    private String status;

    // Constructor without parameters
    public Reservation() {}

    // Constructor with parameters
    public Reservation(String username, String fullName, String email, String phone, String checkInDate, String checkOutDate,
                       int dateCount, double totalCost, String status) {
    	this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.dateCount = dateCount;
        this.totalCost = totalCost;
        this.status = status;
    }
    
	//overloading constructors
	public Reservation(int resId, String fullName, String email, String phone) {
    	this.resId = resId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
	}

	public Reservation(String username, String fullName, String email, String phone, String checkInDate,
			String checkOutDate, int hotelId, String roomSelection, int numberOfRooms, int numberOfGuests,
			int dateCount, double totalCost, String status) {
    	this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.hotelId = hotelId;
        this.roomSelection = roomSelection;
        this.numberOfRooms = numberOfRooms;
        this.numberOfGuests = numberOfGuests;
        this.dateCount = dateCount;
        this.totalCost = totalCost;
        this.status = status;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getRoomSelection() {
		return roomSelection;
	}

	public void setRoomSelection(String roomSelection) {
		this.roomSelection = roomSelection;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}
    

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getDateCount() {
        return dateCount;
    }

    public void setDateCount(int dateCount) {
        this.dateCount = dateCount;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
