package notification;

import users.User;

public class Notification {
    private String title;
    private String message;
    private User receiver;

    public Notification(String title, String message, User user) {
        this.title = title;
        this.message = message;
        this.receiver = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", user=" + receiver +
                '}';
    }
}
