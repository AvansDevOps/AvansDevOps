package users;

import org.junit.jupiter.api.Test;
import project.Project;
import project.SprintReview;
import sprintRelease.SprintRelease;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScrumMasterTest {

    @Test
    public void testConstructor() {
        // Arrange
        String name = "John";
        String email = "john@example.com";

        // Act
        ScrumMaster scrumMaster = new ScrumMaster(name, email);

        // Assert
        assertNotNull(scrumMaster);
        assertEquals(name, scrumMaster.getName());
        assertEquals(email, scrumMaster.getEmail());
        assertNotNull(scrumMaster.getProjects());
        assertTrue(scrumMaster.getProjects().isEmpty());
    }
    @Test
    public void testCreateProject(){
        // Arrange
        ScrumMaster scrumMaster = new ScrumMaster("John", "john@example.com");
        String projectName = "Project A";
        String projectDescription = "This is Project A";
        Project testProject = new Project(projectName, projectDescription);

        // Act
        scrumMaster.createProject(testProject);

        // Assert
        List<Project> projects = scrumMaster.getProjects();
        assertFalse(projects.isEmpty());
        assertEquals(1, projects.size());
        Project project = projects.get(0);
        assertEquals(projectName, project.getName());
        assertEquals(projectDescription, project.getDescription());
    }

    @Test
    public void testCreateProjectWithNameAndDescription() {
        // Arrange
        ScrumMaster scrumMaster = new ScrumMaster("John", "john@example.com");
        String projectName = "Project A";
        String projectDescription = "This is Project A";

        // Act
        scrumMaster.createProject(projectName, projectDescription);

        // Assert
        List<Project> projects = scrumMaster.getProjects();
        assertFalse(projects.isEmpty());
        assertEquals(1, projects.size());
        Project project = projects.get(0);
        assertEquals(projectName, project.getName());
        assertEquals(projectDescription, project.getDescription());
    }

    @Test
    public void testCreateSprintReview() {
        // Arrange
        ScrumMaster scrumMaster = new ScrumMaster("John", "john@example.com");
        Project project = new Project("Project A", "This is Project A");
        SprintReview sprintReview = new SprintReview("Review A", LocalDate.now(), LocalDate.now());
        scrumMaster.createProject(project);
        // Act
        scrumMaster.createSprint(project, sprintReview);

        // Assert
        assertEquals(1, project.getBacklog().getSprints().size());
        assertEquals(sprintReview, project.getBacklog().getSprints().get(0));
    }

    @Test
    public void testCreateSprintRelease() {
        // Arrange
        ScrumMaster scrumMaster = new ScrumMaster("John", "john@example.com");
        Project project = new Project("Project A", "This is Project A");
        SprintRelease sprintRelease = new SprintRelease("Release A", LocalDate.now(), LocalDate.now());
        scrumMaster.createProject(project);
        // Act
        scrumMaster.createSprint(project, sprintRelease);

        // Assert
        assertEquals(1, project.getBacklog().getSprints().size());
        assertEquals(sprintRelease, project.getBacklog().getSprints().get(0));
    }
}
