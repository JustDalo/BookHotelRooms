package by.tc.task04.pool;

import by.tc.task04.exceptions.ConnectionPoolException;

import java.sql.Connection;

public interface ConnectionPool {
    Connection takeConnection() throws ConnectionPoolException;

    boolean releaseConnection(Connection connection) throws ConnectionPoolException;

    void init() throws ConnectionPoolException;

    void destroy() throws ConnectionPoolException;
}
