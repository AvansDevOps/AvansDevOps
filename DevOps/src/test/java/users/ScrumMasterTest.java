package users;

import org.junit.jupiter.api.Test;
import project.Project;
import project.Sprint;
import project.SprintReview;
import reports.FileType;
import sprintRelease.SprintRelease;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

    @Test
    public void testGenerateReportPNG() {
        // Arrange
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        generateReport(FileType.PNG);
        // Assert
        String expectedOutput = "Report is being generated\n" +
                "Exporting report as PNG\n" +
                "Report: reportName='Sprint 1 report'\n" +
                "version=1.0\n" +
                "date=2024-03-24\n" +
                "sprint=Sprint{name='Sprint A', startDate=2024-03-24, endDate=2024-03-24, teamMembers=[]}";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testGenerateReportPDF() {
        // Arrange
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        generateReport(FileType.PDF);
        // Assert
        String expectedOutput = "Report is being generated\n" +
                "Exporting report as PDF \n" +
                "PDFExportReport{\n" +
                "Report: reportName='Sprint 1 report'\n" +
                "version=1.0\n" +
                "date=2024-03-24\n" +
                "sprint=Sprint{name='Sprint A', startDate=2024-03-24, endDate=2024-03-24, teamMembers=[]}\n";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    private void generateReport(FileType type){
        // Arrange
        ScrumMaster scrumMaster = new ScrumMaster("John", "john@example.com");
        Sprint sprint = new SprintReview("Sprint A", LocalDate.now(), LocalDate.now());
        // Act
        scrumMaster.generateReport(type, "Sprint 1 report", LocalDate.now(), sprint);
    }
}
