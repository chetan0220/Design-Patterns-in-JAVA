// Strategy Interface for Authentication
interface AuthStrategy {
    void authenticate(String username, String password);
}

class GoogleAuthStrategy implements AuthStrategy {
    @Override
    public void authenticate(String username, String password) {
        // Simulate Google login (OAuth 2.0 flow)
        System.out.println("Authenticating using Google...");
        // You can simulate Google OAuth process here
        System.out.println("User " + username + " authenticated via Google.");
    }
}

class EmailAuthStrategy implements AuthStrategy {
    @Override
    public void authenticate(String username, String password) {
        // Simulate email-based login (check credentials)
        System.out.println("Authenticating using Email...");
        // Simulate email authentication (username and password validation)
        if (username.equals("user@example.com") && password.equals("password123")) {
            System.out.println("User " + username + " authenticated via Email.");
        } else {
            System.out.println("Invalid email or password.");
        }
    }
}

class AuthSystem {
    private AuthStrategy authStrategy;

    // Set the authentication strategy at runtime
    public void setAuthStrategy(AuthStrategy authStrategy) {
        this.authStrategy = authStrategy;
    }

    // Authenticate user using the current strategy
    public void authenticateUser(String username, String password) {
        if (authStrategy == null) {
            System.out.println("No authentication strategy set.");
            return;
        }
        authStrategy.authenticate(username, password);
    }
}

public class Main {
    public static void main(String[] args) {
        AuthSystem authSystem = new AuthSystem();

        // Simulate Google login
        authSystem.setAuthStrategy(new GoogleAuthStrategy());
        authSystem.authenticateUser("user@example.com", "password123");

        // Simulate Email login
        // authSystem.setAuthStrategy(new EmailAuthStrategy());
        // authSystem.authenticateUser("user@example.com", "password123");
    }
}
