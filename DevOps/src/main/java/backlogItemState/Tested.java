package backlogItemState;

public class Tested implements BacklogItemState {

    public Tested() {
        System.out.println("Backlog item has been changed to the Tested state");
    }

    public void toDo() {
        System.out.println("Moving backlog item from Tested to the ToDo state");
    }

    public void doing() {
        System.out.println("Moving backlog item from Tested to the Doing state");
    }

    public void readyForTesting() {
        System.out.println("Moving backlog item from Tested to the Ready for Testing state");
    }

    public void testing() {
        System.out.println("Moving backlog item from Tested to the Testing state");
    }

    public void tested() {
        System.out.println("Backlog item is already in the Tested state");
    }

    public void done() {
        System.out.println("Moving backlog item from Tested to the Done state");
    }

    public BacklogItemState getCurrentState() {
        System.out.println("Backlog item is in the Tested state");
        return this;
    }
}
