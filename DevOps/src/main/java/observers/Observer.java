package observers;

import backlogItemState.BacklogItem;
import users.User;

import java.util.List;

public interface Observer {
    public void sendNotification(BacklogItem backlogItem, String message);
}
