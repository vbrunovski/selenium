package ddt;

public class User {
    public User(String name, String email, String pass) {
        this.name = name;
        this.email = email;
        this.pass = pass;
    }

    public final String name;
    public final String email;
    public final String pass;
}
