package section_15._13_fairlocks;

import java.util.concurrent.locks.ReentrantLock;

public class FairLockDemo {
    /*
    The parameter in the constructor is for whether it is a fair lock or not.
    1) Only fairness in acquiring the lock is guaranteed (first came first served ordering for getting the lock),
    not fairness in thread scheduling.
    2) The tryLock method does not honor the fairness settings.
    3) With a lot of threads performance will be impacted to ensure fairness.
     */
    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");

        // Priority is just a suggestion for the OS, we can never force the OS to run threads in a specific order.
        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    private static class Worker implements Runnable {
        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; ++i) {
                lock.lock();
                try {
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                    // Execute critical section of code {...}
                } finally {
                   lock.unlock();
                }
            }
        }
    }

}
