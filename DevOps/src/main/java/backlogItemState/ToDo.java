package backlogItemState;

public class ToDo extends BacklogItemState{

    public ToDo() {
        System.out.println("Backlog item has been changed to the ToDo state");
    }

    @Override
    public void toDo() {
        System.out.println("Backlog item is already in the ToDo state");
    }

    @Override
    public void doing() {
        System.out.println("Moving backlog item to the Doing state");
    }

    @Override
    public void readyForTesting() {
        System.out.println("Moving backlog item to the Ready for Testing state");
    }

    @Override
    public void testing() {
        System.out.println("Moving backlog item to the Testing state");
    }

    @Override
    public void tested() {
        System.out.println("Moving backlog item to the Tested state");
    }

    @Override
    public void done() {
        System.out.println("Moving backlog item to the Done state");
    }

    @Override
    public void getCurrentState() {
        System.out.println("Backlog item is in the ToDo state");
    }


}
