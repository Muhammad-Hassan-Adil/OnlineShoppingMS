import domain.Inventory;
import domain.ItemCategory;
import domain.ItemLocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class InventoryTest {

    @Mock
    private Inventory inventory;
    @Mock
    private Inventory inv;

    @Mock
    private ItemCategory itemCategory;

    @Mock
    private ItemLocation itemLocation;

    @BeforeEach
    public void setUp() {
        inventory = new Inventory(1, "Test Item", 10, itemCategory, itemLocation);
    }

    @Test
    public void testGetID() {
        assertEquals(1, inventory.getID());
    }

    @Test
    public void testGetIDDefConstructor() {
        inv = new Inventory();
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
        ItemCategory newCategory = mock(ItemCategory.class);
        inventory.setItemCategory(newCategory);
        assertEquals(newCategory, inventory.getItemCategory());
    }

    @Test
    public void testSetItemLocation() {
        ItemLocation newLocation = mock(ItemLocation.class);
        inventory.setItemLocation(newLocation);
        assertEquals(newLocation, inventory.getItemLocation());
    }
}
