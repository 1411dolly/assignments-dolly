import java.util.concurrent.*;

public class Q5FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callable = () -> {
            Thread.sleep(1000L);
            return "Callable";
        };
        Future<String> future = executorService.submit(callable);

        executorService.shutdownNow();
//        Thread.sleep(3000L);

        if(future.isDone()) {
            String result = future.get();
            System.out.println(result);
        }
        else System.out.println("cancelled");

    }
}

