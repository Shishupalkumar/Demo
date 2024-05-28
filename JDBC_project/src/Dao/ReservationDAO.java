package Dao;

import Model.Reservation;
import Utility.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    public boolean reserveRoom(Connection connection, Reservation reservation) {
        String sql = "INSERT INTO reservations (guest_name, room_number, contact_number) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, reservation.getGuestName());
            statement.setInt(2, reservation.getRoomNumber());
            statement.setString(3, reservation.getContactNumber());

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    reservation.setReservationId(generatedKeys.getInt(1));
                }
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Reservation> viewReservations(Connection connection) {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT reservation_id, guest_name, room_number, contact_number, reservation_date FROM reservations";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationId(resultSet.getInt("reservation_id"));
                reservation.setGuestName(resultSet.getString("guest_name"));
                reservation.setRoomNumber(resultSet.getInt("room_number"));
                reservation.setContactNumber(resultSet.getString("contact_number"));
                reservation.setReservationDate(resultSet.getTimestamp("reservation_date").toString());

                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    public Integer getRoomNumber(Connection connection, int reservationId, String guestName) {
        String sql = "SELECT room_number FROM reservations WHERE reservation_id = ? AND guest_name = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reservationId);
            statement.setString(2, guestName);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("room_number");
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateReservation(Connection connection, Reservation reservation) {
        String sql = "UPDATE reservations SET guest_name = ?, room_number = ?, contact_number = ? WHERE reservation_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, reservation.getGuestName());
            statement.setInt(2, reservation.getRoomNumber());
            statement.setString(3, reservation.getContactNumber());
            statement.setInt(4, reservation.getReservationId());

            int affectedRows = statement.executeUpdate();

            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteReservation(Connection connection, int reservationId) {
        String sql = "DELETE FROM reservations WHERE reservation_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reservationId);

            int affectedRows = statement.executeUpdate();

            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean reservationExists(Connection connection, int reservationId) {
        String sql = "SELECT reservation_id FROM reservations WHERE reservation_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reservationId);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

