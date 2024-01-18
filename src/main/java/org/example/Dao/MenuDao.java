package org.example.Dao;

import org.example.Model.Menu;
import org.example.Util.Connect;

import java.sql.*;

public class MenuDao {

    private Connection connection = Connect.connection();


    // Create operation
    public void createMenu(Menu menu, long storeId) {
        try {
            String query = "INSERT INTO menus (name, price, category) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, menu.getName());
                preparedStatement.setDouble(2, menu.getPrice());
                preparedStatement.setString(3, menu.getCategory());
                preparedStatement.executeUpdate();

                // Get the generated menu ID
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    long menuId = generatedKeys.getLong(1);
                    menu.setId((int) menuId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read operation
    public Menu getMenuById(long menuId) {
        try {
            String query = "SELECT * FROM menus WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setLong(1, menuId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return mapResultSetToMenu(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update operation
    public void updateMenu(Menu menu) {
        try {
            String query = "UPDATE menus SET name=?, price=?, category=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, menu.getName());
                preparedStatement.setDouble(2, menu.getPrice());
                preparedStatement.setString(3, menu.getCategory());
                preparedStatement.setLong(4, menu.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete operation
    public void deleteMenu(long menuId) {
        try {
            String query = "DELETE FROM menus WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setLong(1, menuId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Helper method to map ResultSet to Menu object
    private Menu mapResultSetToMenu(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        double price = resultSet.getDouble("price");
        String category = resultSet.getString("category");
        // Assuming you have a Menu constructor
        return new Menu(name, price, category);
    }
}
