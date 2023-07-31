import domain.*;
import org.junit.jupiter.api.*;
import java.sql.*;
import org.mockito.*;
import services.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;

public class InventoryServicesTest {
    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    @Mock
    private InventoryServices inventoryServices;

    @Mock
    private ItemCategory itemCategory;

    @Mock
    private ItemLocation itemLocation;

    @BeforeEach
    public void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        inventoryServices = new InventoryServices(mockConnection);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
    }

    @Test
    public void testFetchByID() throws SQLException {
        int id = 1;
        String itemName = "Sample Item";
        int itemQuantity = 10;
        String categoryName = "Sample Category";
        String locationName = "Sample Location";
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt("ID")).thenReturn(id);
        when(mockResultSet.getString("Name")).thenReturn(itemName);
        when(mockResultSet.getInt("Quantity")).thenReturn(itemQuantity);
        when(mockResultSet.getInt("Category_ID")).thenReturn(1);
        when(mockResultSet.getString("Category_Name")).thenReturn(categoryName);
        when(mockResultSet.getInt("Location_ID")).thenReturn(1);
        when(mockResultSet.getString("Location_Name")).thenReturn(locationName);
        Inventory inventoryDomain = inventoryServices.FetchByID(id);
        verify(mockPreparedStatement, times(1)).setInt(1, id);
        verify(mockPreparedStatement, times(1)).executeQuery();
        assertEquals(id, inventoryDomain.getID());
        assertEquals(itemName, inventoryDomain.getItemName());
        assertEquals(itemQuantity, inventoryDomain.getItemQuantity());
        assertEquals(categoryName, inventoryDomain.getItemCategory().getCategoryName());
        assertEquals(locationName, inventoryDomain.getItemLocation().getLocationName());
    }

    @Test
    public void testFetchAll() throws SQLException {
        int id = 1;
        String itemName = "Sample Item";
        int itemQuantity = 10;
        String categoryName = "Sample Category";
        String locationName = "Sample Location";
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getInt("ID")).thenReturn(id);
        when(mockResultSet.getString("Name")).thenReturn(itemName);
        when(mockResultSet.getInt("Quantity")).thenReturn(itemQuantity);
        when(mockResultSet.getInt("Category_ID")).thenReturn(1);
        when(mockResultSet.getString("Category_Name")).thenReturn(categoryName);
        when(mockResultSet.getInt("Location_ID")).thenReturn(1);
        when(mockResultSet.getString("Location_Name")).thenReturn(locationName);
        List<Inventory> inventoryDomainList = inventoryServices.FetchAll();
        verify(mockPreparedStatement, times(1)).executeQuery();
        assertEquals(id, inventoryDomainList.get(0).getID());
        assertEquals(itemName, inventoryDomainList.get(0).getItemName());
        assertEquals(itemQuantity, inventoryDomainList.get(0).getItemQuantity());
        assertEquals(categoryName, inventoryDomainList.get(0).getItemCategory().getCategoryName());
        assertEquals(locationName, inventoryDomainList.get(0).getItemLocation().getLocationName());
    }

    @Test
    public void testFetchAllByCategory() throws SQLException {
        int id = 1;
        String itemName = "Sample Item";
        int itemQuantity = 10;
        String categoryName = "Sample Category";
        String locationName = "Sample Location";
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getInt("ID")).thenReturn(id);
        when(mockResultSet.getString("Name")).thenReturn(itemName);
        when(mockResultSet.getInt("Quantity")).thenReturn(itemQuantity);
        when(mockResultSet.getInt("Category_ID")).thenReturn(1);
        when(mockResultSet.getString("Category_Name")).thenReturn(categoryName);
        when(mockResultSet.getInt("Location_ID")).thenReturn(1);
        when(mockResultSet.getString("Location_Name")).thenReturn(locationName);
        List<Inventory> inventoryDomainList = inventoryServices.FetchAllByCategory(1);
        verify(mockPreparedStatement, times(1)).setInt(1, 1);
        verify(mockPreparedStatement, times(1)).executeQuery();
        assertEquals(id, inventoryDomainList.get(0).getID());
        assertEquals(itemName, inventoryDomainList.get(0).getItemName());
        assertEquals(itemQuantity, inventoryDomainList.get(0).getItemQuantity());
        assertEquals(categoryName, inventoryDomainList.get(0).getItemCategory().getCategoryName());
        assertEquals(locationName, inventoryDomainList.get(0).getItemLocation().getLocationName());
    }

    @Test
    public void testFetchAllByLocation() throws SQLException {
        int id = 1;
        String itemName = "Sample Item";
        int itemQuantity = 10;
        String categoryName = "Sample Category";
        String locationName = "Sample Location";
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getInt("ID")).thenReturn(id);
        when(mockResultSet.getString("Name")).thenReturn(itemName);
        when(mockResultSet.getInt("Quantity")).thenReturn(itemQuantity);
        when(mockResultSet.getInt("Category_ID")).thenReturn(1);
        when(mockResultSet.getString("Category_Name")).thenReturn(categoryName);
        when(mockResultSet.getInt("Location_ID")).thenReturn(1);
        when(mockResultSet.getString("Location_Name")).thenReturn(locationName);
        List<Inventory> inventoryDomainList = inventoryServices.FetchAllByLocation(1);
        verify(mockPreparedStatement, times(1)).setInt(1, 1);
        verify(mockPreparedStatement, times(1)).executeQuery();
        assertEquals(id, inventoryDomainList.get(0).getID());
        assertEquals(itemName, inventoryDomainList.get(0).getItemName());
        assertEquals(itemQuantity, inventoryDomainList.get(0).getItemQuantity());
        assertEquals(categoryName, inventoryDomainList.get(0).getItemCategory().getCategoryName());
        assertEquals(locationName, inventoryDomainList.get(0).getItemLocation().getLocationName());
    }

    @Test
    public void testFetchAllByLocationAndCategory() throws SQLException {
        int id = 1;
        String itemName = "Sample Item";
        int itemQuantity = 10;
        String categoryName = "Sample Category";
        String locationName = "Sample Location";
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getInt("ID")).thenReturn(id);
        when(mockResultSet.getString("Name")).thenReturn(itemName);
        when(mockResultSet.getInt("Quantity")).thenReturn(itemQuantity);
        when(mockResultSet.getInt("Category_ID")).thenReturn(1);
        when(mockResultSet.getString("Category_Name")).thenReturn(categoryName);
        when(mockResultSet.getInt("Location_ID")).thenReturn(1);
        when(mockResultSet.getString("Location_Name")).thenReturn(locationName);
        List<Inventory> inventoryDomainList = inventoryServices.FetchAllByLocationAndCategory(1, 1);
        verify(mockPreparedStatement, times(1)).setInt(1, 1);
        verify(mockPreparedStatement, times(1)).setInt(2, 1);
        verify(mockPreparedStatement, times(1)).executeQuery();
        assertEquals(id, inventoryDomainList.get(0).getID());
        assertEquals(itemName, inventoryDomainList.get(0).getItemName());
        assertEquals(itemQuantity, inventoryDomainList.get(0).getItemQuantity());
        assertEquals(categoryName, inventoryDomainList.get(0).getItemCategory().getCategoryName());
        assertEquals(locationName, inventoryDomainList.get(0).getItemLocation().getLocationName());
    }

    @Test
    public void testAddNewInventoryItem() throws SQLException {
        int id = 1;
        String itemName = "Sample Item";
        int itemQuantity = 10;
        String categoryName = "Sample Category";
        String locationName = "Sample Location";
        itemCategory = new ItemCategory(1, categoryName);
        itemLocation = new ItemLocation(1, locationName);
        Inventory inventoryDomain = new Inventory(id, itemName, itemQuantity, itemCategory, itemLocation);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getInt("ID")).thenReturn(id);
        when(mockResultSet.getString("Name")).thenReturn(itemName);
        when(mockResultSet.getInt("Quantity")).thenReturn(itemQuantity);
        when(mockResultSet.getInt("Category_ID")).thenReturn(1);
        when(mockResultSet.getString("Category_Name")).thenReturn(categoryName);
        when(mockResultSet.getInt("Location_ID")).thenReturn(1);
        when(mockResultSet.getString("Location_Name")).thenReturn(locationName);
        inventoryServices.AddNewInventoryItem(inventoryDomain);
        verify(mockPreparedStatement, times(1)).setInt(1, id);
        verify(mockPreparedStatement, times(1)).setString(2, itemName);
        verify(mockPreparedStatement, times(1)).setInt(3, itemQuantity);
        verify(mockPreparedStatement, times(1)).setInt(4, 1);
        verify(mockPreparedStatement, times(1)).setInt(5, 1);
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }

    @Test
    public void testUpdateExistingInventoryItemByID() throws SQLException {
        int id = 1;
        String itemName = "Sample Item";
        int itemQuantity = 10;
        String categoryName = "Sample Category";
        String locationName = "Sample Location";
        itemCategory = new ItemCategory(1, categoryName);
        itemLocation = new ItemLocation(1, locationName);
        Inventory inventoryDomain = new Inventory(id, itemName, itemQuantity, itemCategory, itemLocation);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getInt("ID")).thenReturn(id);
        when(mockResultSet.getString("Name")).thenReturn(itemName);
        when(mockResultSet.getInt("Quantity")).thenReturn(itemQuantity);
        when(mockResultSet.getInt("Category_ID")).thenReturn(1);
        when(mockResultSet.getString("Category_Name")).thenReturn(categoryName);
        when(mockResultSet.getInt("Location_ID")).thenReturn(1);
        when(mockResultSet.getString("Location_Name")).thenReturn(locationName);
        inventoryServices.UpdateExistingInventoryItemByID(inventoryDomain);
        verify(mockPreparedStatement, times(1)).setString(1, itemName);
        verify(mockPreparedStatement, times(1)).setInt(2, itemQuantity);
        verify(mockPreparedStatement, times(1)).setInt(3, 1);
        verify(mockPreparedStatement, times(1)).setInt(4, 1);
        verify(mockPreparedStatement, times(1)).setInt(5, id);
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }

    @Test
    public void testDeleteExistingInventoryItemById() throws SQLException {
        int id = 1;
        inventoryServices.DeleteExistingInventoryItemById(id);
        verify(mockPreparedStatement, times(1)).setInt(1, id);
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }

}
