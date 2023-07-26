package services;
import domain.ItemCategoryDomain;
import domain.ItemLocationDomain;
import domain.InventoryDomain;
import java.sql.*;
import java.util.ArrayList;

public class InventoryServices {
    public static InventoryDomain FetchByID(int id){
        InventoryDomain inventoryDomain = null;
        try{
            Connection connection = DBConnectionService.getConnection();
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Inventory INNER JOIN Item_category ON Inventory.Category_ID = Item_Category.Category_ID INNER JOIN Item_Location ON Inventory.Location_ID = Item_Location.Location_ID WHERE ID = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
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
        }catch (Exception e){
            e.printStackTrace();
        }
        return inventoryDomain;
    }
    public static ArrayList<InventoryDomain> FetchAll(){
        ArrayList<InventoryDomain> inventoryDomains = new ArrayList<>();
        try{
            Connection connection = DBConnectionService.getConnection();
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Inventory INNER JOIN Item_category ON Inventory.Category_ID = Item_Category.Category_ID INNER JOIN Item_Location ON Inventory.Location_ID = Item_Location.Location_ID");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
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
        }catch (Exception e){
            e.printStackTrace();
        }
        return inventoryDomains;
    }

    public static ArrayList<InventoryDomain> FetchAllByCategory(int id) throws ClassNotFoundException{
        ArrayList<InventoryDomain> inventoryDomains = new ArrayList<>();
        try{
            Connection connection = DBConnectionService.getConnection();
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Inventory INNER JOIN Item_category ON Inventory.Category_ID = Item_Category.Category_ID INNER JOIN Item_Location ON Inventory.Location_ID = Item_Location.Location_ID WHERE Inventory.Category_ID = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
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
        }catch (SQLException e){
            e.printStackTrace();
        }
        return inventoryDomains;
    }

    public static ArrayList<InventoryDomain> FetchAllByLocation(int id) throws ClassNotFoundException{
        ArrayList<InventoryDomain> inventoryDomains = new ArrayList<>();
        try{
            Connection connection = DBConnectionService.getConnection();
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Inventory INNER JOIN Item_category ON Inventory.Category_ID = Item_Category.Category_ID INNER JOIN Item_Location ON Inventory.Location_ID = Item_Location.Location_ID WHERE Inventory.Location_ID = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
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
        }catch (SQLException e){
            e.printStackTrace();
            }
        return inventoryDomains;
    }

    public static ArrayList<InventoryDomain> FetchAllByLocationAndCategory(int Loc_ID, int Cat_ID) throws ClassNotFoundException{
        ArrayList<InventoryDomain> inventoryDomains = new ArrayList<>();
        try{
            Connection connection = DBConnectionService.getConnection();
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Inventory INNER JOIN Item_category ON Inventory.Category_ID = Item_Category.Category_ID INNER JOIN Item_Location ON Inventory.Location_ID = Item_Location.Location_ID WHERE Inventory.Location_ID = ? AND Inventory.Category_ID = ?");
            preparedStatement.setInt(1, Loc_ID);
            preparedStatement.setInt(2, Cat_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
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
        } catch (SQLException e){
            e.printStackTrace();
        }
        return inventoryDomains;
    }
}