package Dao;

import Models.Guest;
import Utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO {
    private Connection connection;

    public GuestDAO() {
        this.connection = DBConnection.getConnection();
    }

    public static List<Guest> getGuestsById(int id) {
        return List.of();
    }

    public void addGuest(Guest guest) throws SQLException {
        String sql = "INSERT INTO Guest (first_name, last_name, email, contact, room_no)" +
                " VALUES (?, ?, ?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, guest.getFirstName());
            stmt.setString(2, guest.getLastName());
            stmt.setString(3, guest.getEmail());
            stmt.setString(3, guest.getContact());
            int room_no=0;
            stmt.setInt(3, guest.getRoom_no(room_no));

            stmt.executeUpdate();
        }
    }

//    public List<Guest> getAllGuests() throws SQLException {
//        String sql = "SELECT * FROM Guests";
//        List<Guest> guests = new ArrayList<>();
//        try (Statement stmt = connection.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//            while (rs.next()) {
//                Guest guest = new Guest();
//                guest.setGuestId(rs.getInt("guest_id"));
//                guest.setFirstName(rs.getString("first_name"));
//                guest.setLastName(rs.getString("last_name"));
//                guest.setEmail(rs.getString("email"));
//                guests.add(guest);
//            }
//        }
//        return guests;
//    }

    public Guest getGuestById(int id) throws SQLException {
        String sql = "SELECT * FROM Guest WHERE guest_id=?";
        Guest guest = null;

        try (Connection conn = (Connection) DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    guest = new Guest();
                    guest.setGuestId(rs.getInt("guest_id"));
                    guest.setFirstName(rs.getString("first_name"));
                    guest.setLastName(rs.getString("last_name"));
                    guest.setEmail(rs.getString("email"));
                    guest.setContact(rs.getString("contact"));
                    guest.setRoom_no(rs.getInt("room_no"));
                    //guest.setContact(String.valueOf(rs.getInt("room_no")));

                }
            }

            return guest;
        }
    }

    public List<Guest> getAllGuest() throws SQLException {
        List<Guest> guests = new ArrayList<>();
        String sql = "SELECT * FROM Guest";

        try (Connection conn = (Connection) DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Guest guest = new Guest();
                guest.setGuestId(rs.getInt("guest_id"));
                guest.setFirstName(rs.getString("first_name"));
                guest.setLastName(rs.getString("last_name"));
                guest.setEmail(rs.getString("email"));
                guest.setContact(rs.getString("contact"));
                guest.setRoom_no(rs.getInt("room_no"));
               // guest.setContact(String.valueOf(Integer.parseInt(String.valueOf(rs.getInt("contact")))));
               // guest.setRoom_no(Integer.parseInt(String.valueOf(rs.getInt("room_no"))));
                guests.add(guest);
            }
        }
        return guests;
    }


    public void updateGuest(Guest guest) throws SQLException {
        String sql = "UPDATE Guest SET first_name = ?, last_name = ?, email = ? WHERE guest_id = ?";

        try (Connection conn = (Connection) DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, guest.getFirstName());
            stmt.setString(2, guest.getLastName());
            stmt.setString(3, guest.getEmail());
            stmt.setInt(4, guest.getGuestId());
            stmt.setString(4, guest.getContact());
            int room_no=0;
            stmt.setInt(4, guest.getRoom_no(room_no));
            stmt.executeUpdate();
        }
    }

    public void deleteGuest(int id) throws SQLException {
        String sql = "DELETE FROM Guest WHERE guest_id = ?";

        try (Connection conn = (Connection) DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }

    }
}