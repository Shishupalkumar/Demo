package hotel.dao;

import hotel.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public static boolean addUser(String username, String password, String email, String contact, String role) {
        boolean success = false;
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO User (username, password, email, contact, role) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            // String email = "";
            preparedStatement.setString(3, email);
            // String contact="";
            preparedStatement.setString(4, contact);

            preparedStatement.setString(5, role);

            int rowsAffected = preparedStatement.executeUpdate();
            success = rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
    public static void viewUserDetails() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM User");
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("contact"),
                        resultSet.getString("role")
                );
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (User user : users) {
            System.out.println(user);
       }

    }



    public static boolean updateUser(int userId, String username, String password, String email, String contact, String role) {
        boolean success = false;
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE User SET username=?, password=?, email=?, contact=?, role=? WHERE user_id=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
           // String email = "";
            preparedStatement.setString(3, email);
           // String contact="";
            preparedStatement.setString(4, contact);
            preparedStatement.setString(5, role);
            preparedStatement.setInt(6, userId);

            int rowsAffected = preparedStatement.executeUpdate();
            success = rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
