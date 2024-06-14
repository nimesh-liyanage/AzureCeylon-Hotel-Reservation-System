package com.model;

public class Hotel {
	private int HotelID;
    private String HotelName;
    private String Address;
    private String ContactNumber;
    private String Description;
    private String Rating;
    
    public Hotel(String HotelName, String Address, String ContactNumber, String Description, String Rating) {
        this.HotelName = HotelName;
        this.Address = Address;
        this.ContactNumber = ContactNumber;
        this.Description = Description;
        this.Rating = Rating;
    }

    public Hotel(int HotelID, String HotelName, String Address, String ContactNumber, String Description, String Rating) {
        this.HotelID = HotelID;
        this.HotelName = HotelName;
        this.Address = Address;
        this.ContactNumber = ContactNumber;
        this.Description = Description;
        this.Rating = Rating;
    }

	public int getHotelID() {
		return HotelID;
	}

	public String getHotelName() {
		return HotelName;
	}

	public String getAddress() {
		return Address;
	}

	public String getContactNumber() {
		return ContactNumber;
	}

	public String getDescription() {
		return Description;
	}

	public String getRating() {
		return Rating;
	}

}
