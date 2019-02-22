import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Q15Deadlock {

    Lock lock1 = new ReentrantLock(true);
    Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) throws InterruptedException {
        Q15Deadlock re = new Q15Deadlock();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                re.worker1();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                re.worker2();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    public void worker1() {
        lock1.lock();
        System.out.println("lock 1 worker 1");
        lock2.lock();
        System.out.println("lock 2 worker 1");
        lock2.unlock();
        lock1.unlock();
    }

    public void worker2() {
        lock2.lock();
        System.out.println("lock 1 worker 2");
        lock1.lock();
        System.out.println("lock 2 worker 2");
        lock2.unlock();
        lock1.unlock();
    }
}
