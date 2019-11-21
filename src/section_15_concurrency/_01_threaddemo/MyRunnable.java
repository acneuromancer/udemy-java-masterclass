package section_15_concurrency._01_threaddemo;

import static section_15_concurrency._01_threaddemo.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from MyRunnable's implementation of run().");
    }

}
