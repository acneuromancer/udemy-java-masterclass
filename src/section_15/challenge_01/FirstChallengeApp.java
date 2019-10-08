package section_15.challenge_01;

/*
We could have two people using a joint bank account at the same time. Create and start two threads that use the same
BankAccount instance and an initial balance of $1000.00. One will deposit $300.00 into the bank account, and then
withdraw $50.00. The other will deposit $203.75 and then withdraw $100.00.
*/

public class FirstChallengeApp {

    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345-67890", 1000.00);

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                account.deposit(300.00);
                account.withdraw(50.00);
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100.00);
            }
        };

        thread1.start();
        thread2.start();
    }

}
