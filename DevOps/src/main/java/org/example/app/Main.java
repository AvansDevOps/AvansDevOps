package org.example.app;


import reports.FileType;
import reports.Report;
import sprintRelease.*;
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

















    }
}