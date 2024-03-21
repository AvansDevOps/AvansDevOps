package project;

import threads.Thread;
import users.User;

import java.util.List;

public class BacklogItem {
    private List<Thread> thread;
    private List<Activity> activities;
    private String title;
    private String description;
    private User user;

    public BacklogItem(String title, String description) {
        this.title = title;
        this.description = description;
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

    // set states of the backlog item
    public void ToDo() {
        // set state to "To Do"
        
    }
}
