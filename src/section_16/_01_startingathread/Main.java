package section_16._01_startingathread;

import org.w3c.dom.ls.LSOutput;

public class Main {

    public static void main(String[] args) {
        // Start a thread with the CodeToRun class
        new Thread(new CodeToRun()).start();

        // Start a thread with an anonymous class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing from the anonymous class.");
            }
        }).start();

        // Start a thread using a lambda.
        new Thread(() -> System.out.println("Printing from the lambda.")).start();

        new Thread(() -> {
            System.out.println("Printing from the lambda.");
            System.out.println("Line 2");
            System.out.format("This is line %d", 3);
        }).start();
    }

}

class CodeToRun implements Runnable {

    @Override
    public void run() {
        System.out.println("Printing from the CodeToRun class.");
    }

}