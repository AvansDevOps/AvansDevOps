package backlogItemState;

public abstract class BacklogItemState {

    public abstract void toDo();

    public abstract void doing();

    public abstract void readyForTesting();

    public abstract void testing();

    public abstract void tested();

    public abstract void done();

    public abstract void getCurrentState();





}
