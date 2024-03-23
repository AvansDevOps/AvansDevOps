package backlogItemState;

public class Testing implements BacklogItemState {

    public BacklogItemState getCurrentState() {
        System.out.println("Backlog item is in the Testing state");
        return this;
    }
}
