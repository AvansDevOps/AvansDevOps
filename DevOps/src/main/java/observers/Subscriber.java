package observers;

import backlogItemState.*;
import notification.EmailNotificationBehaviourAdapter;
import notification.NotificationBehaviour;
import notification.SMSNotificationBehaviourAdapter;
import project.Sprint;
import users.Developer;
import users.ScrumMaster;
import users.Tester;
import users.User;

import java.util.List;

public class Subscriber implements Observer {

    private final NotificationBehaviour notificationBehaviour;// strategy pattern, email/slack/sms notification

    public Subscriber(NotificationBehaviour notificationBehaviour){
        this.notificationBehaviour = notificationBehaviour;
    }
    @Override
    public void sendNotification(BacklogItem backlogItem) {
        notificationReadyForTesting(backlogItem);
        notificationBackToToDo(backlogItem);
        notificationReadyForTestingToDoing(backlogItem);

    }

    @Override
    public void sendNotification() {

    }

    @Override
    public void sprintCancelledNotification(Sprint sprint) {
        filterUsers(sprint,"The deployment has been cancelled. find out why!" ,  ScrumMaster.class, ScrumMaster.class);

    }

    private void notificationReadyForTestingToDoing(BacklogItem backlogItem) {
        if (backlogItem.getBacklogItemPreviousState() instanceof ReadyForTesting && backlogItem.getCurrentState() instanceof Doing) {
            filterUsers(backlogItem.getSprint()
                    , "Hello Scrum Master! A Tester placed the backlog item: "
                            + backlogItem.getTitle()
                            + ". Please check it." , ScrumMaster.class);
        }

    }

    private void notificationReadyForTesting(BacklogItem backlogItem) {
        if (backlogItem.getCurrentState() instanceof ReadyForTesting) {
            filterUsers(backlogItem.getSprint() , "Hello tester! Backlog item is ready for testing" , Tester.class);
        }
    }

    private void notificationBackToToDo(BacklogItem backlogItem) {
        if (backlogItem.getCurrentState() instanceof ToDo) {
            filterUsers(backlogItem.getSprint(), "Hello developer! Backlog item is back to ToDo", Developer.class);
        }
    }

    private void filterUsers(Sprint sprint, String message, Class<?>... userClasses) {
        // filter users
        for (User user: sprint.getTeamMembers()) {
            for (Class<?> userClass: userClasses) {
                if (userClass.isInstance(user)) {
                    notificationBehaviour.sendNotification(user, message);
                }
            }
        }
    }



}
