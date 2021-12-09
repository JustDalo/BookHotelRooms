package by.tc.task04.entity;

import java.util.Objects;

public class User implements Database {
    private long id;
    private String login;
    private String passwordHash;
    private int roleId;
    private String firstName;
    private String lastName;

    public User(String login, String password) {
        this.login = login;
        this.passwordHash = password;
    }

    public User(long id, String login, String passwordHash, int roleId, String firstName, String lastName) {
        this.id = id;
        this.login = login;
        this.passwordHash = passwordHash;
        this.roleId = roleId;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public User(String login, String passwordHash, int roleId, String firstName, String lastName) {
        this.login = login;
        this.passwordHash = passwordHash;
        this.roleId = roleId;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id && roleId == user.roleId && Objects.equals(login, user.login) && Objects.equals(passwordHash, user.passwordHash) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, passwordHash, roleId, firstName, lastName);
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
