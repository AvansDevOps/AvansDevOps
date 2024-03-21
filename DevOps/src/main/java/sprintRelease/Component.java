package sprintRelease;

public abstract class Component {


    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }


}
