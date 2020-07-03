package jmx.sample;

public interface HelloMBean {
    void setMessage(String message);
    String getMessage();
    void sayHello();
}
