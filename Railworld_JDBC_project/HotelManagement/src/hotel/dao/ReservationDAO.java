package hotel.dao;

import hotel.model.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {

    public static boolean checkout(int reservationId, int roomId) {
        boolean success = false;
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Delete the reservation
            PreparedStatement deleteReservation = connection.prepareStatement(
                    "DELETE FROM Reservation WHERE reservation_id = ?");
            deleteReservation.setInt(1, reservationId);

            int rowsAffected = deleteReservation.executeUpdate();
            if (rowsAffected > 0) {
                // Update room status to 'available'
                success = RoomDAO.updateRoomStatus(roomId, "available");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    public static void viewReservations() {
        List<Reservation> reservations = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Reservation");
            while (resultSet.next()) {
                Reservation reservation = new Reservation(
                        resultSet.getInt("reservation_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("room_id"),
                        resultSet.getDate("start_date"),
                        resultSet.getDate("end_date")
                );
                reservations.add(reservation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public static void viewReservationsByUser(int userId) {
        List<Reservation> reservations = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Reservation WHERE user_id=?");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reservation reservation = new Reservation(
                        resultSet.getInt("reservation_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("room_id"),
                        resultSet.getDate("start_date"),
                        resultSet.getDate("end_date")
                );
                reservations.add(reservation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public static boolean makeReservation(int userId, int roomId, String startDate, String endDate) {
        boolean success = false;
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Reservation (user_id, room_id, start_date, end_date) VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, roomId);
            preparedStatement.setDate(3, java.sql.Date.valueOf(startDate));
            preparedStatement.setDate(4, java.sql.Date.valueOf(endDate));

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                PreparedStatement updateRoomStatus = connection.prepareStatement(
                        "UPDATE Rooms SET status='booked' WHERE room_id=?");
                updateRoomStatus.setInt(1, roomId);
                updateRoomStatus.executeUpdate();
                success = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
