package backlogItemState;

public class Done implements BacklogItemState {

    public Done() {
        System.out.println("Backlog item has been changed to the Done state");
    }

    public void toDo() {
        System.out.println("Moving backlog item from Done to the ToDo state");
    }

    public void doing() {
        System.out.println("Moving backlog item from Done to the Doing state");
    }

    public void readyForTesting() {
        System.out.println("Moving backlog item from Done to the Ready for Testing state");
    }

    public void testing() {
        System.out.println("Moving backlog item from Done to the Testing state");
    }

    public void tested() {
        System.out.println("Moving backlog item from Done to the Tested state");
    }

    public void done() {
        System.out.println("Backlog item is already in the Done state");
    }

    public BacklogItemState getCurrentState() {
        System.out.println("Backlog item is in the Done state");
        return this;
    }
}
