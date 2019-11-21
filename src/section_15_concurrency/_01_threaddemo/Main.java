package section_15_concurrency._01_threaddemo;

import static section_15_concurrency._01_threaddemo.ThreadColor.*;


public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.");

        // First way to start a thread: with subclassing the Thread class.
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        // anotherThread.run(); - wrong manner, it does not start a new thread, the run method will run in the main thread
        anotherThread.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class thread.");
            }
        }.start();

        // The other method: a class implementing the Runnable interface.

        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

        Thread myRunnableThreadAnonymous = new Thread(new MyRunnable() {
            @Override
            public void run() {
                // super.run();
                System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of run().");
            }
        });
        myRunnableThreadAnonymous.start();

        System.out.println(ANSI_PURPLE + "Hello again from main thread.");
    }

}
