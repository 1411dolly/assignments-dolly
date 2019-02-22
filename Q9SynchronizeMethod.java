public class Q9SynchronizeMethod {

    int count;

    public static void main(String[] args) throws InterruptedException {

        Q9SynchronizeMethod synchronizeDemo = new Q9SynchronizeMethod();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizeDemo.worker1();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizeDemo.worker2();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(synchronizeDemo.count);
    }

    synchronized public void incrementCount() {
        count++;
    }

    public void worker1() {
        for (int i = 1; i <= 100; i++) {
            incrementCount();
        }
    }

    public void worker2() {
        for (int i = 1; i <= 100; i++) {
            incrementCount();
        }
    }
}

