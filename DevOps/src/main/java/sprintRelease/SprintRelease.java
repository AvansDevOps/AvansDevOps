package sprintRelease;

import observers.Observable;
import observers.Observer;
import project.Sprint;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SprintRelease extends Sprint implements Observable {
    private Component component;
    private Visitor visitor;
    private Thread deploymentThread;
    private List<Observer> observers;

    public SprintRelease(String name, LocalDate startDate, LocalDate endDate) {
        super(name, startDate, endDate);
        this.observers = new ArrayList<>();
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
                System.out.println("Error: " + "Something went wrong... or the pipeline progress has been cancelled" + "\n \n");
                this.deploymentThread = null;
                notifyObservers(); // todo; sends notification once the deployment has been cancelled
                // todo; cancel the deployment also runs this notifyObservers for a second time? not good! :c bad! how to fix?
            }
        });


    }

    public void cancelDeployment() {
        if (deploymentThread != null) {
            deploymentThread.interrupt();
            this.deploymentThread = null;
        }
        System.out.println("Deployment has been cancelled!");

        // notify
        notifyObservers(); // todo; sends notification once the deployment has been cancelled
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


    @Override
    public void subscribe(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.sprintCancelledNotification(this); // annulereing van sprint
            observer.sendNotification(); // notificatie wanneer er iets mis gaat. ??
            // idk
        }
    }
}
