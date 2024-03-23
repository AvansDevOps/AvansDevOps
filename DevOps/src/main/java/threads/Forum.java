package threads;

import project.Sprint;

import java.util.ArrayList;
import java.util.List;

public class Forum {

    private List<Thread> threads;
    private Sprint sprint;

    public Forum(Sprint sprint) {
        this.sprint = sprint;
        this.threads = new ArrayList<>();
    }

    public void addThread(Thread thread) {
        if (sprint.isFinished()) throw new IllegalStateException("Sprint is finished");

        threads.add(thread);
    }

}
