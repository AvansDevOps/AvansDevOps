package notification;

public class SMSNotificationBehaviourAdapter implements NotificationBehaviour {
    @Override
    public void sendNotification(String message) {
        System.out.println("SMS notification sent: " + message);
    }


}
