import com.google.gson.Gson;
import domain.Inventory;
import javax.ws.rs.NotFoundException;
import org.junit.jupiter.api.*;
import resources.MainResource;
import services.InventoryServices;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MainResourceTest {

    private InventoryServices inventoryServices;
    private MainResource mainResource;

    @BeforeEach
    public void setUp() {
        inventoryServices = mock(InventoryServices.class);
        mainResource = new MainResource();
        mainResource.InventoryServices = inventoryServices;
    }

    @Test
    public void testFetchById() {
        int inventoryId = 1;
        Inventory inventory = new Inventory();
        inventory.setID(inventoryId);
        when(inventoryServices.FetchByID(inventoryId)).thenReturn(inventory);
        String result = mainResource.Fetchid(inventoryId);
        assertEquals(new Gson().toJson(inventory), result);
    }

    @Test
    public void testFetchAllInventory() {
        ArrayList<Inventory> inventoryList = new ArrayList<>();
        Inventory inventory = new Inventory();
        inventory.setID(1);
        inventory.setItemName("Test Item");
        inventory.setItemQuantity(10);
        inventoryList.add(inventory);
        when(inventoryServices.FetchAll()).thenReturn(inventoryList);
        String result = mainResource.FetchAllInventory();
        String expectedJson = new Gson().toJson(inventoryList);
        assertEquals(expectedJson, result);
    }

    @Test
    public void TestFetchAllByCategory() {
        ArrayList<Inventory> inventoryList = new ArrayList<>();
        Inventory inventory = new Inventory();
        inventory.setID(1);
        inventory.setItemName("Test Item");
        inventory.setItemQuantity(10);
        inventoryList.add(inventory);
        when(inventoryServices.FetchAllByCategory(1)).thenReturn(inventoryList);
        String result = mainResource.FetchAllByCategory(1);
        String expectedJson = new Gson().toJson(inventoryList);
        assertEquals(expectedJson, result);
    }

    @Test
    public void TestFetchAllByLocation() {
        ArrayList<Inventory> inventoryList = new ArrayList<>();
        Inventory inventory = new Inventory();
        inventory.setID(1);
        inventory.setItemName("Test Item");
        inventory.setItemQuantity(10);
        inventoryList.add(inventory);
        when(inventoryServices.FetchAllByLocation(1)).thenReturn(inventoryList);
        String result = mainResource.FetchAllByLocation(1);
        String expectedJson = new Gson().toJson(inventoryList);
        assertEquals(expectedJson, result);
    }

    @Test
    public void TestFetchAllByCategoryAndLocation() {
        ArrayList<Inventory> inventoryList = new ArrayList<>();
        Inventory inventory = new Inventory();
        inventory.setID(1);
        inventory.setItemName("Test Item");
        inventory.setItemQuantity(10);
        inventoryList.add(inventory);
        when(inventoryServices.FetchAllByLocationAndCategory(1, 1)).thenReturn(inventoryList);
        String result = mainResource.FetchAllByCategoryAndLocation(1, 1);
        String expectedJson = new Gson().toJson(inventoryList);
        assertEquals(expectedJson, result);
    }

    @Test
    public void TestUpdateInventory() {
        Inventory inventory = new Inventory();
        inventory.setID(1);
        inventory.setItemName("Test Item");
        inventory.setItemQuantity(10);
        String inventoryDomainString = new Gson().toJson(inventory);
        when(inventoryServices.UpdateExistingInventoryItemByID(inventory)).thenReturn(true);
        String result = mainResource.UpdateInventory(1, inventoryDomainString);
        assertEquals("Error in Updating", result);
    }

    @Test
    public void TestDeleteInventory(){
        when(inventoryServices.DeleteExistingInventoryItemById(1)).thenReturn(true);
        String result = mainResource.DeleteInventory(1);
        assertEquals("Deleted", result);
    }

//    @Test
//    public void testFetchById_Exception() {
//        // Create a mock for InventoryServices
//        InventoryServices inventoryServices = mock(InventoryServices.class);
//
//        // Inject the mock into the mainResource object
//        MainResource mainResource = new MainResource();
//        mainResource.InventoryServices = inventoryServices;
//
//        int invalidId = 100;
//
//        // Set up the mock behavior to throw NotFoundException
//        when(inventoryServices.FetchByID(invalidId)).thenThrow(new NotFoundException("Inventory not found"));
//
//        // Execute the Fetchid method and expect the NotFoundException to be thrown
//        assertThrows(NotFoundException.class, () -> mainResource.Fetchid(invalidId));
//    }

}
