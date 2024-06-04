package Dao;



import Models.Room;
import Connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    private Connection connection;

    public RoomDAO() {
        this.connection = DBConnection.getConnection();
    }

    public void addRoom(Room room) throws SQLException {
        String sql = "INSERT INTO Rooms (room_number, room_type, price, availability) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, room.getRoomNumber());
            stmt.setString(2, room.getRoomType());
            stmt.setDouble(3, room.getPrice());
            stmt.setBoolean(4, room.isAvailability());
            stmt.executeUpdate();
        }
    }

    public List<Room> getAllRooms() throws SQLException {
        String sql = "SELECT * FROM Rooms";
        List<Room> rooms = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Room room = new Room();
                room.setRoomId(rs.getInt("room_id"));
                room.setRoomNumber(rs.getInt("room_number"));
                room.setRoomType(rs.getString("room_type"));
                room.setPrice(rs.getDouble("price"));
                room.setAvailability(rs.getBoolean("availability"));
                rooms.add(room);
            }
        }
        return rooms;
    }

    // Implement updateRoom and deleteRoom similarly
}