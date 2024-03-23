package notification;

import users.User;

public class SMSNotificationBehaviourAdapter implements NotificationBehaviour {
    private String name;
    private String message;
    private User receiver;
    private String email;


    @Override
    public void sendNotification(User receiver, String message) {
        transformData(receiver, message);
        sendSMS();
    }

    private void transformData(User receiver, String message) {
        this.name = receiver.getName();
        this.message = message + " from SMSNotificationBehaviourAdapter Unique Message!! whaow";
        this.receiver = receiver;
        this.email = receiver.getEmail();
    }

    private void sendSMS() {
        // method to third party service
        System.out.println("Sending SMS notification to " + this.name + " with email " + this.email + " with message: " + this.message);
    }
}
