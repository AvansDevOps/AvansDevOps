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
        if (sprint.isFinished()) {
            System.out.println("Sprint is finished, you can't add a thread to the forum");
            return;
        }
        threads.add(thread);
    }

}
