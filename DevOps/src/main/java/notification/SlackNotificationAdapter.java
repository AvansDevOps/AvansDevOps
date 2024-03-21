package notification;

public class SlackNotificationAdapter implements NotificationBehaviour {
    @Override
    public void sendNotification(String message) {
        System.out.println("Slack notification sent: " + message);

    }



}
