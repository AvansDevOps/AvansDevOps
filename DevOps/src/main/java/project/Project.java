package project;

public class Project {
    private String name;
    private String description;

    private Backlog backlog;

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        this.backlog = new Backlog();
    }

    public Backlog getBacklog() {
        return backlog;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", backlog=" + backlog +
                '}';
    }
}
