package domain;

public class InventoryDomain {
    private int ID, itemQuantity;
    private String itemName;
    private ItemCategoryDomain itemCategory;
    private ItemLocationDomain itemLocation;

    public InventoryDomain() {
    }

    public InventoryDomain(int ID, String itemName, int itemQuantity, ItemCategoryDomain itemCategory, ItemLocationDomain itemLocation) {
        this.ID = ID;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemCategory = itemCategory;
        this.itemLocation = itemLocation;
    }

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
}

