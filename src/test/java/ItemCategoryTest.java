import domain.ItemCategoryDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemCategoryTest {
    @Mock
    private ItemCategoryDomain itemCategory;

    @Mock
    private ItemCategoryDomain item;

    @BeforeEach
    public void setUp() {
        itemCategory = new ItemCategoryDomain(1, "Test Category");
    }

    @Test
    public void testGetID() {
        assertEquals(1, itemCategory.getID());
    }

    @Test
    public void testGetIDDefConstructor() {
        item = new ItemCategoryDomain();
        assertEquals(0, item.getID());
    }

    @Test
    public void testGetCategoryName() {
        assertEquals("Test Category", itemCategory.getCategoryName());
    }

    @Test
    public void testSetID() {
        itemCategory.setID(2);
        assertEquals(2, itemCategory.getID());
    }

    @Test
    public void testSetCategoryName() {
        itemCategory.setCategoryName("New Category");
        assertEquals("New Category", itemCategory.getCategoryName());
    }
}
