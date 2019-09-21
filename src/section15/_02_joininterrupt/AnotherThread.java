package section15._02_joininterrupt;

public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello from " + currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Hello from the AnotherThread, another thread woke me up.");
            return;
        }

        System.out.println("Hello from the AnotherThread, three seconds have passed and I'm awake.");
    }

}
