package project;

import backlogItemState.BacklogItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Backlog {
    private List<Sprint> sprints;

    private List<BacklogItem> backlogItems;

    public Backlog() {
        sprints = new ArrayList<>();
        backlogItems = new ArrayList<>();
    }

    public void addSprint(Sprint sprint) {
        if (sprint == null) {
            throw new IllegalArgumentException("Sprint cannot be null");
        } else {
            sprints.add(sprint);
        }
    }

    public void addBacklogItem(BacklogItem backlogItem){
        backlogItems.add(backlogItem);
    }

    public List<BacklogItem> getBacklogItems(){
        Collections.sort(backlogItems);

        return backlogItems;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public void createSprint(Sprint sprint) {
        sprints.add(sprint);
    }



    @Override
    public String toString() {
        return "Backlog{" +
                "sprints=" + sprints +
                '}';
    }
}
