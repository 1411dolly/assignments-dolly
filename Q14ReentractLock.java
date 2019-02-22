import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Q14ReentractLock {

    Lock lock = new ReentrantLock(true);
    int count;

    void increment(){
        lock.lock();
        count++;
        lock.unlock();
    }

    public void worker1(){
        for (int i = 1; i <= 100; i++) {
            increment();
        }
    }

    public void worker2(){
        for (int i = 1; i <= 100; i++) {
            increment();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Q14ReentractLock demo = new Q14ReentractLock();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.worker1();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.worker2();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(demo.count);
    }
}

