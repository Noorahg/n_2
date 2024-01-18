package org.example.Dao;

import org.example.Model.Store;
import org.example.Util.Connect;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreDao {
    private Connection connection = Connect.connection();
    // Create operation
        public void createStore(Store store) {
            try {
                String query = "INSERT INTO stores (id, address, phoneNumber, email) VALUES (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setLong(1, store.getId());
                    preparedStatement.setString(2, store.getAddress());
                    preparedStatement.setString(3, store.getPhoneNumber());
                    preparedStatement.setString(4, store.getEmail());
                    preparedStatement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Read operation
        public Store getStoreById(long storeId) {
            try {
                String query = "SELECT * FROM stores WHERE id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setLong(1, storeId);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            return mapResultSetToStore(resultSet);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        // Update operation
        public void updateStore(Store store) {
            try {
                String query = "UPDATE stores SET address=?, phoneNumber=?, email=? WHERE id=?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, store.getAddress());
                    preparedStatement.setString(2, store.getPhoneNumber());
                    preparedStatement.setString(3, store.getEmail());
                    preparedStatement.setLong(4, store.getId());
                    preparedStatement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    // Helper method to map ResultSet to Store object
    private Store mapResultSetToStore(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String address = resultSet.getString("address");
        String phoneNumber = resultSet.getString("phoneNumber");
        String email = resultSet.getString("email");
        // Assuming you have similar methods for fetching Menu  data
        return new Store(id, address, phoneNumber, email);
    }
        // Delete operation
        public void deleteStore(long storeId) {
            try {
                String query = "DELETE FROM stores WHERE id=?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setLong(1, storeId);
                    preparedStatement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }





    }


