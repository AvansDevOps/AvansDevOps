package observers;

import backlogItemState.*;
import notification.EmailNotificationBehaviourAdapter;
import notification.SMSNotificationBehaviourAdapter;
import notification.SlackNotificationAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.Sprint;
import project.SprintReview;
import users.Developer;
import users.ScrumMaster;
import users.Tester;
import users.User;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSubscriber {

    ByteArrayOutputStream outContent;

    @BeforeEach
    void init(){
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testNotificationReadyForTesting() {
        // Arrange
        Subscriber observer = new Subscriber(new SMSNotificationBehaviourAdapter());
        Sprint sprint = new SprintReview("Sprint A", LocalDate.now(), LocalDate.now());
        User user = new Tester("John", "john@example.com");
        sprint.inviteTeamMembers(user);
        BacklogItem backlogItem = new BacklogItem("Title A", "Description A", sprint);
        backlogItem.subscribe(observer);
        // Act
        backlogItem.setState(new ReadyForTesting());
        // Assert
        String expectedOutput = "Sending SMS notification to John with email john@example.com with message: Hello tester! Backlog item is ready for testing from SMSNotificationBehaviourAdapter Unique Message!! whaow";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testNotificationToDo() {
        // Arrange
        Subscriber observer = new Subscriber(new SlackNotificationAdapter());
        Sprint sprint = new SprintReview("Sprint A", LocalDate.now(), LocalDate.now());
        User user = new Developer("John", "john@example.com");
        sprint.inviteTeamMembers(user);
        BacklogItem backlogItem = new BacklogItem("Title A", "Description A", sprint);
        backlogItem.subscribe(observer);
        // Act
        backlogItem.setState(new ToDo());
        // Assert
        String expectedOutput = "Sending Slack notification to John with email john@example.com with message: Hello developer! Backlog item is back to ToDo because of a failed test. Please fix it.";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testNotificationReadyForTestingToDoing() {
        // Arrange
        Subscriber observer = new Subscriber(new EmailNotificationBehaviourAdapter());
        Sprint sprint = new SprintReview("Sprint A", LocalDate.now(), LocalDate.now());
        User user = new ScrumMaster("John", "john@example.com");
        sprint.inviteTeamMembers(user);
        BacklogItem backlogItem = new BacklogItem("Title A", "Description A", sprint);
        backlogItem.subscribe(observer);
        // Act
        backlogItem.setState(new ReadyForTesting());
        backlogItem.setState(new Doing());
        // Assert
        String expectedOutput = "Email notification sent to John: Hello Scrum Master! A Tester placed the backlog item: Title A. Please check it.";
        assertTrue(outContent.toString().contains(expectedOutput));
    }
}
