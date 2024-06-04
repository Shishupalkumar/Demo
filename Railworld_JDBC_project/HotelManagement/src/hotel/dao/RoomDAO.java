package hotel.dao;

import hotel.model.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    public static boolean updateRoomStatus(int roomId, String status) {
        boolean success = false;
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE Rooms SET status = ? WHERE room_id = ?");
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, roomId);

            int rowsAffected = preparedStatement.executeUpdate();
            success = rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    public static void viewRoomStatus() {
        List<Room> rooms = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Rooms");
            while (resultSet.next()) {
                Room room = new Room(
                        resultSet.getInt("room_id"),
                        resultSet.getString("room_number"),
                        resultSet.getString("status")
                );
                rooms.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    public static void viewAvailableRooms() {
        List<Room> rooms = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Rooms WHERE status='available'");
            while (resultSet.next()) {
                Room room = new Room(
                        resultSet.getInt("room_id"),
                        resultSet.getString("room_number"),
                        resultSet.getString("status")
                );
                rooms.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Room room : rooms) {
            System.out.println(room);
        }
    }
}
