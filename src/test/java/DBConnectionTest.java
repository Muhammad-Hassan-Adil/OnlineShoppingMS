import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import java.sql.*;

import org.mockito.Mock;
import services.DBConnectionService;
import static org.junit.jupiter.api.Assertions.*;
public class DBConnectionTest {
    private Connection connection;

    @BeforeEach
    public void setUp() throws ClassNotFoundException {
        connection = DBConnectionService.getConnection();
    }

    @AfterEach
    public void tearDown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void testConnectionIsNotNull() {
        assertNotNull(connection);
    }

    @Test
    public void testConnectionIsValid() throws SQLException {
        assertTrue(connection.isValid(5));
    }
}
