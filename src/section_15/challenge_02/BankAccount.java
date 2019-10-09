package section_15.challenge_02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private String accountNumber;
    private double balance;
    private Lock lock;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.lock = new ReentrantLock();
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            System.out.println(amount + " deposited.");
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            System.out.println(amount + " withdrawn.");
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number = " + accountNumber);
    }

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
