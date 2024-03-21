package sprintRelease;

import java.util.ArrayList;

public class CompositeComponent extends Component {
    private ArrayList<Component> tasks;

    public CompositeComponent() {
        tasks = new ArrayList<>();
    }

    public void addComponent(Component component) {
        tasks.add(component);
    }

    public void removeComponent(Component component) {
        tasks.remove(component);
    }


    public void acceptVisitor(Visitor visitor) {
        for (Component component : tasks) {
            component.acceptVisitor(visitor);
        }
    }

    public int getSize() {
        return tasks.size();
    }


}
