package backlogItemState;

public class Done implements BacklogItemState {

    public BacklogItemState getCurrentState() {
        System.out.println("Backlog item is in the Done state");
        return this;
    }
}
