package domain;

public class ItemLocation {
    private int ID;
    private String locationName;

    public ItemLocation() {
    }

    public ItemLocation(int ID, String locationName) {
        this.ID = ID;
        this.locationName = locationName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
