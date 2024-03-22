package org.example.app;


import backlogItemState.*;
import notification.EmailNotificationBehaviourAdapter;
import notification.Notification;
import notification.NotificationBehaviour;
import notification.SMSNotificationBehaviourAdapter;
import observers.Observer;
import observers.Subscriber;
import project.Activity;
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
import users.Tester;
import users.User;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // creating a scrum master
        ScrumMaster scrumMaster = new ScrumMaster("Mars", "Mars@gmail.com");

        // creating a project
        Project project = new Project("My project", "This is a project");

        // adding project to scrum master
        scrumMaster.createProject(project);

        //create a sprint
        SprintRelease sprint = new SprintRelease("Sprint 1", null, null);
        sprint.setStartDate(LocalDate.now());
        sprint.setEndDate(LocalDate.now().plusDays(7));

        // Scrum master creating a sprint for this project
        scrumMaster.createSprintRelease(project, sprint);

        // editing sprint data
        scrumMaster.editSprint(sprint, "Sprint edited! whaow!", LocalDate.now(), LocalDate.now().plusDays(14));



        // adding users to sprint
        User user1 = new Developer("John", "John@gmail.com");
        User user2 = new Tester("Jane" , "Jane@gmail.com");
        User user3 = new Tester("Bark" , "Bark@gmail.com");

        scrumMaster.addTeamMembers(sprint, user1);
        scrumMaster.addTeamMembers(sprint, user2);
        scrumMaster.addTeamMembers(sprint, user3);


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

        //creating a base component for the composite pattern
        sprint.addComponent(mainFolder);
        sprint.addVisitor(visitor);

        // deploying the project (sprintRelease)®
        //sprint.deployProject();
//        sprint.deployProject();
//        sprint.cancelDeployment();











        // generating a report Factory pattern
        Report report = new Report("Sprint 1 report", 1.0, LocalDate.now(), sprint);
        report.generateReport(FileType.PDF);
        report.generateReport(FileType.PNG);

        System.out.println("\n \n");


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
        BacklogItem backlogItem = new BacklogItem("This is a backlog item", "This is a description", sprint);

        // creating activity
        Activity activity1 = new Activity("This is an activity", "This is a description");
        activity1.setDev(user1);
        backlogItem.addActivity(activity1);

        Activity activity2 = new Activity("This is an activity", "This is a description");
        activity2.setDev(user2);
        backlogItem.addActivity(activity2);



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
        //backlogItem.unsubscribe(subscriber1);

        //sprint.deployProject(); //to check if the error works when deploying a project while a backlogItem is changing a state

        //setting state of backlogItem
        backlogItem.setState(new Done());




























    }
}