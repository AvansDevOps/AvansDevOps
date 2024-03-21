package notification;

import users.User;

public class SlackNotificationAdapter implements NotificationBehaviour {


    @Override
    public void sendNotification(User receiver, String message) {
        System.out.println("Slack notification sent to " + receiver.getName() + ": " + message);
    }
}
