package org.example.Dao;

import org.example.Model.User;
import org.example.Util.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private Connection connection = Connect.connection();

    // Create operation
    public void createUser(User user) {
        try {
            String query = "INSERT INTO users (id, user_role, last_name, first_name, email, password, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setLong(1, user.getId());
                preparedStatement.setString(2, user.getRole());
                preparedStatement.setString(3, user.getLastName());
                preparedStatement.setString(4, user.getFirstName());
                preparedStatement.setString(5, user.getEmail());
                preparedStatement.setString(6, user.getPassword());
                preparedStatement.setString(7, user.getPhoneNumber());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read operation
    public User getUserById(Long userId) {
        try {
            String query = "SELECT * FROM users WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setLong(1, userId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return mapResultSetToUser(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update operation
    public void updateUser(User user) {
        try {
            String query = "UPDATE users SET user_role=?, last_name=?, first_name=?, email=?, password=?, phone_number=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, user.getRole());
                preparedStatement.setString(2, user.getLastName());
                preparedStatement.setString(3, user.getFirstName());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setString(5, user.getPassword());
                preparedStatement.setString(6, user.getPhoneNumber());
                preparedStatement.setLong(7, user.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete operation
    public void deleteUser(Long userId) {
        try {
            String query = "DELETE FROM users WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setLong(1, userId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Helper method to map ResultSet to User object
    private User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setRole(resultSet.getString("user_role"));
        user.setLastName(resultSet.getString("last_name"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setPhoneNumber(resultSet.getString("phone_number"));
        return user;
    }
}
