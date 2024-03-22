package backlogItemState;

public class ReadyForTesting implements BacklogItemState {

    public ReadyForTesting() {
        System.out.println("Backlog item is in the Ready for Testing state");
    }

    public void toDo() {
        System.out.println("Moving backlog item to the ToDo state");
    }

    public void doing() {
        System.out.println("Moving backlog item to the Doing state");
    }

    public void readyForTesting() {
        System.out.println("Backlog item is already in the Ready for Testing state");
    }

    public void testing() {
        System.out.println("Moving backlog item to the Testing state");
    }

    public void tested() {
        System.out.println("Moving backlog item to the Tested state");
    }

    public void done() {
        System.out.println("Moving backlog item to the Done state");
    }

    public BacklogItemState getCurrentState() {
        System.out.println("Backlog item is in the Ready for Testing state");
        return this;
    }
}
