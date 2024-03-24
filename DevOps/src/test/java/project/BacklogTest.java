package project;

import backlogItemState.BacklogItem;
import backlogItemState.ToDo;
import org.junit.jupiter.api.Test;
import sprintRelease.SprintRelease;
import users.Developer;
import users.User;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BacklogTest {

    @Test
    public void testGetBacklogItems(){
        // Arrange
        SprintRelease sprint = new SprintRelease("Sprint 1", LocalDate.now(), LocalDate.now());
        BacklogItem item1 = new BacklogItem("Title1", "Description1", sprint);
        BacklogItem item2 = new BacklogItem("Title2", "Description2", sprint);
        Backlog backlog = new Backlog();
        backlog.addBacklogItem(item2);
        backlog.addBacklogItem(item1);
        // Act
        List<BacklogItem> result = backlog.getBacklogItems();
        // Assert
        assertEquals(2, result.size());
        assertEquals("Title1", result.get(0).getTitle());
    }

    @Test
    public void testCreateBacklogItem(){
        // Arrange
        Sprint sprint = new SprintReview("Title A", LocalDate.now(), LocalDate.now());
        // Act
        BacklogItem backlogItem = new BacklogItem("Title A", "Description A", sprint);
        // Assert
        assertNotNull(backlogItem);
        assertEquals("Title A", backlogItem.getTitle());
        assertEquals(sprint, backlogItem.getSprint());
        assertInstanceOf(ToDo.class, backlogItem.getCurrentState());
    }

    @Test
    public void testAddUserToBacklogItem(){
        // Arrange
        Sprint sprint = new SprintReview("Title A", LocalDate.now(), LocalDate.now());
        BacklogItem backlogItem = new BacklogItem("Title A", "Description A", sprint);
        User user = new Developer("John", "john@example.com");
        // Act
        backlogItem.setUser(user);
        // Assert
        assertNotNull(backlogItem);
    }
}
