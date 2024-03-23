package backlogItemState;

public class Tested implements BacklogItemState {

    public BacklogItemState getCurrentState() {
        System.out.println("Backlog item is in the Tested state");
        return this;
    }
}
