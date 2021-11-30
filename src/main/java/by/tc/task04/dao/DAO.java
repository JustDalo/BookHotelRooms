package by.tc.task04.dao;

import by.tc.task04.entity.Database;

import java.util.List;
import java.util.Optional;

public interface DAO<T extends Database> {
    T save(T entity);

    List<T> findAll();

    Optional<T> findById(Long id);

    T update(T entity);

    void delete(Long id);
}
