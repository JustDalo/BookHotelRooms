package by.tc.task04.dao;

import by.tc.task04.entity.Database;
import by.tc.task04.exceptions.DAOException;

import java.util.List;
import java.util.Optional;

public interface DAO<T extends Database> {
    T save(T entity) throws DAOException;

    List<T> findAll();

    Optional<T> findById(Long id);

    void delete(Long id);
}
