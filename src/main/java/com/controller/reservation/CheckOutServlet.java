package com.controller.reservation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CheckOutServlet extends HttpServlet {
	
	 Map<String, Double> roomPrices = new HashMap<>();
	    
	    public CheckOutServlet() {
	        roomPrices.put("single", 100.0);
	        roomPrices.put("double", 150.0);
	        roomPrices.put("suite", 200.0);
	        roomPrices.put("other1", 120.0);  // Add the first additional room type
	        roomPrices.put("other2", 130.0);  // Add the second additional room type
	    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hotelId = request.getParameter("hotelId").trim();
        String roomSelection = request.getParameter("roomSelection");
        String fullName = request.getParameter("fullName");
        String numberOfRooms = request.getParameter("numberOfRooms");
        String numberOfGuests = request.getParameter("numberOfGuests");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String checkInDateStr = request.getParameter("checkInDate");
        String checkOutDateStr = request.getParameter("checkOutDate");

        // Parse check-in and check-out dates
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date checkInDate;
        Date checkOutDate;
        try {
            checkInDate = sdf.parse(checkInDateStr);
            checkOutDate = sdf.parse(checkOutDateStr);
        } catch (ParseException e) {
            throw new ServletException("Error parsing dates", e);
        }
        
        Double roomPrice = roomPrices.get(roomSelection);
        
        if(roomPrice == null) {
        	  RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
              dispatcher.forward(request, response);
        }
        // Calculate date count and cost
        long dateCount = calculateDateCount(checkInDate, checkOutDate);
        
        double totalCost = calculateTotalCost(dateCount, roomPrice, Integer.parseInt(numberOfRooms), Integer.parseInt(numberOfGuests));

        // Store data in session
        HttpSession session = request.getSession();
        session.setAttribute("fullName", fullName);
        session.setAttribute("email", email);
        session.setAttribute("phone", phone);
        session.setAttribute("checkInDate", checkInDateStr);
        session.setAttribute("checkOutDate", checkOutDateStr);
        session.setAttribute("hotelId", hotelId);
        session.setAttribute("roomSelection", roomSelection);
        session.setAttribute("numberOfRooms", numberOfRooms);
        session.setAttribute("numberOfGuests", numberOfGuests);
        session.setAttribute("dateCount", dateCount );
        session.setAttribute("totalCost", totalCost);

        RequestDispatcher dispatcher = request.getRequestDispatcher("checkout.jsp");
        dispatcher.forward(request, response);
    }

    private long calculateDateCount(Date checkInDate, Date checkOutDate) {
        long diffInMillies = Math.abs(checkOutDate.getTime() - checkInDate.getTime());
        return diffInMillies / (24 * 60 * 60 * 1000);  // Convert milliseconds to days
    }

    private double calculateTotalCost(long dateCount, double roomPrice, int numberOfRooms, int numberOfGuests) {
    	
        double totalRoomCost = 0.0;

    		for (int i = 0; i < numberOfRooms; i++) {
    		    if (numberOfGuests <= 2) {
    		        // If there are 2 or fewer guests in the room, charge for 1 room
    		        totalRoomCost += roomPrice;
    		        numberOfGuests = 0;
    		    } else if (numberOfGuests == 3) {
    		        // If there are 3 guests in the room, add 1/2 room charge added
    		        totalRoomCost += 0.5 * roomPrice + roomPrice;
    		        numberOfGuests = 0; // No more guests left
    		    } else if (numberOfGuests >= 4) {
    		        // If there are 4 or more guests in the room, calculate based on guest count
    		        totalRoomCost += (Math.ceil(numberOfGuests / 2.0)) * roomPrice;
    		        numberOfGuests = 0; // No more guests left
    		    }
    		}

    	
        return dateCount * totalRoomCost ;
    }
}

