package by.tc.task04.pool.impl;

import by.tc.task04.pool.ConnectionPool;

import java.sql.Connection;

public class ConnectionPoolImpl implements ConnectionPool {

    private static final ConnectionPoolImpl instance = new ConnectionPoolImpl();

    static public ConnectionPoolImpl getInstance() {
        return instance;
    }

    @Override
    public Connection takeConnection() {
        return null;
    }

    @Override
    public void releaseConnection(Connection connection) {

    }
}
