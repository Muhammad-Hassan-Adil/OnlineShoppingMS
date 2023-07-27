import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import domain.InventoryDomain;
import domain.ItemCategoryDomain;
import domain.ItemLocationDomain;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
public class InventoryTest {

    @Mock
    private InventoryDomain inventory;
    @Mock
    private InventoryDomain inv;

    @Mock
    private ItemCategoryDomain itemCategory;

    @Mock
    private ItemLocationDomain itemLocation;

    @BeforeEach
    public void setUp() {
        inventory = new InventoryDomain(1, "Test Item", 10, itemCategory, itemLocation);
    }

    @Test
    public void testGetID() {
        assertEquals(1, inventory.getID());
    }

    @Test
    public void testGetIDDefConstructor(){
        inv = new InventoryDomain();
        assertEquals(0, inv.getID());
    }

    @Test
    public void testGetItemName() {
        assertEquals("Test Item", inventory.getItemName());
    }

    @Test
    public void testGetItemQuantity() {
        assertEquals(10, inventory.getItemQuantity());
    }

    @Test
    public void testGetItemCategory() {
        assertEquals(itemCategory, inventory.getItemCategory());
    }

    @Test
    public void testGetItemLocation() {
        assertEquals(itemLocation, inventory.getItemLocation());
    }

    @Test
    public void testSetID() {
        inventory.setID(2);
        assertEquals(2, inventory.getID());
    }

    @Test
    public void testSetItemName() {
        inventory.setItemName("New Item");
        assertEquals("New Item", inventory.getItemName());
    }

    @Test
    public void testSetItemQuantity() {
        inventory.setItemQuantity(20);
        assertEquals(20, inventory.getItemQuantity());
    }

    @Test
    public void testSetItemCategory() {
        ItemCategoryDomain newCategory = mock(ItemCategoryDomain.class);
        inventory.setItemCategory(newCategory);
        assertEquals(newCategory, inventory.getItemCategory());
    }

    @Test
    public void testSetItemLocation() {
        ItemLocationDomain newLocation = mock(ItemLocationDomain.class);
        inventory.setItemLocation(newLocation);
        assertEquals(newLocation, inventory.getItemLocation());
    }
}
