package backlogItemState;

public abstract class BaseBacklogItemState implements BacklogItemState {
    protected final String stateName;

    public BaseBacklogItemState(String stateName) {
        this.stateName = stateName;
        System.out.println("Backlog item has been changed to the " + stateName + " state");
    }

    @Override
    public void toDo() {
        System.out.println("Moving backlog item from " + stateName + " to the ToDo state");
    }

    @Override
    public void doing() {
        System.out.println("Moving backlog item from " + stateName + " to the Doing state");
    }

    @Override
    public void readyForTesting() {
        System.out.println("Moving backlog item from " + stateName + " to the Ready for Testing state");
    }

    @Override
    public void testing() {
        System.out.println("Moving backlog item from " + stateName + " to the Testing state");
    }

    @Override
    public void tested() {
        System.out.println("Moving backlog item from " + stateName + " to the Tested state");
    }

    @Override
    public void done() {
        System.out.println("Backlog item is already in the " + stateName + " state");
    }

    @Override
    public BacklogItemState getCurrentState() {
        System.out.println("Backlog item is in the " + stateName + " state");
        return this;
    }
}
