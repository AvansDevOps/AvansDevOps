package sprintRelease;

public class VisitorStartDeployment extends Visitor{
    @Override
    public void visit(Component component) {
        System.out.println("Starting: " + component);
    }
}
