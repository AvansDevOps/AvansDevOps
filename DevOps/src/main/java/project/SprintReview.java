package project;

import reports.Report;

import java.time.LocalDate;

public class SprintReview extends Sprint{
    public SprintReview(String name, LocalDate startDate, LocalDate endDate) {
        super(name, startDate, endDate);
    }


    public void createReview(){
        System.out.println("Review created");
    }


    // close sprint
    public void closeSprint(){
        System.out.println("Sprint closed");
    }
}
