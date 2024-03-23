package users;

import project.Project;
import project.Sprint;
import project.SprintReview;
import reports.FileType;
import reports.Report;
import sprintRelease.SprintRelease;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ScrumMaster extends User{

    private List<Project> projects;
    private Report report;


    public ScrumMaster(String name, String email) {
        super(name, email);
        this.projects = new ArrayList<>();
    }

    public void lead() {
        System.out.println("Leading the team");
    }

    public void createProject(String name, String description) {
        projects.add(new Project(name, description));
    }

    public void createProject(Project project) {
        projects.add(project);
    }

    public void createSprint(Project projectName, Sprint sprint) {
        for ( Project project : this.projects){
            if (project == projectName){
                project.getBacklog().addSprint(sprint);
            }
        }
    }

    public void generateReport(FileType fileType, String sprintName, LocalDate date , Sprint sprint) {
        report = new Report(sprintName, 1.0, date, sprint);
        report.generateReport(fileType);
    }



    public void setSprintStatus(Sprint sprint, boolean isFinished) {
        sprint.setSprintStatus(isFinished);
    }

    public List<Project> getProjects(){
        return projects;
    }

    public void addTeamMembers(Sprint sprint, User user) {
        sprint.inviteTeamMembers(user);
    }

    public void editSprint(Sprint sprint, String name, LocalDate startDate, LocalDate endDate) {
        sprint.editSprint(name, startDate, endDate);
    }
}
