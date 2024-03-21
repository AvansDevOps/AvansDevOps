package observers;

import backlogItemState.BacklogItem;
import notification.EmailNotificationBehaviourAdapter;
import notification.NotificationBehaviour;
import notification.SMSNotificationBehaviourAdapter;

public class Subscriber implements Observer {
    @Override
    public void sendNotification(BacklogItem backlogItem) {
        NotificationBehaviour emailNotification = new EmailNotificationBehaviourAdapter();
        emailNotification.sendNotification("This is an email notification");

        NotificationBehaviour smsNotification = new SMSNotificationBehaviourAdapter();
        smsNotification.sendNotification("This is an sms notification");
    }




}
