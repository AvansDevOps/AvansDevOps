package project;

import users.User;

public class Activity {
    private String name;
    private String description;
    private User dev;

    public Activity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setDev(User dev) {
        if (this.dev != null) {
            throw new IllegalArgumentException("Developer is allrdy assigned to this activity");
        }
        this.dev = dev;
    }

    public String toString() {
        return "Activity: " + name + "done by" + this.dev + "\n" +
                "Description: " + description + "\n";
    }
}
