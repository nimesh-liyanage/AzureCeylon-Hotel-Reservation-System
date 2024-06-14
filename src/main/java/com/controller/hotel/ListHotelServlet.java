package com.controller.hotel;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HotelDAO;
import com.model.Hotel;

@WebServlet("/hotel-list")
public class ListHotelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HotelDAO hotelDAO;

    public void init() {
        hotelDAO = new HotelDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Hotel> listHotel = hotelDAO.selectAllHotels();
        request.setAttribute("listHotel", listHotel);
        RequestDispatcher dispatcher = request.getRequestDispatcher("hotel-list.jsp");
        dispatcher.forward(request, response);
    }
}
