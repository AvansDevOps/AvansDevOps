package SprintRelease;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project.Sprint;
import sprintRelease.Command;
import sprintRelease.Folder;
import sprintRelease.SprintRelease;
import sprintRelease.VisitorStartDeployment;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SprintReleaseTest {

    ByteArrayOutputStream outContent;

    private void createComponentVisitor(SprintRelease sprint){

        // Composite pattern > folder structure
        Folder mainFolder = new Folder("Deployment folder");

        Folder testFolder = new Folder("Test folder");
        Command runningUnitTests = new Command("Running unit tests", "This will run all unit tests inside AvansOps", "run tests.exe");
        testFolder.addComponent(runningUnitTests);

        Folder buildFolder = new Folder("Build folder");
        Command buildProject = new Command("Building project", "This will build the project", "build project.exe");
        buildFolder.addComponent(buildProject);

        Folder packagesFolder = new Folder("Packages folder");
        Folder libraryMail = new Folder("Library mail");
        Command sendMail = new Command("EmailLibrary", "This will send a mail", "send mail.exe");
        libraryMail.addComponent(sendMail);
        packagesFolder.addComponent(libraryMail);

        Folder librarySMS = new Folder("Library SMS");
        Command sendSMS = new Command("SMSLibrary", "This will send a SMS", "send SMS.exe");
        librarySMS.addComponent(sendSMS);
        packagesFolder.addComponent(librarySMS);

        mainFolder.addComponent(testFolder);
        mainFolder.addComponent(buildFolder);
        mainFolder.addComponent(packagesFolder);

        // visitor pattern
        VisitorStartDeployment visitor = new VisitorStartDeployment();

        //creating a base component for the composite pattern
        sprint.addComponent(mainFolder);
        sprint.addVisitor(visitor);
    }

    @BeforeEach
    void init(){
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testDeployProject(){
        // Arrange
        SprintRelease sprint = new SprintRelease("Sprint A", LocalDate.now(), LocalDate.now());
        createComponentVisitor(sprint);
        // Act
        sprint.deployProject();
        // Assert
        String expectedOutput = "Project pipeline is in progress and will be deployed soon:\n" +
                "Starting: Command{name='Running unit tests', command='run tests.exe', status='Finished'}\n" +
                "Starting: Command{name='Building project', command='build project.exe', status='Finished'}\n" +
                "Starting: Command{name='EmailLibrary', command='send mail.exe', status='Finished'}\n" +
                "Starting: Command{name='SMSLibrary', command='send SMS.exe', status='Finished'}\n" +
                "Project has been deployed successfully!\n \n\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testDeployNoComponent(){
        // Arrange
        SprintRelease sprint = new SprintRelease("Sprint A", LocalDate.now(), LocalDate.now());
        // Act
        sprint.deployProject();
        // Assert
        String expectedOutput = "Error: No component has been added to the project\n \n\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
