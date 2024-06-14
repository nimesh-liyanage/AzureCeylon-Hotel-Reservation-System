package com.controller.room;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RoomDAO;
import com.model.Room;

@WebServlet("/edit-room")
public class EditRoomFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RoomDAO roomDAO;

    public void init() {
        roomDAO = new RoomDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int RoomID = Integer.parseInt(request.getParameter("RoomID"));
		Room existingRoom = roomDAO.selectRoom(RoomID);
		request.setAttribute("room", existingRoom);
		RequestDispatcher dispatcher = request.getRequestDispatcher("room-form.jsp");
		dispatcher.forward(request, response);
    }
}