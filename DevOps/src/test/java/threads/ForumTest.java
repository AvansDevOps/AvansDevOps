package threads;

import org.junit.jupiter.api.Test;
import project.Sprint;
import project.SprintReview;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ForumTest {

    @Test
    public void testConstructor(){
        // Arrange
        Sprint sprint = new SprintReview("Sprint A", LocalDate.now(), LocalDate.now());
        // Act
        Forum forum = new Forum(sprint);
        // Assert
        assertNotNull(forum);
    }
}
