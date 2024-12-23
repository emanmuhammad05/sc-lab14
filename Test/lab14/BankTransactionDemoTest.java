package lab14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BankTransactionDemoTest {

    @Test
    void testBankAccountThreadSafety() throws InterruptedException {
        BankAccount account = new BankAccount();

        Thread t1 = new ClientThread(account);
        Thread t2 = new ClientThread(account);
        Thread t3 = new ClientThread(account);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        // Verify the balance is non-negative
        assertTrue(account.getBalance() >= 0, "Final account balance should be non-negative");
    }
}
