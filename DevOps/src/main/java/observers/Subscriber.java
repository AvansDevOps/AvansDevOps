package observers;

import backlogItemState.BacklogItem;
import notification.EmailNotificationBehaviourAdapter;
import notification.NotificationBehaviour;
import notification.SMSNotificationBehaviourAdapter;
import users.User;

import java.util.List;

public class Subscriber implements Observer {

    @Override
    public void sendNotification(BacklogItem backlogItem, String message) {
        NotificationBehaviour smsNotification = new SMSNotificationBehaviourAdapter();
        for (User user : getUsers(backlogItem)) {
            smsNotification.sendNotification(user, message);
        }
    }

    private List<User> getUsers(BacklogItem backlogItem) {
        return backlogItem.getSprint().getTeamMembers();
    }

}
