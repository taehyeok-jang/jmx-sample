package jmx.sample;

/**
 * A simple class that extends Thread
 *
 * https://alvinalexander.com/blog/post/java/source-code-java-multi-threaded-jmx-application/
 */
public class PingPong extends Thread {
    String word;                 // what word to print
    int delay;                   // how long to pause
    int count;                   // number of iterations

    PingPong(String what, int time, int number) {
        word = what;
        delay = time;
        count = number;
        setName(what);
    }

    public void run() {
        try {
            for(int i=0;i < count;i++) {
                System.out.println(i+": "+word+":"+activeCount());
                sleep(delay);    // wait until next time
            }
        }  catch (InterruptedException e) {
            return;             // end this thread
        }
    }
}
