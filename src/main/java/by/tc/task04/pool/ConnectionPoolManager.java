package by.tc.task04.pool;

import by.tc.task04.exceptions.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConnectionPoolManager implements ServletContextListener {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionPoolImpl.getInstance().init();
        } catch (ConnectionPoolException e) {
            logger.error("Unable to initialize connection pool. {}", e.getMessage());
            throw new RuntimeException("Unable to initialize connection pool.", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            ConnectionPoolImpl.getInstance().destroy();
        } catch (ConnectionPoolException e) {
            logger.error("Unable to dispose connection pool. {}", e.getMessage());
            throw new RuntimeException("Unable to dispose connection pool.", e);
        }
    }
}
