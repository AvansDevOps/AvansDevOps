package notification;

public class EmailNotificationBehaviourAdapter implements NotificationBehaviour {
    @Override
    public void sendNotification(String message) {
        System.out.println("Email notification sent: " + message);
    }
}
