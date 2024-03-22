package sprintRelease;

import project.Sprint;

import java.time.LocalDate;

public class SprintRelease extends Sprint {
    private Component component;
    private Visitor visitor;
    private Thread deploymentThread;

    public SprintRelease(String name, LocalDate startDate, LocalDate endDate) {
        super(name, startDate, endDate);
    }




    public void deployProject() {
        deploymentThread = new Thread(() -> {
            System.out.println("Project pipeline is in progress and will be deployed soon:");
            try {
                System.out.println(this.deploymentThread.getState());
                deploymentThread.wait(1000);
                System.out.println("Deploying project...");
                this.component.acceptVisitor(this.visitor);

                System.out.println("Project has been deployed successfully!" + "\n \n");
            } catch (Exception e) {
                System.out.println("Error: " + "Pipeline progress has been cancelled" + "\n \n");
            }
        });

        deploymentThread.start();
    }

    public void cancelDeployment() {
        if (deploymentThread != null) {
            deploymentThread.interrupt();
        }
        System.out.println("Deployment has been cancelled!");
    }

    public void addComponent(Component component){
        this.component = component;
    }

    public void addVisitor(Visitor visitor){
        this.visitor = visitor;
    }





}
