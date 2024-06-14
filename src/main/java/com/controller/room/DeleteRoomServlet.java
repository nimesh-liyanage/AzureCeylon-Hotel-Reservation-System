package com.controller.room;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RoomDAO;

@WebServlet("/delete-room")
public class DeleteRoomServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RoomDAO roomDAO;

    public void init() {
        roomDAO = new RoomDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int RoomID = Integer.parseInt(request.getParameter("RoomID"));
            roomDAO.deleteRoom(RoomID);
            response.sendRedirect("list-room");
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}