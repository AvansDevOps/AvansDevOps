package observers;

import backlogItemState.*;
import notification.EmailNotificationBehaviourAdapter;
import notification.NotificationBehaviour;
import notification.SMSNotificationBehaviourAdapter;
import users.Developer;
import users.ScrumMaster;
import users.Tester;
import users.User;

import java.util.List;

public class Subscriber implements Observer {

    private final NotificationBehaviour notificationBehaviour;// strategy pattern, email/slack/sms notification

    public Subscriber(NotificationBehaviour notificationBehaviour){
        this.notificationBehaviour = notificationBehaviour;
    }
    @Override
    public void sendNotification(BacklogItem backlogItem) {
        notificationReadyForTesting(backlogItem);
        notificationBackToToDo(backlogItem);
        notificationReadyForTestingToDoing(backlogItem);
    }

    private void notificationReadyForTestingToDoing(BacklogItem backlogItem) {
        if (backlogItem.getBacklogItemPreviousState() instanceof ReadyForTesting && backlogItem.getCurrentState() instanceof Doing) {
            filterUsers(backlogItem, ScrumMaster.class
                    , "Hello Scrum Master! A Tester placed the backlog item: "
                            + backlogItem.getTitle()
                            + ". Please check it.");
        }
    }

    private void notificationReadyForTesting(BacklogItem backlogItem) {
        if (backlogItem.getCurrentState() instanceof ReadyForTesting) {
            filterUsers(backlogItem, Tester.class , "Hello tester! Backlog item is ready for testing");
        }
    }

    private void notificationBackToToDo(BacklogItem backlogItem) {
        if (backlogItem.getCurrentState() instanceof ToDo) {
            filterUsers(backlogItem, Developer.class, "Hello developer! Backlog item is back to ToDo because of a failed test. Please fix it.");
        }
    }

    private void filterUsers( BacklogItem backlogItem, Class<?> userClass , String message) {
        // filter users
        for (User user: backlogItem.getSprint().getTeamMembers()) {
            if (userClass.isInstance(user)) {
                notificationBehaviour.sendNotification(user, message);
            }
        }
    }
}
