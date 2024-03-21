package sprintRelease;

import project.Sprint;

import java.time.LocalDate;

public class SprintRelease extends Sprint {
    private Component component;
    private Visitor visitor;

    public SprintRelease(String name, LocalDate startDate, LocalDate endDate) {
        super(name, startDate, endDate);
    }



    public void deployProject(){
        System.out.println("Project deployed");
    }


}
