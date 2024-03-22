package backlogItemState;

public class ToDo implements BacklogItemState {

    public ToDo() {
        System.out.println("Backlog item has been changed to the ToDo state");
    }

    public void toDo() {
        System.out.println("Backlog item is already in the ToDo state");
    }

    public void doing() {
        System.out.println("Moving backlog item from ToDo to the Doing state");
    }

    public void readyForTesting() {
        System.out.println("Moving backlog item from ToDo to the Ready for Testing state");
    }

    public void testing() {
        System.out.println("Moving backlog item from ToDo to the Testing state");
    }

    public void tested() {
        System.out.println("Moving backlog item from ToDo to the Tested state");
    }

    public void done() {
        System.out.println("Moving backlog item from ToDo to the Done state");
    }

    public BacklogItemState getCurrentState() {
        System.out.println("Backlog item is in the the ToDo state");
        return this;
    }
}
