package section_15_concurrency._02_joininterrupt;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from MyRunnable's implementation of run().");
    }

}