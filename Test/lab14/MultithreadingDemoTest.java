package lab14;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MultithreadingDemoTest {

    @Test
    void testNumberAndSquareThreads() throws InterruptedException {
        // Redirect console output to capture it
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Thread thread1 = new NumberThread();
        Thread thread2 = new SquareThread();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        String output = outputStream.toString();

        // Check output contains numbers and their squares
        for (int i = 1; i <= 10; i++) {
            assertTrue(output.contains("Number: " + i));
            assertTrue(output.contains("Square: " + (i * i)));
        }
    }
}
