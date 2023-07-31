package services;
import javax.ws.rs.container.*;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.Provider;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Base64;

@Provider
public class AuthService implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) {
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader == null || !authorizationHeader.startsWith("Basic ")) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .header(HttpHeaders.WWW_AUTHENTICATE, "Basic realm=\"My Realm\"")
                    .build());
            return;
        }
        String[] credentials = extractCredentials(authorizationHeader);
        if (credentials == null || !isAuthenticated(credentials[0], credentials[1])) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .header(HttpHeaders.WWW_AUTHENTICATE, "Basic realm=\"My Realm\"")
                    .build());
        }
    }
    private String[] extractCredentials(String authorizationHeader) {
        try {
            byte[] decodedBytes = Base64.getDecoder()
                    .decode(authorizationHeader.substring("Basic ".length()).trim());
            String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
            return decodedString.split(":", 2);
        } catch (Exception e) {
            return null;
        }
    }
    private boolean isAuthenticated(String username, String password) {
        try {
            Connection connection = DBConnectionService.getConnection();
            System.out.println("Connected");
            // Prepare the SQL statement to query the users table
            String sql = "SELECT COUNT(*) FROM Users WHERE username = ? AND password = ?";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}