package org.example.app;


//import backlogItemState.*;
//import notification.*;
//import observers.Observer;
//import observers.Subscriber;
//import project.Activity;
//import project.Backlog;
//import backlogItemState.BacklogItem;
//import project.Project;
//import project.SprintReview;
//import reports.FileType;
//import reports.Report;
//import sprintRelease.*;
//import threads.Comment;
//import threads.Forum;
//import threads.Thread;
//import users.Developer;
//import users.ScrumMaster;
//import users.Tester;
//import users.User;
//
//import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        // creating a scrum master
//        ScrumMaster scrumMaster = new ScrumMaster("Mars", "Mars@gmail.com");
//
//        // creating a project
//        Project project = new Project("My project", "This is a project");
//
//        // adding project to scrum master
//        scrumMaster.createProject(project);
//
//        //create a sprint
//        SprintRelease sprint = new SprintRelease("Sprint 1", LocalDate.now(), LocalDate.now().plusDays(7));
//        // Scrum master creating a sprint for this project
//        scrumMaster.createSprint(project, sprint);
//
//        // editing sprint data
//       // scrumMaster.editSprint(sprint, "Sprint edited! whaow!", LocalDate.now(), LocalDate.now().plusDays(14));
//
//
//
//        // adding users to sprint
//        User user1 = new Developer("John", "John@gmail.com");
//        User user2 = new Tester("Jane" , "Jane@gmail.com");
//        User user3 = new Tester("Bark" , "Bark@gmail.com");
//
//        scrumMaster.addTeamMembers(sprint, user1);
//        scrumMaster.addTeamMembers(sprint, user2);
//        scrumMaster.addTeamMembers(sprint, user3);
//
//
//        // Composite pattern > folder structure
//        Folder mainFolder = new Folder("Deployment folder");
//
//            Folder testFolder = new Folder("Test folder");
//                Command runningUnitTests = new Command("Running unit tests", "This will run all unit tests inside AvansOps", "run tests.exe");
//                    testFolder.addComponent(runningUnitTests);
//
//            Folder buildFolder = new Folder("Build folder");
//                Command buildProject = new Command("Building project", "This will build the project", "build project.exe");
//                    buildFolder.addComponent(buildProject);
//
//            Folder packagesFolder = new Folder("Packages folder");
//                Folder libraryMail = new Folder("Library mail");
//                    Command sendMail = new Command("EmailLibrary", "This will send a mail", "send mail.exe");
//                        libraryMail.addComponent(sendMail);
//                        packagesFolder.addComponent(libraryMail);
//
//                Folder librarySMS = new Folder("Library SMS");
//                    Command sendSMS = new Command("SMSLibrary", "This will send a SMS", "send SMS.exe");
//                        librarySMS.addComponent(sendSMS);
//                        packagesFolder.addComponent(librarySMS);
//
//        mainFolder.addComponent(testFolder);
//        mainFolder.addComponent(buildFolder);
//        mainFolder.addComponent(packagesFolder);
//
//
//
//
//
//
//        // visitor pattern
//        VisitorStartDeployment visitor = new VisitorStartDeployment();
//
//        //creating a base component for the composite pattern
//        sprint.addComponent(mainFolder);
//        sprint.addVisitor(visitor);
//
//        // deploying the project (sprintRelease)®
//        sprint.deployProject();
//
////        sprint.cancelDeployment();
//
//
//
//
//
//
//
//
//
//
//
//        // generating a report Factory pattern
//        scrumMaster.generateReport(FileType.PNG,"Sprint 1 report",  LocalDate.now(), sprint);
//
//        System.out.println("\n");
//
//
//        // generating a forum thread comment
//        Forum forum = new Forum(sprint);
//        Thread backlogItemFailed = new Thread("This is a thread", "test");
//        forum.addThread(backlogItemFailed);
//
//        Comment comment = new Comment("This is a comment", user1);
//        Comment comment2 = new Comment("This is a comment", user2);
//        backlogItemFailed.addComment(comment);
//        backlogItemFailed.addComment(comment2);
//        System.out.println("");
//        System.out.println(backlogItemFailed);
//        //
//        System.out.println("");
//
//
//        // creating backlogItems
//        BacklogItem backlogItem = new BacklogItem("This is a backlog item", "This is a description", sprint);
//
//        // creating activity
//        Activity activity1 = new Activity("This is an activity", "This is a description");
//        activity1.setDev(user1);
//        backlogItem.addActivity(activity1);
//
//        Activity activity2 = new Activity("This is an activity", "This is a description");
//        activity2.setDev(user2);
//        backlogItem.addActivity(activity2);
//
//
//
////        backlogItem.getCurrentState();
////        backlogItem.setState(new Doing());
////        backlogItem.getCurrentState();
////        backlogItem.setState(new ReadyForTesting());
////        backlogItem.getCurrentState();
////        backlogItem.setState(new Testing());
////        backlogItem.getCurrentState();
////        backlogItem.setState(new Tested());
////        backlogItem.getCurrentState();
////        backlogItem.setState(new Done());
//
//
//
//        // creating notification //observer pattern
//
//        Observer subscriber1 = new Subscriber(new SMSNotificationBehaviourAdapter());
//        backlogItem.subscribe(subscriber1);
//        //backlogItem.unsubscribe(subscriber1);
//
//        //sprint.deployProject(); //to check if the error works when deploying a project while a backlogItem is changing a state
//
//        //setting state of backlogItem
//        backlogItem.setState(new Done());
    }
}