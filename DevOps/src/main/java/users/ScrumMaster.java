package users;

import project.Project;
import project.Sprint;
import project.SprintReview;
import sprintRelease.SprintRelease;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ScrumMaster extends User{

    private List<Project> projects;


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





    public void createSprintReview(Project projectName, SprintReview sprintReview) {
        for ( Project project : this.projects){
            if (project == projectName){
                new SprintReview(sprintReview.getName(), sprintReview.getStartDate(), sprintReview.getEndDate());
            }

        }
    }

    public void createSprintRelease(Project projectName, SprintRelease sprintRelease) {
        for ( Project project : this.projects){
            if (project == projectName){
                new SprintRelease(sprintRelease.getName(), sprintRelease.getStartDate(), sprintRelease.getEndDate());
            }

        }
    }

    public void cancelSprint(Sprint sprint) {
        sprint.cancelSprint();
    }

    public void addTeamMembers(Sprint sprint, User user) {
        sprint.inviteTeamMembers(user);
    }

    public void editSprint(Sprint sprint, String name, LocalDate startDate, LocalDate endDate) {
        sprint.editSprint(name, startDate, endDate);
    }




}
