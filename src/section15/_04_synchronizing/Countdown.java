package section15._04_synchronizing;

public class Countdown {

    private int i;

    // public synchronized void doCountdown() {...}

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

        synchronized(this) {
            for (i = 100; i > 0; --i) {
                // System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
                System.out.println(Thread.currentThread().getName() + ": i = " + i);
            }
        }
    }

}
