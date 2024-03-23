package threads;

import java.util.ArrayList;
import java.util.List;

public class Thread {
    private List<Comment> comments;
    private String title;
    private String content;
    private boolean isActive;

    public Thread(String title, String content) {
        this.title = title;
        this.content = content;
        this.comments = new ArrayList<>();
        this.isActive = true;
    }

    public void addComment(Comment comment) {
        if (!isActive) throw new IllegalStateException("Thread is not active");
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        if (!isActive) throw new IllegalStateException("Thread is not active");
        comments.remove(comment);
    }

    public void activateThread() {
        isActive = true;

    }

    public void deactivateThread() {
        isActive = false;

    }

    @Override
    public String toString() {
        return "Thread: " + title + "\n" +
                "comments=" + comments;
    }
}
