package lab14;
import java.util.concurrent.CopyOnWriteArrayList;

class ListWorker implements Runnable {
    private CopyOnWriteArrayList<String> list;

    public ListWorker(CopyOnWriteArrayList<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            list.add(Thread.currentThread().getName() + " - Item " + i);
            System.out.println(Thread.currentThread().getName() + " added Item " + i);
        }
    }
}
