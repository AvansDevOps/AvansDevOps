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
    }


    public void activateThread() {
        isActive = true;

    }

    public void deactivateThread() {
        isActive = false;

    }

    public void addComment(Comment comment) {
        if (!isActive) throw new IllegalStateException("Thread is not active");
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        if (!isActive) throw new IllegalStateException("Thread is not active");
        comments.remove(comment);
    }
}
