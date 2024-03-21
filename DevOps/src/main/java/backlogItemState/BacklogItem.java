package backlogItemState;

import backlogItemState.BacklogItemState;
import backlogItemState.ToDo;
import observers.Observable;
import observers.Observer;
import project.Activity;
import project.Sprint;
import threads.Thread;
import users.User;

import java.util.ArrayList;
import java.util.List;

public class BacklogItem implements Observable {
    private List<Thread> thread;
    private List<Activity> activities;
    private List<Observer> observers = new ArrayList<>();
    private String title;
    private String description;
    private User user;
    private BacklogItemState state;

    public Sprint getSprint() {
        return sprint;
    }

    private Sprint sprint;


    public BacklogItem(String title, String description, Sprint sprint) {
        this.title = title;
        this.description = description;
        this.sprint = sprint;
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
        notifyObservers();
    }

    // observables methods
    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        // todo; send notification based on the state to the correct team members
        if (state instanceof Done){
            for (Observer observer : observers) {
                observer.sendNotification(this, "Backlog item has finished!");
            }
        }

    }
}