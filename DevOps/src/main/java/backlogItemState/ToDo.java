package backlogItemState;

public class ToDo implements BacklogItemState {

    public BacklogItemState getCurrentState() {
        System.out.println("Backlog item is in the the ToDo state");
        return this;
    }
}
