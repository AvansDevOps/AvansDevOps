package project;

import users.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Sprint {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<User> teamMembers;
    private boolean isFinished;
    private Timer timer;

    public List<User> getTeamMembers() {
        return teamMembers;
    }


    public Sprint(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.teamMembers = new ArrayList<>();
        this.isFinished = false;
        timer = new Timer();
        startChecking();
    }

    public void inviteTeamMembers(User user){
        this.teamMembers.add(user);
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getName() {
        return name;
    }

    public void editSprint(String name, LocalDate startDate, LocalDate endDate) {
        if (LocalDate.now().isAfter(this.startDate)){
            throw new IllegalArgumentException("Sprint cannot be edited while its started!");
        }

        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setSprintStatus(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public boolean isFinished(){
        return isFinished;
    }

    public void startChecking(){
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                // This code will be executed every 100000 seconds
                if (LocalDate.now().isAfter(endDate)) {
                    System.out.println("The deadline has passed!");
                    timer.cancel(); // Stop the timer
                } else {
                   // System.out.println("The deadline has not passed yet.");
                }
            }
        }, 0, 100000);
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
