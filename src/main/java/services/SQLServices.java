package services;
import java.sql.*;
import domain.Inventory;
public class SQLServices {
    public static ResultSet SQLFetchID(int id, Connection connection){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Inventory INNER JOIN Item_category ON Inventory.Category_ID = Item_Category.Category_ID INNER JOIN Item_Location ON Inventory.Location_ID = Item_Location.Location_ID WHERE ID = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            connection.close();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet SQLFetchAll(Connection connection){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Inventory INNER JOIN Item_category ON Inventory.Category_ID = Item_Category.Category_ID INNER JOIN Item_Location ON Inventory.Location_ID = Item_Location.Location_ID");
            ResultSet resultSet = preparedStatement.executeQuery();
            connection.close();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet SQLFetchByCategory(int id, Connection connection){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Inventory INNER JOIN Item_category ON Inventory.Category_ID = Item_Category.Category_ID INNER JOIN Item_Location ON Inventory.Location_ID = Item_Location.Location_ID WHERE Inventory.Category_ID = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            connection.close();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet SQLFetchByLocation(int id, Connection connection){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Inventory INNER JOIN Item_category ON Inventory.Category_ID = Item_Category.Category_ID INNER JOIN Item_Location ON Inventory.Location_ID = Item_Location.Location_ID WHERE Inventory.Location_ID = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            connection.close();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet SQLFetchByLocationAndCategory(int Loc_ID, int Cat_ID, Connection connection){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Inventory INNER JOIN Item_category ON Inventory.Category_ID = Item_Category.Category_ID INNER JOIN Item_Location ON Inventory.Location_ID = Item_Location.Location_ID WHERE Inventory.Location_ID = ? AND Inventory.Category_ID = ?");
            preparedStatement.setInt(1, Loc_ID);
            preparedStatement.setInt(2, Cat_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            connection.close();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean SQLAdd(Inventory inventory, Connection connection){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Inventory (ID, Name, Quantity, Category_ID, Location_ID) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, inventory.getID());
            preparedStatement.setString(2, inventory.getItemName());
            preparedStatement.setInt(3, inventory.getItemQuantity());
            preparedStatement.setInt(4, inventory.getItemCategory().getID());
            preparedStatement.setInt(5, inventory.getItemLocation().getID());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("SELECT * FROM Inventory INNER JOIN Item_category ON Inventory.Category_ID = Item_Category.Category_ID INNER JOIN Item_Location ON Inventory.Location_ID = Item_Location.Location_ID WHERE ID = (SELECT MAX(ID) FROM Inventory)");
            ResultSet resultSet = preparedStatement.executeQuery();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean SQLUpdate(Inventory inventory, Connection connection){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Inventory SET Name = ?, Quantity = ?, Category_ID = ?, Location_ID = ? WHERE ID = ?");
            preparedStatement.setString(1, inventory.getItemName());
            preparedStatement.setInt(2, inventory.getItemQuantity());
            preparedStatement.setInt(3, inventory.getItemCategory().getID());
            preparedStatement.setInt(4, inventory.getItemLocation().getID());
            preparedStatement.setInt(5, inventory.getID());
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean SQLDelete(int id, Connection connection){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Inventory WHERE ID = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
