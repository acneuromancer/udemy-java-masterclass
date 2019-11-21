package section_15_concurrency._03_multiplethreads;

public class Main {

    public static void main(String[] args) {
        Countdown countdown = new Countdown();
        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }

}

class Countdown {

    /*
    Object instant variables are in a memory allocated on the heap.
    When multiple threads working with the same object, they in fact share the same object.
    They don't have their own copy as such. So when one thread changes the instance variable,
    the other thread will see the the new value from that point forward.
    This situation is called thread interference or race condition (when two or more threads
    writing a shared resource.
    */
    private int i;

    public void doCountdown() {
        String color;

        switch(Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        for (i = 10; i > 0; --i) {
            System.out.println(color + Thread.currentThread().getName() + ": i= " + i);
        }
    }

}

class CountdownThread extends Thread {

    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown) {
        threadCountdown = countdown;
    }

    @Override
    public void run() {
        threadCountdown.doCountdown();
    }

}
