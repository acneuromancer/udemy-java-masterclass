package section_15_concurrency._10_arrayblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

import static section_15_concurrency._10_arrayblockingqueue.Main.EOF;

public class MyConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }

                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting...");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {
                    System.out.println("Consumer was interrupted.");
                }
            }
        }
    }
}
