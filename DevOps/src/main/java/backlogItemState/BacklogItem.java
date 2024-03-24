package backlogItemState;

import observers.Observable;
import observers.Observer;
import project.Activity;
import project.Sprint;
import sprintRelease.SprintRelease;
import threads.Thread;
import users.User;

import java.util.ArrayList;
import java.util.List;

public class BacklogItem implements Observable, Comparable<BacklogItem> {
    private List<Thread> thread;
    private List<Activity> activities;
    private List<Observer> observers = new ArrayList<>();
    private String title;
    private String description;
    private User user;
    private BacklogItemState state;
    private BacklogItemState BacklogItemPreviousState;
    private Sprint sprint;

    public BacklogItem(String title, String description, Sprint sprint) {
        this.title = title;
        this.description = description;
        this.sprint = sprint;
        this.activities = new ArrayList<>();
        state = new ToDo();
        this.thread = new ArrayList<>();
    }

    public Sprint getSprint() {
        return sprint;
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

    public BacklogItemState getCurrentState() {
        return state.getCurrentState();
    }

    // set states of the backlog item

    public void setState(BacklogItemState newState) {
        if (sprint.isFinished()) {
            System.out.println("Sprint is finished, you can't change the state of the backlog item");
            return;
        }
        if (sprint instanceof SprintRelease) {
            SprintRelease sprintRelease = (SprintRelease) sprint;
            if (sprintRelease.threadIsRunning()) {
                System.out.println("Deployment is in progress, please wait until it is finished");
                return;
            }
        }

        this.BacklogItemPreviousState = this.state;
        this.state = newState;
        notifyObservers();
    }

    // observables methods
    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public BacklogItemState getBacklogItemPreviousState() {
        return BacklogItemPreviousState;
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        // todo; send notification based on the state to the correct team members
        for (Observer observer : observers) {
            observer.sendNotification(this);
        }
    }

    public String getTitle() {
        return title;
    }

    public List<Thread> getThreads() {
        return thread;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    @Override
    public int compareTo(BacklogItem other) {
        return this.title.compareTo(other.title);
    }
}
