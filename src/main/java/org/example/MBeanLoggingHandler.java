package org.example;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MBeanLoggingHandler extends Handler {
    private final LoggingControlMBean loggingControlMBean;

    public MBeanLoggingHandler(LoggingControlMBean loggingControlMBean) {
        this.loggingControlMBean = loggingControlMBean;
    }

    @Override
    public void publish(LogRecord logRecord) {
        if (loggingControlMBean.isLoggingEnabled()) {
            System.out.println("Logging of the app");
        }
    }

    @Override
    public void flush() { /* not necessary in this case */ }

    @Override
    public void close() throws SecurityException { /* not necessary in this case */ }
}

