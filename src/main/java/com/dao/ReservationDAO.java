package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.model.Reservation;
import com.util.DBconn;

public class ReservationDAO {
     Connection conn = DBconn.getConnection();
    
     //insert reservations to the table
    public boolean saveReservation(Reservation reservation) {
        String query = "INSERT INTO reservation (username,fullName, email, phone, checkInDate, checkOutDate, hotelId, roomSelection, numberOfRooms, numberOfGuests, dateCount, totalCost, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'reserved')";

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, reservation.getUsername());
            preparedStatement.setString(2, reservation.getFullName());
            preparedStatement.setString(3, reservation.getEmail());
            preparedStatement.setString(4, reservation.getPhone());
            preparedStatement.setString(5, reservation.getCheckInDate());
            preparedStatement.setString(6, reservation.getCheckOutDate());
            preparedStatement.setInt(7, reservation.getHotelId());
            preparedStatement.setString(8, reservation.getRoomSelection());
            preparedStatement.setInt(9, reservation.getNumberOfRooms());
            preparedStatement.setInt(10, reservation.getNumberOfGuests());
            preparedStatement.setInt(11, reservation.getDateCount());
            preparedStatement.setDouble(12, reservation.getTotalCost());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //retrive reservation data from the table
    public List<Reservation> getOgReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservation WHERE status = 'reserved' OR status = 'ongoing' ";

        try (PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setResId(resultSet.getInt("id"));
                reservation.setFullName(resultSet.getString("fullName"));
                reservation.setEmail(resultSet.getString("email"));
                reservation.setPhone(resultSet.getString("phone"));
                reservation.setCheckInDate(resultSet.getString("checkInDate"));
                reservation.setCheckOutDate(resultSet.getString("checkOutDate"));
                reservation.setRoomSelection(resultSet.getString("roomSelection"));
                reservation.setNumberOfRooms(resultSet.getInt("numberOfRooms"));
                reservation.setNumberOfGuests(resultSet.getInt("numberOfGuests"));
                reservation.setDateCount(resultSet.getInt("dateCount"));
                reservation.setTotalCost(resultSet.getDouble("totalCost"));

                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservations;
    }
    
//     public List<Reservation> getClosedReservations() {
//        List<Reservation> reservations = new ArrayList<>();
//        String query = "SELECT * FROM reservation WHERE status = 'closed'";
//
//        try (PreparedStatement preparedStatement = conn.prepareStatement(query);
//             ResultSet resultSet = preparedStatement.executeQuery()) {
//
//            while (resultSet.next()) {
//            	   Reservation reservation = new Reservation();
//                   reservation.setResId(resultSet.getInt("id"));
//                   reservation.setFullName(resultSet.getString("fullName"));
//                   reservation.setEmail(resultSet.getString("email"));
//                   reservation.setPhone(resultSet.getString("phone"));
//                   reservation.setCheckInDate(resultSet.getString("checkInDate"));
//                   reservation.setCheckOutDate(resultSet.getString("checkOutDate"));
//                   reservation.setHotelId(resultSet.getInt("hotelId"));
//                   reservation.setRoomSelection(resultSet.getString("roomSelection"));
//                   reservation.setNumberOfRooms(resultSet.getInt("numberOfRooms"));
//                   reservation.setNumberOfGuests(resultSet.getInt("numberOfGuests"));
//                   reservation.setDateCount(resultSet.getInt("dateCount"));
//                   reservation.setTotalCost(resultSet.getDouble("totalCost"));
//
//                reservations.add(reservation);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return reservations;
//    }
//    
    public List<Reservation> getClosedReservations(String username)  {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservation WHERE status = 'closed' AND username=? ";

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Reservation reservation = new Reservation();
                    reservation.setResId(resultSet.getInt("id"));
                    reservation.setFullName(resultSet.getString("fullName"));
                    reservation.setEmail(resultSet.getString("email"));
                    reservation.setPhone(resultSet.getString("phone"));
                    reservation.setCheckInDate(resultSet.getString("checkInDate"));
                    reservation.setCheckOutDate(resultSet.getString("checkOutDate"));
                    reservation.setHotelId(resultSet.getInt("hotelId"));
                    reservation.setRoomSelection(resultSet.getString("roomSelection"));
                    reservation.setNumberOfRooms(resultSet.getInt("numberOfRooms"));
                    reservation.setNumberOfGuests(resultSet.getInt("numberOfGuests"));
                    reservation.setDateCount(resultSet.getInt("dateCount"));
                    reservation.setTotalCost(resultSet.getDouble("totalCost"));

                    reservations.add(reservation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservations;
    }

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservation ";

        try (PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setResId(resultSet.getInt("id"));
                reservation.setFullName(resultSet.getString("fullName"));
                reservation.setEmail(resultSet.getString("email"));
                reservation.setPhone(resultSet.getString("phone"));
                reservation.setCheckInDate(resultSet.getString("checkInDate"));
                reservation.setCheckOutDate(resultSet.getString("checkOutDate"));
                reservation.setDateCount(resultSet.getInt("dateCount"));
                reservation.setTotalCost(resultSet.getDouble("totalCost"));

                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservations;
    }
    
    // Delete reservations from the table
    public boolean deleteReservation(int reservationId) {
        String query = "DELETE FROM reservation WHERE id = ?";
        
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setInt(1, reservationId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
 // Update reservations from the table
    public boolean updateReservation(Reservation reservation) {
        String query = "UPDATE reservation SET fullName = ?, email = ?, phone = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, reservation.getFullName());
            preparedStatement.setString(2, reservation.getEmail());
            preparedStatement.setString(3, reservation.getPhone());
            preparedStatement.setInt(4, reservation.getResId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //updataing the reservation status time to time
    public void updateReservationStatus() {
        try (Connection conn = DBconn.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("UPDATE reservation SET status = ? WHERE id = ?")) {

            LocalDate currentDate = LocalDate.now();

            // Retrieve reservations from the database
            List<Reservation> reservations = getAllReservations();

            for (Reservation reservation : reservations) {
                LocalDate checkInDate = LocalDate.parse(reservation.getCheckInDate());
                LocalDate checkOutDate = LocalDate.parse(reservation.getCheckOutDate());

                if (currentDate.isBefore(checkInDate)) {
                    // Set status to "reserved" if check-in date is in the future
                    preparedStatement.setString(1, "reserved");
                } else if (currentDate.isBefore(checkOutDate)) {
                    // Set status to "ongoing" if check-in date has passed but check-out date is in the future
                    preparedStatement.setString(1, "ongoing");
                } else {
                    // Set status to "closed" if check-out date has passed
                    preparedStatement.setString(1, "closed");
                }

                preparedStatement.setInt(2, reservation.getResId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
 

}



