package backlogItemState;

public interface BacklogItemState {

    void toDo();

    void doing();

    void readyForTesting();

    void testing();

    void tested();

    void done();

    BacklogItemState getCurrentState();





}
