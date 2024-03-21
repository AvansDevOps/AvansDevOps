package sprintRelease;

public class Folder extends CompositeComponent {
    private String folderName;

    public Folder(String folderName)
    {
        this.folderName = folderName;
    }

    public String getFolderName()
    {
        return folderName;
    }

    public void acceptVisitor(Visitor visitor)
    {
        visitor.visit(this);
        super.acceptVisitor(visitor);
    }

    @Override
    public String toString() {
        return "folder = '" + folderName + '\'';
    }
}
