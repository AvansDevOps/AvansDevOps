package threads;

import org.example.app.Sprint;

import java.util.List;

public class Forum {

    private List<Thread> threads;
    private Sprint sprint;

    public Forum(Sprint sprint) {
        this.sprint = sprint;
    }



    public void addThread(Thread thread) {
        threads.add(thread);
    }

}
