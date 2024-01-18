package org.example.Dao;

import org.example.Model.Seller;
import org.example.Util.Connect;

import java.sql.*;

public class SellerDao {

    private Connection connection = Connect.connection();


    // Create operation
    public void createSeller(Seller seller) {
        try {
            String query = "INSERT INTO sellers (id, role, lastName, firstName, email, password, phoneNumber, position, hourlyRate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setLong(1, seller.getId());
                preparedStatement.setString(2, seller.getRole());
                preparedStatement.setString(3, seller.getLastName());
                preparedStatement.setString(4, seller.getFirstName());
                preparedStatement.setString(5, seller.getEmail());
                preparedStatement.setString(6, seller.getPassword());
                preparedStatement.setString(7, seller.getPhoneNumber());
                preparedStatement.setString(8, seller.getPosition());
                preparedStatement.setDouble(9, seller.getHourlyRate());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read operation
    public Seller getSellerById(Long sellerId) {
        try {
            String query = "SELECT * FROM sellers WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setLong(1, sellerId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return mapResultSetToSeller(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update operation
    public void updateSeller(Seller seller) {
        try {
            String query = "UPDATE sellers SET role=?, lastName=?, firstName=?, email=?, password=?, phoneNumber=?, position=?, hourlyRate=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, seller.getRole());
                preparedStatement.setString(2, seller.getLastName());
                preparedStatement.setString(3, seller.getFirstName());
                preparedStatement.setString(4, seller.getEmail());
                preparedStatement.setString(5, seller.getPassword());
                preparedStatement.setString(6, seller.getPhoneNumber());
                preparedStatement.setString(7, seller.getPosition());
                preparedStatement.setDouble(8, seller.getHourlyRate());
                preparedStatement.setLong(9, seller.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete operation
    public void deleteSeller(Long sellerId) {
        try {
            String query = "DELETE FROM sellers WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setLong(1, sellerId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Helper method to map ResultSet to Seller object
    private Seller mapResultSetToSeller(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String role = resultSet.getString("role");
        String lastName = resultSet.getString("lastName");
        String firstName = resultSet.getString("firstName");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        String phoneNumber = resultSet.getString("phoneNumber");
        String position = resultSet.getString("position");
        double hourlyRate = resultSet.getDouble("hourlyRate");
        return new Seller(id, role, lastName, firstName, email, password, phoneNumber, position, hourlyRate);
    }
}
