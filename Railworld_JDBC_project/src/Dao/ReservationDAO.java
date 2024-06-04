package Dao;

import Models.Reservation;
import Utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    private Connection connection;

    public ReservationDAO() {
        this.connection = DBConnection.getConnection();
    }

    public void addReservation(Reservation reservation) throws SQLException {
        String sql = "INSERT INTO Reservations (guest_id, room_id, check_in_date, check_out_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, reservation.getGuestId());
            stmt.setInt(2, reservation.getRoomId());
            stmt.setDate(3, new java.sql.Date(reservation.getCheckInDate().getTime()));
            stmt.setDate(4, new java.sql.Date(reservation.getCheckOutDate().getTime()));
            stmt.executeUpdate();
        }
    }

    public List<Reservation> getAllReservations() throws SQLException {
        String sql = "SELECT * FROM Reservations";
        List<Reservation> reservations = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationId(rs.getInt("reservation_id"));
                reservation.setGuestId(rs.getInt("guest_id"));
                reservation.setRoomId(rs.getInt("room_id"));
                reservation.setCheckInDate(rs.getDate("check_in_date"));
                reservation.setCheckOutDate(rs.getDate("check_out_date"));
                reservations.add(reservation);
            }
        }
        return reservations;
    }

    // Implement updateReservation and deleteReservation similarly
}