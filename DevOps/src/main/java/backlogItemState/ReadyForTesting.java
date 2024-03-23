package backlogItemState;

public class ReadyForTesting implements BacklogItemState {

    public BacklogItemState getCurrentState() {
        System.out.println("Backlog item is in the Ready for Testing state");
        return this;
    }
}
