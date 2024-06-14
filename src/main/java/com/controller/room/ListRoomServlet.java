package com.controller.room;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RoomDAO;
import com.model.Room;

@WebServlet("/list-room")
public class ListRoomServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RoomDAO roomDAO;

    public void init() {
        roomDAO = new RoomDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Room> listRoom = roomDAO.selectAllRooms();
		request.setAttribute("listRoom", listRoom);
		RequestDispatcher dispatcher = request.getRequestDispatcher("room-list.jsp");
		dispatcher.forward(request, response);
    }
}