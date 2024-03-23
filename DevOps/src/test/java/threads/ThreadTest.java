package threads;

import org.junit.jupiter.api.Test;
import users.Developer;
import users.User;

import static org.junit.jupiter.api.Assertions.*;

public class ThreadTest {

    @Test
    public void testConstructor(){
        // Arrange
        String title = "Thread A";
        String content = "Content A";

        // Act
        Thread thread = new Thread(title, content);

        // Assert
        assertNotNull(thread);
    }

    @Test
    public void testAddComment(){
        // Arrange
        Thread thread = new Thread("Thread A", "Content A");
        User user = new Developer("John", "john@example.com");
        String commentText = "Comment A";
        Comment comment = new Comment(commentText, user);

        // Act
        thread.addComment(comment);

        // Assert
        assertTrue(thread.toString().contains(comment.toString()));
    }

    @Test
    public void testRemoveComment(){
        // Arrange
        Thread thread = new Thread("Thread A", "Content A");
        User user = new Developer("John", "john@example.com");
        String commentText = "Comment A";
        Comment comment = new Comment(commentText, user);
        thread.addComment(comment);

        // Act
        thread.removeComment(comment);

        // Assert
        assertFalse(thread.toString().contains(comment.toString()));
    }
    
}
