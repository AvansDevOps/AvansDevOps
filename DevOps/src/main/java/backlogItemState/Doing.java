package backlogItemState;

public class Doing implements BacklogItemState {

    public BacklogItemState getCurrentState() {
        System.out.println("Backlog item is in the Doing state");
        return this;
    }
}
