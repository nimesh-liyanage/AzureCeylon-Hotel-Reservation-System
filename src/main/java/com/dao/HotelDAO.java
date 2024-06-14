package com.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Hotel;
import com.util.DBconn;

public class HotelDAO {
	
	private static final String INSERT_HOTEL_SQL = "INSERT INTO Hotels" + "  (HotelName, Address, ContactNumber, Description, Rating) VALUES "
			+ " (?, ?, ?, ?, ?);";
	
	private static final String SELECT_HOTEL_BY_ID = "SELECT HotelID, HotelName, Address, ContactNumber, Description, Rating FROM Hotels WHERE HotelID =?";
	private static final String SELECT_ALL_HOTELS = "SELECT * FROM Hotels";
	private static final String DELETE_HOTEL_SQL = "DELETE FROM Hotels WHERE HotelID = ?;";
	private static final String UPDATE_HOTEL_SQL = "UPDATE Hotels SET HotelName= ?, Address= ?, ContactNumber= ?, Description= ?, Rating= ? WHERE HotelID = ?;";

	public HotelDAO() {
	}

	
	public void insertHotel(Hotel hotel) throws SQLException {
		System.out.println(INSERT_HOTEL_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection conn = DBconn.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(INSERT_HOTEL_SQL)) {
			preparedStatement.setString(1, hotel.getHotelName());
			preparedStatement.setString(2, hotel.getAddress());
			preparedStatement.setString(3, hotel.getContactNumber());
			preparedStatement.setString(4, hotel.getDescription());
			preparedStatement.setString(5, hotel.getRating());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Hotel selectHotel(int HotelID) {
		Hotel hotel = null;
		// Step 1: Establishing a Connection
		try (Connection conn = DBconn.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = conn.prepareStatement(SELECT_HOTEL_BY_ID);) {
			preparedStatement.setInt(1, HotelID);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String HotelName = rs.getString("HotelName");
				String Address = rs.getString("Address");
				String ContactNumber = rs.getString("ContactNumber");
				String Description = rs.getString("Description");
				String Rating = rs.getString("Rating");
				hotel = new Hotel(HotelID, HotelName, Address, ContactNumber, Description, Rating);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return hotel;
	}

	public List<Hotel> selectAllHotels() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Hotel> hotels = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection conn = DBconn.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_HOTELS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int HotelID = rs.getInt("HotelID");
				String HotelName = rs.getString("HotelName");
				String Address = rs.getString("Address");
				String ContactNumber = rs.getString("ContactNumber");
				String Description = rs.getString("Description");
				String Rating = rs.getString("Rating");
				hotels.add(new Hotel(HotelID, HotelName, Address, ContactNumber, Description, Rating));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return hotels;
	}

	public boolean deleteHotel(int HotelID) throws SQLException {
		boolean rowDeleted;
		try (Connection conn = DBconn.getConnection();
				PreparedStatement statement = conn.prepareStatement(DELETE_HOTEL_SQL);) {
			statement.setInt(1, HotelID);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateHotel(Hotel hotel) throws SQLException {
		boolean rowUpdated;
		try (Connection conn = DBconn.getConnection();
				PreparedStatement statement = conn.prepareStatement(UPDATE_HOTEL_SQL);) {
			System.out.println("updated Hotel:"+statement);
			statement.setString(1, hotel.getHotelName());
			statement.setString(2, hotel.getAddress());
			statement.setString(3, hotel.getContactNumber());
			statement.setString(4, hotel.getDescription());
			statement.setString(5, hotel.getRating());
			statement.setInt(6, hotel.getHotelID());

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
