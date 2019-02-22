import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q3SingleThreadExecutor {

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
                    System.out.println("Thread 3");
                }
            });
        } finally {
            executorService.shutdown();
        }

    }
}
