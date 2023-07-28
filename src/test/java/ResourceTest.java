import com.google.gson.Gson;
import domain.InventoryDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resources.Resource;
import services.InventoryServices;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ResourceTest {

    private InventoryServices inventoryServices;
    private Resource resource;

    @BeforeEach
    public void setUp() throws ClassNotFoundException {
        inventoryServices = mock(InventoryServices.class);
        resource = new Resource();
        resource.InventoryServices = inventoryServices;
    }

    @Test
    public void testFetchById() {
        int inventoryId = 1;
        InventoryDomain inventoryDomain = new InventoryDomain();
        inventoryDomain.setID(inventoryId);
        when(inventoryServices.FetchByID(inventoryId)).thenReturn(inventoryDomain);
        String result = resource.Fetchid(inventoryId);
        assertEquals(new Gson().toJson(inventoryDomain), result);
    }

    @Test
    public void testFetchAllInventory() {
        ArrayList<InventoryDomain> inventoryDomainList = new ArrayList<>();
        InventoryDomain inventoryDomain = new InventoryDomain();
        inventoryDomain.setID(1);
        inventoryDomain.setItemName("Test Item");
        inventoryDomain.setItemQuantity(10);
        inventoryDomainList.add(inventoryDomain);
        when(inventoryServices.FetchAll()).thenReturn(inventoryDomainList);
        String result = resource.FetchAllInventory();
        String expectedJson = new Gson().toJson(inventoryDomainList);
        assertEquals(expectedJson, result);
    }

    @Test
    public void TestFetchAllByCategory() throws ClassNotFoundException {
        ArrayList<InventoryDomain> inventoryDomainList = new ArrayList<>();
        InventoryDomain inventoryDomain = new InventoryDomain();
        inventoryDomain.setID(1);
        inventoryDomain.setItemName("Test Item");
        inventoryDomain.setItemQuantity(10);
        inventoryDomainList.add(inventoryDomain);
        when(inventoryServices.FetchAllByCategory(1)).thenReturn(inventoryDomainList);
        String result = resource.FetchAllByCategory(1);
        String expectedJson = new Gson().toJson(inventoryDomainList);
        assertEquals(expectedJson, result);
    }

    @Test
    public void TestFetchAllByLocation() throws ClassNotFoundException {
        ArrayList<InventoryDomain> inventoryDomainList = new ArrayList<>();
        InventoryDomain inventoryDomain = new InventoryDomain();
        inventoryDomain.setID(1);
        inventoryDomain.setItemName("Test Item");
        inventoryDomain.setItemQuantity(10);
        inventoryDomainList.add(inventoryDomain);
        when(inventoryServices.FetchAllByLocation(1)).thenReturn(inventoryDomainList);
        String result = resource.FetchAllByLocation(1);
        String expectedJson = new Gson().toJson(inventoryDomainList);
        assertEquals(expectedJson, result);
    }

    @Test
    public void TestFetchAllByCategoryAndLocation() throws ClassNotFoundException {
        ArrayList<InventoryDomain> inventoryDomainList = new ArrayList<>();
        InventoryDomain inventoryDomain = new InventoryDomain();
        inventoryDomain.setID(1);
        inventoryDomain.setItemName("Test Item");
        inventoryDomain.setItemQuantity(10);
        inventoryDomainList.add(inventoryDomain);
        when(inventoryServices.FetchAllByLocationAndCategory(1, 1)).thenReturn(inventoryDomainList);
        String result = resource.FetchAllByCategoryAndLocation(1, 1);
        String expectedJson = new Gson().toJson(inventoryDomainList);
        assertEquals(expectedJson, result);
    }

    @Test
    public void TestUpdateInventory() throws ClassNotFoundException {
        InventoryDomain inventoryDomain = new InventoryDomain();
        inventoryDomain.setID(1);
        inventoryDomain.setItemName("Test Item");
        inventoryDomain.setItemQuantity(10);
        String inventoryDomainString = new Gson().toJson(inventoryDomain);
        doNothing().when(inventoryServices).UpdateExistingInventoryItemByID(inventoryDomain);
        String result = resource.UpdateInventory(1, inventoryDomainString);
        String expectedJson = new Gson().toJson(inventoryDomain);
        assertEquals(expectedJson, result);
    }

    @Test
    public void TestDeleteInventory() {
        doNothing().when(inventoryServices).DeleteExistingInventoryItemById(1);
        String result = resource.DeleteInventory(1);
        assertEquals("Deleted", result);
    }
}
