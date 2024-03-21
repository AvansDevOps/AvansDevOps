package notification;

import users.User;

public interface NotificationBehaviour {
    public void sendNotification(User receiver , String message);

}
