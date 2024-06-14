package com.controller.room;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RoomDAO;
import com.model.Room;

@WebServlet("/update-room")
public class UpdateRoomServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RoomDAO roomDAO;

    public void init() {
        roomDAO = new RoomDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int RoomID = Integer.parseInt(request.getParameter("RoomID"));
            int HotelID = Integer.parseInt(request.getParameter("HotelID"));
            String RoomNumber = request.getParameter("RoomNumber");
            String RoomType = request.getParameter("RoomType");
            float PricePerNight = Float.parseFloat(request.getParameter("PricePerNight"));

            Room room = new Room(RoomID, HotelID, RoomNumber, RoomType, PricePerNight);
            roomDAO.updateRoom(room);
            response.sendRedirect("list-room");
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}