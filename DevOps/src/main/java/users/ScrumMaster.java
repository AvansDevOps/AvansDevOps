package users;

public class ScrumMaster extends User{
    public ScrumMaster(String name, String email) {
        super(name, email);
    }

    public void lead() {
        System.out.println("Leading the team");
    }
}
