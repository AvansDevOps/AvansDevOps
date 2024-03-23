package users;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testConstructor() {
        // Arrange
        String name = "John";
        String email = "john@example.com";

        // Act
        User user = new UserMock(name, email);

        // Assert
        assertNotNull(user);
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
        assertNotNull(user.getSprints());
        assertTrue(user.getSprints().isEmpty());
    }

    @Test
    public void testGettersAndSetters() {
        // Arrange
        User user = new UserMock("John", "john@example.com");

        // Act & Assert
        user.setName("Jane");
        assertEquals("Jane", user.getName());

        user.setEmail("jane@example.com");
        assertEquals("jane@example.com", user.getEmail());
    }

    @Test
    public void testToString() {
        // Arrange
        User user = new UserMock("John", "john@example.com");

        // Act
        String result = user.toString();

        // Assert
        assertEquals("John: UserMock", result);
    }

    // Mock class for testing abstract User class
    private static class UserMock extends User {
        public UserMock(String name, String email) {
            super(name, email);
        }
    }
}
