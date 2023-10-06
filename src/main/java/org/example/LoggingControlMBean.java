package org.example;

import javax.management.MXBean;

@MXBean
public interface LoggingControlMBean {
    void enableLogging();
    void disableLogging();
    boolean isLoggingEnabled();
}

