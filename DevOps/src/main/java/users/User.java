package users;

import project.Sprint;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String name;
    private String email;

    private List<Sprint> sprints;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.sprints = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.getClass().getSimpleName();
    }


}
