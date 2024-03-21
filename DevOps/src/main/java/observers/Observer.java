package observers;

import backlogItemState.BacklogItem;

public interface Observer {
    public void sendNotification(BacklogItem backlogItem);
}
