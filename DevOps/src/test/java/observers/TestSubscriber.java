package observers;

import backlogItemState.BacklogItem;
import backlogItemState.ReadyForTesting;
import notification.SMSNotificationBehaviourAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.Sprint;
import project.SprintReview;
import users.Developer;
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
}
