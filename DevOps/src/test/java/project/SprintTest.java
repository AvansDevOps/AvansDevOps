package project;

import org.junit.jupiter.api.Test;
import sprintRelease.SprintRelease;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testCreateSprintWrongDate() throws InterruptedException {
        // Arrange
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // Act
        Sprint sprint = new SprintRelease("Sprint A", LocalDate.now().minusDays(1), LocalDate.now().minusDays(1));
        // Assert
        String expectedOutput = "The deadline has passed!";
        Thread.sleep(1);
        assertTrue(outContent.toString().contains(expectedOutput));
    }

}
