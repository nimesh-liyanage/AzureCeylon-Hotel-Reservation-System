package com.controller.hotel;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HotelDAO;
import com.model.Hotel;

@WebServlet("/hotel-insert")
public class InsertHotelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HotelDAO hotelDAO;

    public void init() {
        hotelDAO = new HotelDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String HotelName = request.getParameter("HotelName");
        String Address = request.getParameter("Address");
        String ContactNumber = request.getParameter("ContactNumber");
        String Description = request.getParameter("Description");
        String Rating = request.getParameter("Rating");
        Hotel newHotel = new Hotel(HotelName, Address, ContactNumber, Description, Rating);
        try {
			hotelDAO.insertHotel(newHotel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        response.sendRedirect("hotel-list");
    }
}
