package notification;

import users.User;

public class SlackNotificationAdapter implements NotificationBehaviour {
    private String name;
    private String message;
    private User receiver;
    private String email;


    @Override
    public void sendNotification(User receiver, String message) {
        transformData(receiver, message);
        sendSlack();
    }

    private void transformData(User receiver, String message) {
        this.name = receiver.getName();
        this.message = message;
        this.receiver = receiver;
        this.email = receiver.getEmail();
    }

    private void sendSlack() {
        // method to third party service
        System.out.println("Sending Slack notification to " + this.name + " with email " + this.email + " with message: " + this.message);
    }
}
