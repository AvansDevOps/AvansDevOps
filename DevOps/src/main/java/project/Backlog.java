package project;

import java.util.ArrayList;
import java.util.List;

public class Backlog {
    private List<Sprint> sprints;

    public Backlog() {
        sprints = new ArrayList<>();

    }

    public void addSprint(Sprint sprint) {
        if (sprint == null) {
            throw new IllegalArgumentException("Sprint cannot be null");
        } else {
            sprints.add(sprint);
        }
    }

    @Override
    public String toString() {
        return "Backlog{" +
                "sprints=" + sprints +
                '}';
    }
}
