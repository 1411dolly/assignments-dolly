public class Q12WaitandNotify {

    public static void main(String[] args) {
        Q12WaitandNotify waitandNotify = new Q12WaitandNotify();
        new Thread(new Runnable() {
            @Override
            public void run() {
                waitandNotify.worker1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                waitandNotify.worker2();
            }
        }).start();
    }

    public void worker1() {
        synchronized (this) {
            System.out.println("Worker1 Started");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Worker1 Done");
        }
    }

    public void worker2() {
        synchronized (this) {
            System.out.println("Worker2 Started");
            System.out.println("Worker2 Done");
            notify();
        }
    }
}
