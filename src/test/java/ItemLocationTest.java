import domain.ItemLocationDomain;
import org.junit.jupiter.api.*;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemLocationTest {
    @Mock

    private ItemLocationDomain itemLocation;

    @Mock
    private ItemLocationDomain item;

    @BeforeEach
    public void setUp() {
        itemLocation = new ItemLocationDomain(1, "Test Location");
    }

    @Test
    public void testGetID() {
        assertEquals(1, itemLocation.getID());
    }

    @Test
    public void testGetIDDefConstructor(){
        item = new ItemLocationDomain();
        assertEquals(0, item.getID());
    }

    @Test
    public void testGetLocationName() {
        assertEquals("Test Location", itemLocation.getLocationName());
    }

    @Test
    public void testSetID() {
        itemLocation.setID(2);
        assertEquals(2, itemLocation.getID());
    }

    @Test
    public void testSetLocationName() {
        itemLocation.setLocationName("New Location");
        assertEquals("New Location", itemLocation.getLocationName());
    }
}

