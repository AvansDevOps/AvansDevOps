package backlogItemState;

import org.junit.jupiter.api.Test;
import project.Activity;
import project.Sprint;
import project.SprintReview;
import sprintRelease.SprintRelease;
import threads.Thread;

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

    @Test
    public void testChangeBacklogStateReleaseSprint(){
        // Arrange
        Sprint sprint = new SprintRelease("Sprint A", LocalDate.now(), LocalDate.now());
        BacklogItem backlogItem = new BacklogItem("Title A", "Description A", sprint);
        // Act
        backlogItem.setState(new Doing());
        // Assert
        assertInstanceOf(Doing.class, backlogItem.getCurrentState());
    }

    @Test
    public void testChangeBacklogStateFinishedSprint(){
        // Arrange
        Sprint sprint = new SprintReview("Sprint A", LocalDate.now(), LocalDate.now());
        BacklogItem backlogItem = new BacklogItem("Title A", "Description A", sprint);
        // Act
        sprint.setSprintStatus(true);
        backlogItem.setState(new Doing());
        // Assert
        assertInstanceOf(ToDo.class, backlogItem.getCurrentState());
    }

    @Test
    public void testAddThread(){
        // Arrange
        Sprint sprint = new SprintReview("Sprint A", LocalDate.now(), LocalDate.now());
        BacklogItem backlogItem = new BacklogItem("Title A", "Description A", sprint);
        Thread thread = new Thread("Title A", "Description A");
        // Act
        backlogItem.addThread(thread);
        // Assert
        assertEquals(1, backlogItem.getThreads().size());
    }

    @Test
    public void testAddActivity(){
        // Arrange
        Sprint sprint = new SprintReview("Sprint A", LocalDate.now(), LocalDate.now());
        BacklogItem backlogItem = new BacklogItem("Title A", "Description A", sprint);
        Activity activity = new Activity("Activity A", "Description A");
        // Act
        backlogItem.addActivity(activity);
        // Assert
        assertEquals(1, backlogItem.getActivities().size());
    }
}
