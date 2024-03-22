package observers;

import backlogItemState.BacklogItem;
import project.Sprint;
import users.User;

import java.util.List;

public interface Observer {
    public void sendNotification(BacklogItem backlogItem);
    public void sendNotification();
    public void sprintCancelledNotification(Sprint sprint);

}
