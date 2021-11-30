package by.tc.task04.pool;

import java.sql.Connection;

public interface ConnectionPool {
    Connection takeConnection();

    void releaseConnection(Connection connection);
}
