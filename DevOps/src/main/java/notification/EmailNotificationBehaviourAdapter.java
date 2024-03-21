package notification;

import users.User;

public class EmailNotificationBehaviourAdapter implements NotificationBehaviour {
    @Override
    public void sendNotification(User receiver, String message) {
        System.out.println("Email notification sent to " + receiver.getName() + ": " + message);
    }
}
