package lab14;
import java.util.concurrent.atomic.AtomicInteger;

class BankAccount {
    private AtomicInteger balance = new AtomicInteger(0);

    public void deposit(int amount) {
        balance.addAndGet(amount);
        System.out.println(Thread.currentThread().getName() + " deposited: " + amount + ", Balance: " + balance.get());
    }

    public void withdraw(int amount) {
        if (balance.get() >= amount) {
            balance.addAndGet(-amount);
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount + ", Balance: " + balance.get());
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw: " + amount + " but insufficient balance!");
        }
    }

    public int getBalance() {
        return balance.get();
    }
}

class ClientThread extends Thread {
    private BankAccount account;

    public ClientThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int amount = (int) (Math.random() * 100) + 1;
            if (Math.random() > 0.5) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }
        }
    }
}
