import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q4ShutDownNow {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread 1");
                }
            });
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread 2");
                }
            });
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(4000L);
                        System.out.println("Thread 3");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        } finally {
            executorService.shutdownNow();
        }

        System.out.println(executorService.isShutdown());
        System.out.println(executorService.isTerminated());
    }
}
