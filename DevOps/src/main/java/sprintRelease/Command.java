package sprintRelease;

import sprintRelease.Component;

public class Command extends Component {
    private String name;
    private String description;
    private String command;
    private String output;
    private String error;
    private String status;

    public Command(String name, String description, String command) {
        this.name = name;
        this.description = description;
        this.command = command;
        this.status = "Finished";
    }

    @Override
    public String toString() {
        return "Command{" +
                "name='" + name + '\'' +
                ", command='" + command + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
