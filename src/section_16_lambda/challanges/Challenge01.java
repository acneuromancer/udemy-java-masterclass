package section_16_lambda.challanges;

public class Challenge01 {

    public static void main(String[] args) {

        // Exercise: convert this anonymous class to a lambda
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        Runnable runnableLambda = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        Thread t = new Thread(runnableLambda);
        t.start();

    }

}
