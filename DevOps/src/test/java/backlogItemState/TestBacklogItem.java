package backlogItemState;

import org.junit.jupiter.api.Test;
import project.Sprint;
import project.SprintReview;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class TestBacklogItem {

    @Test
    public void testChangeBacklogState(){
        // Arrange
        Sprint sprint = new SprintReview("Sprint A", LocalDate.now(), LocalDate.now());
        BacklogItem backlogItem = new BacklogItem("Title A", "Description A", sprint);
        // Act
        backlogItem.setState(new Doing());
        // Assert
        assertInstanceOf(Doing.class, backlogItem.getCurrentState());
    }
}
