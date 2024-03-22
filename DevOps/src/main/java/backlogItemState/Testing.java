package backlogItemState;

public class Testing implements BacklogItemState {

    public void toDo() {
        System.out.println("Moving backlog item to the ToDo state");
    }

    public void doing() {
        System.out.println("Moving backlog item to the Doing state");
    }

    public void readyForTesting() {
        System.out.println("Moving backlog item to the Ready for Testing state");
    }

    public void testing() {
        System.out.println("Backlog item is already in the Testing state");
    }

    public void tested() {
        System.out.println("Moving backlog item to the Tested state");
    }

    public void done() {
        System.out.println("Moving backlog item to the Done state");
    }

    public BacklogItemState getCurrentState() {
        System.out.println("Backlog item is in the Testing state");
        return this;
    }

}
