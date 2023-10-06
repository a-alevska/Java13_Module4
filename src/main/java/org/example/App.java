package org.example;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.logging.Logger;

public class App 
{
    public static void enableJMXServer(){
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = null;
        try {
            name = new ObjectName("com.example:type=LoggingControl");
        } catch (MalformedObjectNameException e) {
            System.out.println("Logging failed");
        }

        MyLogger logger = new MyLogger();
        try {
            mbs.registerMBean(logger, name);
        } catch (InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException e) {
            System.out.println("MBean isn't available");
        }
        Logger rootLogger = Logger.getLogger("");
        rootLogger.addHandler(new MBeanLoggingHandler(logger));
        logger.log("Logging process");
    }
    public static void main( String[] args )
    {
        enableJMXServer();
        StringChanger stringChanger = new StringChanger();
        stringChanger.inputInitialString();
        stringChanger.printResult(stringChanger.convertString());
    }
}
