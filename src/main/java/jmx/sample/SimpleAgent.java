package jmx.sample;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.SocketImpl;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

/**
 * A Simple for implementing JMX MBeans and MBeanServer
 *
 * https://alvinalexander.com/blog/post/java/source-code-java-jmx-hello-world-application/
 */
public class SimpleAgent {

    private MBeanServer mBeanServer = null;

    public SimpleAgent() {
        // get the platform MBeanServer
        mBeanServer = ManagementFactory.getPlatformMBeanServer();

        // unique identification of MBeans
        Hello helloBean = new Hello();
        ObjectName helloName = null;

        try {
            // Uniquely identify the MBeans and register them with the platform MBeanServer
            helloName = new ObjectName("FOO:name=HelloBean");
            mBeanServer.registerMBean(helloBean, helloName);

        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException | InstanceAlreadyExistsException |
                MBeanRegistrationException e) {
            e.printStackTrace();
        }
    }

    // Utility method: so that the application continues to run
    private static void waitForEnterPressed() {
        try {
            System.out.println("Press to continue...");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        SimpleAgent agent = new SimpleAgent();
        System.out.println("SimpleAgent is running...");

        // scenario 1. single-threaded
        SimpleAgent.waitForEnterPressed();

        // scenario 2. multi-threaded
//        new PingPong("ping",    2000, 1000).start();
//        new PingPong("  pong",  5000,  500).start();
//        new PingPong(" ding",   4000,  500).start();
//        new PingPong("   dong", 3000,  500).start();
//        new PingPong("PONG",    2800,  500).start();
    }

}
