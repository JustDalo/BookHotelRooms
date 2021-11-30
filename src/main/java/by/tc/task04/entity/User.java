package by.tc.task04.entity;

public class User implements Database {
    private long id;
    private String name;
    private String passwordHash;
    private String email;

    public User(long id, String name, String passwordHash, String email) {
        this.id = id;
        this.name = name;
        this.passwordHash = passwordHash;
        this.email = email;
    }

    @Override
    public Long getId() {
        return this.id;
    }
}
