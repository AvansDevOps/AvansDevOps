package observers;

import backlogItemState.BacklogItem;
import backlogItemState.BacklogItemState;
import backlogItemState.ReadyForTesting;
import backlogItemState.ToDo;
import notification.EmailNotificationBehaviourAdapter;
import notification.NotificationBehaviour;
import notification.SMSNotificationBehaviourAdapter;
import users.Developer;
import users.Tester;
import users.User;

import java.util.List;

public class Subscriber implements Observer {
private NotificationBehaviour emailNotification = new EmailNotificationBehaviourAdapter();
    @Override
    public void sendNotification(BacklogItem backlogItem) {
        notificationReadyForTesting(backlogItem);
        notificationBackToToDo(backlogItem);

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
                emailNotification.sendNotification(user, message);
            }
        }
    }


}
