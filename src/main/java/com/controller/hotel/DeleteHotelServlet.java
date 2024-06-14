package com.controller.hotel;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HotelDAO;

@WebServlet("/hotel-delete")
public class DeleteHotelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HotelDAO hotelDAO;

    public void init() {
        hotelDAO = new HotelDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int HotelID = Integer.parseInt(request.getParameter("HotelID"));
        try {
			hotelDAO.deleteHotel(HotelID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        response.sendRedirect("hotel-list");
    }
}
