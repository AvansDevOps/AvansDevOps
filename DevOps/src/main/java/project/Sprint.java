package project;

import users.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Sprint {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<User> teamMembers;

    public List<User> getTeamMembers() {
        return teamMembers;
    }

    public Sprint(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.teamMembers = new ArrayList<>();
    }
    public Sprint(String name) {
        this.name = name;
    }

    public void isFinished(){
        if (LocalDate.now().isAfter(endDate)){
            System.out.println("Sprint is finished");
        } else {
            System.out.println("Sprint is not finished");
        }
    }

    public void cancelSprint(){
        // todo; Notification to related team members and find a way to make this readONly?
    }

    public void inviteTeamMembers(User user){
        this.teamMembers.add(user);
    }





    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void editSprint(String name, LocalDate startDate, LocalDate endDate) {
        if (LocalDate.now().isAfter(this.startDate)){
            throw new IllegalArgumentException("Sprint cannot be edited while its started!");
        }

        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }



    @Override
    public String toString() {
        return "Sprint{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", teamMembers=" + teamMembers +
                '}';
    }


}
