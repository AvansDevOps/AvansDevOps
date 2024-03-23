package notification;

import users.User;

public class EmailNotificationBehaviourAdapter implements NotificationBehaviour {
    private String name;
    private String message;
    private User receiver;
    private String email;

    @Override
    public void sendNotification(User receiver, String message) {
        System.out.println("Email notification sent to " + receiver.getName() + ": " + message);
    }

    private void transformData(User receiver, String message) {
        this.name = receiver.getName();
        this.message = message;
        this.receiver = receiver;
        this.email = "RandomGenEmail@Gmail.com";
    }

    private void sendSlack() {
        // method to third party service
        System.out.println("Sending mail notification to " + this.name + " with email " + this.email + " with message: " + this.message);
    }
}
