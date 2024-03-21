package org.example.app;

import threads.Thread;

import java.util.List;

public class BacklogItem {
    private List<Thread> thread;
    private String title;
    private String description;

    public BacklogItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void addThread(Thread thread) {
        this.thread.add(thread);
    }
}
