package domain;

public class ItemCategoryDomain {
    private int ID;
    private String categoryName;
    public ItemCategoryDomain() {}
    public ItemCategoryDomain(int ID, String categoryName) {
        this.ID = ID;
        this.categoryName = categoryName;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}