package com.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Room;
import com.util.DBconn;

public class RoomDAO {
	
	private static final String INSERT_ROOM_SQL = "INSERT INTO Rooms" + "  (HotelID, RoomNumber, RoomType, PricePerNight, Availability) VALUES "
			+ " (?, ?, ?, ?, 1);";
	
	private static final String SELECT_ROOM_BY_ID = "SELECT RoomID, HotelID, RoomNumber, RoomType, PricePerNight FROM Rooms WHERE RoomID =?";
	private static final String SELECT_ALL_ROOMS = "SELECT * FROM Rooms";
	private static final String DELETE_ROOM_SQL = "DELETE FROM Rooms WHERE RoomID = ?;";
	private static final String UPDATE_ROOM_SQL = "UPDATE Rooms SET HotelID= ?, RoomNumber= ?, RoomType= ?, PricePerNight= ? WHERE RoomID = ?;";

	public RoomDAO() {
	}


	public void insertRoom(Room room) throws SQLException {
		System.out.println(INSERT_ROOM_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection conn = DBconn.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(INSERT_ROOM_SQL)) {
			preparedStatement.setInt(1, room.getHotelID());
			preparedStatement.setString(2, room.getRoomNumber());
			preparedStatement.setString(3, room.getRoomType());
			preparedStatement.setFloat(4, room.getPricePerNight());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Room selectRoom(int RoomID) {
		Room room = null;
		// Step 1: Establishing a Connection
		try (Connection conn = DBconn.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ROOM_BY_ID);) {
			preparedStatement.setInt(1, RoomID);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int HotelID = rs.getInt("HotelID");
				String RoomNumber = rs.getString("RoomNumber");
				String RoomType = rs.getString("RoomType");
				float PricePerNight = rs.getFloat("PricePerNight");
				room = new Room(RoomID, HotelID, RoomNumber, RoomType, PricePerNight);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return room;
	}

	public List<Room> selectAllRooms() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Room> rooms = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection conn = DBconn.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_ROOMS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int RoomID = rs.getInt("RoomID");
				int HotelID = rs.getInt("HotelID");
				String RoomNumber = rs.getString("RoomNumber");
				String RoomType = rs.getString("RoomType");
				float PricePerNight = rs.getFloat("PricePerNight");
				boolean Availability = rs.getBoolean("Availability");
				rooms.add(new Room(RoomID, HotelID, RoomNumber, RoomType, PricePerNight, Availability));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return rooms;
	}

	public boolean deleteRoom(int RoomID) throws SQLException {
		boolean rowDeleted;
		try (Connection conn = DBconn.getConnection();
				PreparedStatement statement = conn.prepareStatement(DELETE_ROOM_SQL);) {
			statement.setInt(1, RoomID);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateRoom(Room room) throws SQLException {
		boolean rowUpdated;
		try (Connection conn = DBconn.getConnection();
				PreparedStatement statement = conn.prepareStatement(UPDATE_ROOM_SQL);) {
			System.out.println("updated Room:"+statement);
			statement.setInt(1, room.getHotelID());
			statement.setString(2, room.getRoomNumber());
			statement.setString(3, room.getRoomType());
			statement.setFloat(4, room.getPricePerNight());
			statement.setInt(5, room.getRoomID());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
