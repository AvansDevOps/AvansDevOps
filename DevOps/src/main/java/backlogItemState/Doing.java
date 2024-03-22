package backlogItemState;

public class Doing implements BacklogItemState {

    public Doing() {
        System.out.println("Backlog item has been changed to the Doing state");
    }

    public void toDo() {
        System.out.println("Moving backlog item from doing to the ToDo state");
    }

    public void doing() {
        System.out.println("Backlog item is already in the Doing state");
    }

    public void readyForTesting() {
        System.out.println("Moving backlog item from doing to the Ready for Testing state");
    }

    public void testing() {
        System.out.println("Moving backlog item from doing to the Testing state");
    }

    public void tested() {
        System.out.println("Moving backlog item from doing to the Tested state");
    }

    public void done() {
        System.out.println("Moving backlog item form doing to the Done state");
    }

    public BacklogItemState getCurrentState() {
        System.out.println("Backlog item is in the Doing state");
        return this;
    }
}
