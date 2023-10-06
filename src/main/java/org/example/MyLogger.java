package org.example;
import java.util.logging.Logger;

public class MyLogger implements LoggingControlMBean {
    private static final Logger logger = Logger.getLogger(MyLogger.class.getName());
    private boolean loggingEnabled = true;

    @Override
    public void enableLogging() {
        loggingEnabled = true;
        logger.info("Logging enabled");
    }

    @Override
    public void disableLogging() {
        loggingEnabled = false;
        logger.info("Logging disabled");
    }

    @Override
    public boolean isLoggingEnabled() {
        return loggingEnabled;
    }

    public void log(String message) {
        if (loggingEnabled) {
            logger.info(message);
        }
    }
}
