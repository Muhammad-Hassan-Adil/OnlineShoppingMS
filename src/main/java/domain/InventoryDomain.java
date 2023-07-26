package domain;

public class InventoryDomain {
    private int ID, itemQuantity;
    private String itemName;
    private ItemCategoryDomain itemCategory;
    private ItemLocationDomain itemLocation;
    public InventoryDomain() {}
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getItemQuantity() {
        return itemQuantity;
    }
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
    public ItemCategoryDomain getItemCategory() {
        return itemCategory;
    }
    public void setItemCategory(ItemCategoryDomain itemCategory) {
        this.itemCategory = itemCategory;
    }
    public ItemLocationDomain getItemLocation() {
        return itemLocation;
    }
    public void setItemLocation(ItemLocationDomain itemLocation) {
        this.itemLocation = itemLocation;
    }
    public String toString(){
        return "ID: " + ID + "\n" +
                "Item Name: " + itemName + "\n" +
                "Item Quantity: " + itemQuantity + "\n" +
                "Item Category: " + itemCategory.getID() + "\n" +
                "Item Location: " + itemLocation.getLocationName() + "\n";
    }
}

