package lab14;

import org.junit.jupiter.api.Test;
import java.util.concurrent.CopyOnWriteArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConcurrentDataStructuresDemoTest {

    @Test
    void testConcurrentListModification() throws InterruptedException {
        CopyOnWriteArrayList<String> sharedList = new CopyOnWriteArrayList<>();
        Thread t1 = new Thread(new ListWorker(sharedList));
        Thread t2 = new Thread(new ListWorker(sharedList));
        Thread t3 = new Thread(new ListWorker(sharedList));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        // Each thread adds 5 items, so the total should be 15
        assertEquals(15, sharedList.size(), "List size should be 15 after all threads execute");
    }
}
