package domain;

public class ItemLocationDomain {
    private int ID;
    private String locationName;

    public ItemLocationDomain() {
    }

    public ItemLocationDomain(int ID, String locationName) {
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
