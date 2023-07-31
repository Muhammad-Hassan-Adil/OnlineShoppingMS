package services;
import domain.*;

import javax.ws.rs.NotFoundException;
import java.sql.*;
import java.util.ArrayList;

public class InventoryServices {
    private Connection connection;
    public InventoryServices() {
        try {
            this.connection = DBConnectionService.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public InventoryServices(Connection connection) {
        this.connection = connection;
    }

    public Inventory FetchByID(int id) {
        Inventory inventory = null;
        try {
            ResultSet resultSet = SQLServices.SQLFetchID(id, connection);
            if (resultSet != null && resultSet.next()) {
                inventory = new Inventory();
                inventory.setID(resultSet.getInt("ID"));
                inventory.setItemName(resultSet.getString("Name"));
                inventory.setItemQuantity(resultSet.getInt("Quantity"));
                ItemCategory itemCategory = new ItemCategory();
                itemCategory.setID(resultSet.getInt("Category_ID"));
                itemCategory.setCategoryName(resultSet.getString("Category_Name"));
                inventory.setItemCategory(itemCategory);
                ItemLocation itemLocation = new ItemLocation();
                itemLocation.setID(resultSet.getInt("Location_ID"));
                itemLocation.setLocationName(resultSet.getString("Location_Name"));
                inventory.setItemLocation(itemLocation);
            }
            else{
                throw new NotFoundException("Inventory not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventory;
    }

    public ArrayList<Inventory> FetchAll() {
        ArrayList<Inventory> inventories = new ArrayList<>();
        try {
            ResultSet resultSet = SQLServices.SQLFetchAll(connection);
            while (resultSet != null && resultSet.next()) {
                Inventory inventory = new Inventory();
                inventory.setID(resultSet.getInt("ID"));
                inventory.setItemName(resultSet.getString("Name"));
                inventory.setItemQuantity(resultSet.getInt("Quantity"));
                ItemCategory itemCategory = new ItemCategory();
                itemCategory.setID(resultSet.getInt("Category_ID"));
                itemCategory.setCategoryName(resultSet.getString("Category_Name"));
                inventory.setItemCategory(itemCategory);
                ItemLocation itemLocation = new ItemLocation();
                itemLocation.setID(resultSet.getInt("Location_ID"));
                itemLocation.setLocationName(resultSet.getString("Location_Name"));
                inventory.setItemLocation(itemLocation);
                inventories.add(inventory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inventories;
    }

    public ArrayList<Inventory> FetchAllByCategory(int id) {
        ArrayList<Inventory> inventories = new ArrayList<>();
        try {
            ResultSet resultSet = SQLServices.SQLFetchByCategory(id, connection);
            while (resultSet != null && resultSet.next()) {
                Inventory inventory = new Inventory();
                inventory.setID(resultSet.getInt("ID"));
                inventory.setItemName(resultSet.getString("Name"));
                inventory.setItemQuantity(resultSet.getInt("Quantity"));
                ItemCategory itemCategory = new ItemCategory();
                itemCategory.setID(resultSet.getInt("Category_ID"));
                itemCategory.setCategoryName(resultSet.getString("Category_Name"));
                inventory.setItemCategory(itemCategory);
                ItemLocation itemLocation = new ItemLocation();
                itemLocation.setID(resultSet.getInt("Location_ID"));
                itemLocation.setLocationName(resultSet.getString("Location_Name"));
                inventory.setItemLocation(itemLocation);
                inventories.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventories;
    }

    public ArrayList<Inventory> FetchAllByLocation(int id) {
        ArrayList<Inventory> inventories = new ArrayList<>();
        try {
            ResultSet resultSet = SQLServices.SQLFetchByLocation(id, connection);
            while (resultSet != null && resultSet.next()) {
                Inventory inventory = new Inventory();
                inventory.setID(resultSet.getInt("ID"));
                inventory.setItemName(resultSet.getString("Name"));
                inventory.setItemQuantity(resultSet.getInt("Quantity"));
                ItemCategory itemCategory = new ItemCategory();
                itemCategory.setID(resultSet.getInt("Category_ID"));
                itemCategory.setCategoryName(resultSet.getString("Category_Name"));
                inventory.setItemCategory(itemCategory);
                ItemLocation itemLocation = new ItemLocation();
                itemLocation.setID(resultSet.getInt("Location_ID"));
                itemLocation.setLocationName(resultSet.getString("Location_Name"));
                inventory.setItemLocation(itemLocation);
                inventories.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventories;
    }

    public ArrayList<Inventory> FetchAllByLocationAndCategory(int Loc_ID, int Cat_ID) {
        ArrayList<Inventory> inventories = new ArrayList<>();
        try {
            ResultSet resultSet = SQLServices.SQLFetchByLocationAndCategory(Loc_ID, Cat_ID, connection);
            while (resultSet != null && resultSet.next()) {
                Inventory inventory = new Inventory();
                inventory.setID(resultSet.getInt("ID"));
                inventory.setItemName(resultSet.getString("Name"));
                inventory.setItemQuantity(resultSet.getInt("Quantity"));
                ItemCategory itemCategory = new ItemCategory();
                itemCategory.setID(resultSet.getInt("Category_ID"));
                itemCategory.setCategoryName(resultSet.getString("Category_Name"));
                inventory.setItemCategory(itemCategory);
                ItemLocation itemLocation = new ItemLocation();
                itemLocation.setID(resultSet.getInt("Location_ID"));
                itemLocation.setLocationName(resultSet.getString("Location_Name"));
                inventory.setItemLocation(itemLocation);
                inventories.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventories;
    }

    public boolean AddNewInventoryItem(Inventory inv) {
        return SQLServices.SQLAdd(inv, connection);
    }

    public boolean UpdateExistingInventoryItemByID(Inventory inv) {
        return SQLServices.SQLUpdate(inv, connection);
    }

    public boolean DeleteExistingInventoryItemById(int ID) {
        return SQLServices.SQLDelete(ID, connection);
    }
}