package services;

import domain.InventoryDomain;
import domain.ItemCategoryDomain;
import domain.ItemLocationDomain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InventoryServices {
    private Connection connection;

    public InventoryServices() throws ClassNotFoundException {
        this.connection = DBConnectionService.getConnection();
    }

    public InventoryServices(Connection connection) {
        this.connection = connection;
    }

    public InventoryDomain FetchByID(int id) {
        InventoryDomain inventoryDomain = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Inventory INNER JOIN Item_category ON Inventory.Category_ID = Item_Category.Category_ID INNER JOIN Item_Location ON Inventory.Location_ID = Item_Location.Location_ID WHERE ID = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                inventoryDomain = new InventoryDomain();
                inventoryDomain.setID(resultSet.getInt("ID"));
                inventoryDomain.setItemName(resultSet.getString("Name"));
                inventoryDomain.setItemQuantity(resultSet.getInt("Quantity"));
                ItemCategoryDomain itemCategoryDomain = new ItemCategoryDomain();
                itemCategoryDomain.setID(resultSet.getInt("Category_ID"));
                itemCategoryDomain.setCategoryName(resultSet.getString("Category_Name"));
                inventoryDomain.setItemCategory(itemCategoryDomain);
                ItemLocationDomain itemLocationDomain = new ItemLocationDomain();
                itemLocationDomain.setID(resultSet.getInt("Location_ID"));
                itemLocationDomain.setLocationName(resultSet.getString("Location_Name"));
                inventoryDomain.setItemLocation(itemLocationDomain);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inventoryDomain;
    }

    public ArrayList<InventoryDomain> FetchAll() {
        ArrayList<InventoryDomain> inventoryDomains = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Inventory INNER JOIN Item_category ON Inventory.Category_ID = Item_Category.Category_ID INNER JOIN Item_Location ON Inventory.Location_ID = Item_Location.Location_ID");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                InventoryDomain inventoryDomain = new InventoryDomain();
                inventoryDomain.setID(resultSet.getInt("ID"));
                inventoryDomain.setItemName(resultSet.getString("Name"));
                inventoryDomain.setItemQuantity(resultSet.getInt("Quantity"));
                ItemCategoryDomain itemCategoryDomain = new ItemCategoryDomain();
                itemCategoryDomain.setID(resultSet.getInt("Category_ID"));
                itemCategoryDomain.setCategoryName(resultSet.getString("Category_Name"));
                inventoryDomain.setItemCategory(itemCategoryDomain);
                ItemLocationDomain itemLocationDomain = new ItemLocationDomain();
                itemLocationDomain.setID(resultSet.getInt("Location_ID"));
                itemLocationDomain.setLocationName(resultSet.getString("Location_Name"));
                inventoryDomain.setItemLocation(itemLocationDomain);
                inventoryDomains.add(inventoryDomain);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inventoryDomains;
    }

    public ArrayList<InventoryDomain> FetchAllByCategory(int id) throws ClassNotFoundException {
        ArrayList<InventoryDomain> inventoryDomains = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Inventory INNER JOIN Item_category ON Inventory.Category_ID = Item_Category.Category_ID INNER JOIN Item_Location ON Inventory.Location_ID = Item_Location.Location_ID WHERE Inventory.Category_ID = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                InventoryDomain inventoryDomain = new InventoryDomain();
                inventoryDomain.setID(resultSet.getInt("ID"));
                inventoryDomain.setItemName(resultSet.getString("Name"));
                inventoryDomain.setItemQuantity(resultSet.getInt("Quantity"));
                ItemCategoryDomain itemCategoryDomain = new ItemCategoryDomain();
                itemCategoryDomain.setID(resultSet.getInt("Category_ID"));
                itemCategoryDomain.setCategoryName(resultSet.getString("Category_Name"));
                inventoryDomain.setItemCategory(itemCategoryDomain);
                ItemLocationDomain itemLocationDomain = new ItemLocationDomain();
                itemLocationDomain.setID(resultSet.getInt("Location_ID"));
                itemLocationDomain.setLocationName(resultSet.getString("Location_Name"));
                inventoryDomain.setItemLocation(itemLocationDomain);
                inventoryDomains.add(inventoryDomain);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventoryDomains;
    }

    public ArrayList<InventoryDomain> FetchAllByLocation(int id) throws ClassNotFoundException {
        ArrayList<InventoryDomain> inventoryDomains = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Inventory INNER JOIN Item_category ON Inventory.Category_ID = Item_Category.Category_ID INNER JOIN Item_Location ON Inventory.Location_ID = Item_Location.Location_ID WHERE Inventory.Location_ID = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                InventoryDomain inventoryDomain = new InventoryDomain();
                inventoryDomain.setID(resultSet.getInt("ID"));
                inventoryDomain.setItemName(resultSet.getString("Name"));
                inventoryDomain.setItemQuantity(resultSet.getInt("Quantity"));
                ItemCategoryDomain itemCategoryDomain = new ItemCategoryDomain();
                itemCategoryDomain.setID(resultSet.getInt("Category_ID"));
                itemCategoryDomain.setCategoryName(resultSet.getString("Category_Name"));
                inventoryDomain.setItemCategory(itemCategoryDomain);
                ItemLocationDomain itemLocationDomain = new ItemLocationDomain();
                itemLocationDomain.setID(resultSet.getInt("Location_ID"));
                itemLocationDomain.setLocationName(resultSet.getString("Location_Name"));
                inventoryDomain.setItemLocation(itemLocationDomain);
                inventoryDomains.add(inventoryDomain);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventoryDomains;
    }

    public ArrayList<InventoryDomain> FetchAllByLocationAndCategory(int Loc_ID, int Cat_ID) throws ClassNotFoundException {
        ArrayList<InventoryDomain> inventoryDomains = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Inventory INNER JOIN Item_category ON Inventory.Category_ID = Item_Category.Category_ID INNER JOIN Item_Location ON Inventory.Location_ID = Item_Location.Location_ID WHERE Inventory.Location_ID = ? AND Inventory.Category_ID = ?");
            preparedStatement.setInt(1, Loc_ID);
            preparedStatement.setInt(2, Cat_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                InventoryDomain inventoryDomain = new InventoryDomain();
                inventoryDomain.setID(resultSet.getInt("ID"));
                inventoryDomain.setItemName(resultSet.getString("Name"));
                inventoryDomain.setItemQuantity(resultSet.getInt("Quantity"));
                ItemCategoryDomain itemCategoryDomain = new ItemCategoryDomain();
                itemCategoryDomain.setID(resultSet.getInt("Category_ID"));
                itemCategoryDomain.setCategoryName(resultSet.getString("Category_Name"));
                inventoryDomain.setItemCategory(itemCategoryDomain);
                ItemLocationDomain itemLocationDomain = new ItemLocationDomain();
                itemLocationDomain.setID(resultSet.getInt("Location_ID"));
                itemLocationDomain.setLocationName(resultSet.getString("Location_Name"));
                inventoryDomain.setItemLocation(itemLocationDomain);
                inventoryDomains.add(inventoryDomain);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventoryDomains;
    }

    public void AddNewInventoryItem(InventoryDomain inv) throws ClassNotFoundException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Inventory (ID,Name, Quantity, Category_ID, Location_ID) VALUES (?, ?, ?, ?,?)");
            preparedStatement.setInt(1, inv.getID());
            preparedStatement.setString(2, inv.getItemName());
            preparedStatement.setInt(3, inv.getItemQuantity());
            preparedStatement.setInt(4, inv.getItemCategory().getID());
            preparedStatement.setInt(5, inv.getItemLocation().getID());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateExistingInventoryItemByID(InventoryDomain inv) throws ClassNotFoundException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Inventory SET Name = ?, Quantity = ?, Category_ID = ?, Location_ID = ? WHERE ID = ?");
            preparedStatement.setString(1, inv.getItemName());
            preparedStatement.setInt(2, inv.getItemQuantity());
            preparedStatement.setInt(3, inv.getItemCategory().getID());
            preparedStatement.setInt(4, inv.getItemLocation().getID());
            preparedStatement.setInt(5, inv.getID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteExistingInventoryItemById(int ID) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Inventory WHERE ID = ?");
            preparedStatement.setInt(1, ID);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}