package com.controller.hotel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HotelDAO;
import com.model.Hotel;

@WebServlet("/hotel-edit")
public class EditHotelFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HotelDAO hotelDAO;

    public void init() {
        hotelDAO = new HotelDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int HotelID = Integer.parseInt(request.getParameter("HotelID"));
        Hotel existingHotel = hotelDAO.selectHotel(HotelID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("hotel-form.jsp");
        request.setAttribute("hotel", existingHotel);
        dispatcher.forward(request, response);
    }
}
