package section_15_concurrency.challenge_01;

public class FirstChallengeApp2 {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("12345-67890", 1000.00);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(300.00);
                bankAccount.withdraw(50.00);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(203.75);
                bankAccount.withdraw(100.00);
            }
        });

        thread1.start();
        thread2.start();
    }

}
