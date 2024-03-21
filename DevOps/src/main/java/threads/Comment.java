package threads;

import users.User;

public class Comment {
    private String comment;
    private User user;

    public Comment(String comment, User user) {
        this.comment = comment;
        this.user = user;
    }

}
