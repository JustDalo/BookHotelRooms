package by.tc.task04.entity;

public class User implements Database {
    private long id;
    private String login;
    private String passwordHash;
    private int roleId;
    private String firstName;
    private String lastName;


    public User(long id, String login, String passwordHash, int roleId, String firstName, String lastName) {
        this.id = id;
        this.login = login;
        this.passwordHash = passwordHash;
        this.roleId = roleId;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    @Override
    public Long getId() {
        return this.id;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
