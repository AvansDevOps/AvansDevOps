package project;

import backlogItemState.BacklogItemState;
import backlogItemState.ToDo;
import threads.Thread;
import users.User;

import java.util.List;

public class BacklogItem {
    private List<Thread> thread;
    private List<Activity> activities;
    private String title;
    private String description;
    private User user;
    private BacklogItemState state;

    public BacklogItem(String title, String description) {
        this.title = title;
        this.description = description;
        state = new ToDo();
        

    }

    public void addThread(Thread thread) {
        this.thread.add(thread);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public void getCurrentState() {
        state.getCurrentState();
    }

    // set states of the backlog item

    public void setState(BacklogItemState state) {
        this.state = state;
    }


}
