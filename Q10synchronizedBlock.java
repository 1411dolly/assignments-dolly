public class Q10synchronizedBlock {

    int count;

    public static void main(String[] args) throws InterruptedException {

        Q10synchronizedBlock synchronizeDemo = new Q10synchronizedBlock();
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

     public void incrementCount() {
        synchronized (this)
        {
        count++;}
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

