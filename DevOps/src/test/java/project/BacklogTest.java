package project;

import backlogItemState.BacklogItem;
import org.junit.jupiter.api.Test;
import sprintRelease.SprintRelease;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
