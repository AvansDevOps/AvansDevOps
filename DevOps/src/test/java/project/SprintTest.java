package project;

import org.junit.jupiter.api.Test;
import sprintRelease.SprintRelease;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SprintTest {

    @Test
    public void testEditSprintNotStarted() {
        // Arrange
        Sprint sprint = new SprintRelease("Sprint A", LocalDate.now(), LocalDate.now());
        LocalDate newDate = LocalDate.now().plusDays(1);
        // Act
        sprint.editSprint("Sprint b", LocalDate.now(), newDate);
        // Assert
        assertEquals("Sprint b", sprint.getName());
        assertEquals(newDate, sprint.getEndDate());
    }

    @Test
    public void testEditSprintStarted(){
        // Arrange
        Sprint sprint = new SprintRelease("Sprint A", LocalDate.now().minusDays(1), LocalDate.now());
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> sprint.editSprint("Sprint b", LocalDate.now(), LocalDate.now()));
    }

}
