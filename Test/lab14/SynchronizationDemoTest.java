package lab14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SynchronizationDemoTest {

    @Test
    void testCounterSynchronization() throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new CounterThread(counter);
        Thread t2 = new CounterThread(counter);
        Thread t3 = new CounterThread(counter);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        assertEquals(300, counter.getCount(), "Counter value should be 300");
    }
}
