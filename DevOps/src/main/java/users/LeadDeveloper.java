package users;

public class LeadDeveloper extends User{
    public LeadDeveloper(String name, String email) {
        super(name, email);
    }

    public void lead() {
        System.out.println("Leading the team");
    }
}
