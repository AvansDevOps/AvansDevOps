package org.example.app;


import backlogItemState.*;
import notification.EmailNotificationBehaviourAdapter;
import notification.Notification;
import notification.NotificationBehaviour;
import notification.SMSNotificationBehaviourAdapter;
import observers.Observer;
import observers.Subscriber;
import project.Backlog;
import backlogItemState.BacklogItem;
import project.Project;
import reports.FileType;
import reports.Report;
import sprintRelease.*;
import threads.Comment;
import threads.Forum;
import threads.Thread;
import users.Developer;
import users.ScrumMaster;
import users.User;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Project project = new Project("My project", "This is a project");
        Backlog backlog = new Backlog();
        project.setBacklog(backlog);

        SprintRelease sprint = new SprintRelease("Sprint 1", null, null);
        sprint.setStartDate(LocalDate.now());
        sprint.setEndDate(LocalDate.now().plusDays(7)); // 14 days
        backlog.addSprint(sprint);

        // adding users to sprint
        User user1 = new Developer("John", "John@gmail.com");
        User user2 = new ScrumMaster("Jane" , "Jane@gmail.com");
        sprint.inviteTeamMembers(user1);
        sprint.inviteTeamMembers(user2);

        sprint.deployProject();
        // Composite pattern > folder structure
        Folder mainFolder = new Folder("Deployment folder");
            Folder testFolder = new Folder("Test folder");
                Command runningUnitTests = new Command("Running unit tests", "This will run all unit tests inside AvansOps", "run tests.exe");

            Folder buildFolder = new Folder("Build folder");
                Command buildProject = new Command("Building project", "This will build the project", "build project.exe");



        mainFolder.addComponent(testFolder);
        testFolder.addComponent(runningUnitTests);

        mainFolder.addComponent(buildFolder);
        buildFolder.addComponent(buildProject);

        // visitor pattern
        VisitorStartDeployment visitor = new VisitorStartDeployment();
        mainFolder.acceptVisitor(visitor);

        // generating a report Factory pattern
        Report report = new Report("Sprint 1 report", 1.0, LocalDate.now(), sprint);
        report.generateReport(FileType.PDF);
        report.generateReport(FileType.PNG);


        // generating a forum thread comment
        Forum forum = new Forum(sprint);
        Thread backlogItemFailed = new Thread("This is a thread", "test");
        forum.addThread(backlogItemFailed);

        Comment comment = new Comment("This is a comment", user1);
        Comment comment2 = new Comment("This is a comment", user2);
        backlogItemFailed.addComment(comment);
        backlogItemFailed.addComment(comment2);
        System.out.println("");
        System.out.println(backlogItemFailed);
        //
        System.out.println("");
        // creating backlogItems
        BacklogItem backlogItem = new BacklogItem("This is a backlog item", "This is a description");

        backlogItem.setState(new ReadyForTesting());
//        backlogItem.getCurrentState();
//        backlogItem.setState(new Doing());
//        backlogItem.getCurrentState();
//        backlogItem.setState(new ReadyForTesting());
//        backlogItem.getCurrentState();
//        backlogItem.setState(new Testing());
//        backlogItem.getCurrentState();
//        backlogItem.setState(new Tested());
//        backlogItem.getCurrentState();
//        backlogItem.setState(new Done());



        // creating notification //observer pattern
        Observer subscriber1 = new Subscriber();
        backlogItem.subscribe(subscriber1);
        backlogItem.notifyObservers();
        backlogItem.unsubscribe(subscriber1);

        subscriber1.sendNotification(backlogItem);
























    }
}