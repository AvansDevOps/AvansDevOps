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
                deploymentThread.start();
                System.out.println(this.deploymentThread.getState());
                deploymentThread.wait(500);
                this.component.acceptVisitor(this.visitor);
                System.out.println("Project has been deployed successfully!" + "\n \n");
            } catch (Exception e) {
                System.out.println("Error: " + "Pipeline progress has been cancelled" + "\n \n");
                this.deploymentThread = null;
            }
        });
    }

    public void cancelDeployment() {
        if (deploymentThread != null) {
            deploymentThread.interrupt();
            this.deploymentThread = null;
        }
        System.out.println("Deployment has been cancelled!");
    }

    public void addComponent(Component component){
        this.component = component;
    }

    public void addVisitor(Visitor visitor){
        this.visitor = visitor;
    }

    public void getPipelineStatus(){
        System.out.println("Pipeline status: " + this.deploymentThread.getState());
    }

    // return the deploymentThread state
    public boolean threadIsRunning() {
        if (deploymentThread != null) {
            return true;
        } else {
            return false;
        }
    }




}
