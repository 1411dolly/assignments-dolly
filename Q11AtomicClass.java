import java.util.concurrent.atomic.AtomicInteger;

public class Q11AtomicClass {

    AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {

        Q11AtomicClass atomicClass = new Q11AtomicClass();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicClass.worker1();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicClass.worker2();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(atomicClass.count);
    }


    public void worker1() {
        for (int i = 1; i <= 100; i++) {
            count.incrementAndGet();
        }
    }

    public void worker2() {
        for (int i = 1; i <= 100; i++) {
            count.incrementAndGet();
        }
    }

}
