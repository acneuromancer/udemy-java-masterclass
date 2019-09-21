package section15._02_joininterrupt;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello from the main thread.");

        final Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println("Hello from the anonymous class's implementation of run().");
                try {
                    anotherThread.join();
                    // anotherThread.join(1000);
                    System.out.println("Hello from the anonymous class, anotherThread terminated, or timed out, so I'm running again.");
                } catch (InterruptedException e) {
                    System.out.println("Hello from the anonymous class, I couldn't wait after all. I was interrupted.");
                }
            }
        });
        myRunnableThread.start();
        anotherThread.interrupt();

        System.out.println("Hello again from the main thread.");
    }

}
