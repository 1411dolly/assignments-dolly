import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Process implements Runnable {
    int id;

    public Process(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Thread name::" + Thread.currentThread().getName() + " Start :" + id);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread name::" + Thread.currentThread().getName() + " End :" + id);
    }
}

public class Q8CachedandFixedThreadPool {
    public static void main(String[] args) {

//        ExecutorService fixedexecutorService= Executors.newFixedThreadPool(3);
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("FIXED THREAD POOL");
//        for (int i = 0; i <= 10; i++) {
//            fixedexecutorService.submit(new Process(i));
//        }
        System.out.println("CACHED THREAD POOL");
        for (int i = 0; i <= 10; i++) {
            executorService.submit(new Process(i));
        }
//        fixedexecutorService.shutdown();
        executorService.shutdown();
    }
}
