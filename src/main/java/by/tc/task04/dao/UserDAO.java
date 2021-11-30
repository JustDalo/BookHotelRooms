package by.tc.task04.dao;

import by.tc.task04.entity.User;

import java.util.Optional;

public interface UserDAO extends DAO<User> {
    Optional<User> findUserByName(String name);
}
