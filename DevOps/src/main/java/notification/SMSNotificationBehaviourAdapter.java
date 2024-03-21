package notification;

import users.User;

public class SMSNotificationBehaviourAdapter implements NotificationBehaviour {

    @Override
    public void sendNotification(User receiver, String message) {
        System.out.println("SMS notification sent to " + receiver.getName() + ": " + message);
    }
}
