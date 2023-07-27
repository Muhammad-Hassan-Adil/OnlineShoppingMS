import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import domain.InventoryDomain;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mockito.MockitoAnnotations;
import services.InventoryServices;
public class InventoryServicesTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    @BeforeEach
    public void setUp() {
        try{
            MockitoAnnotations.openMocks(this);
            when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
            when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFetchByID() throws SQLException {
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt("ID")).thenReturn(1);
        when(mockResultSet.getString("Name")).thenReturn("Test Item");
        when(mockResultSet.getInt("Quantity")).thenReturn(10);
        when(mockResultSet.getInt("Category_ID")).thenReturn(2);
        when(mockResultSet.getString("Category_Name")).thenReturn("Test Category");
        when(mockResultSet.getInt("Location_ID")).thenReturn(3);
        when(mockResultSet.getString("Location_Name")).thenReturn("Test Location");
        InventoryDomain inventoryDomain = InventoryServices.FetchByID(1);
        verify(mockPreparedStatement).setInt(1, 1);
        verify(mockPreparedStatement).executeQuery();
        assertEquals(1, inventoryDomain.getID());
        assertEquals("Test Item", inventoryDomain.getItemName());
        assertEquals(10, inventoryDomain.getItemQuantity());
        assertEquals(2, inventoryDomain.getItemCategory().getID());
        assertEquals("Test Category", inventoryDomain.getItemCategory().getCategoryName());
        assertEquals(3, inventoryDomain.getItemLocation().getID());
        assertEquals("Test Location", inventoryDomain.getItemLocation().getLocationName());
    }

}
