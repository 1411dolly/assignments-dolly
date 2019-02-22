import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Q7ScheduleTask {

    public static void main(String[] args)   {

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        executorService
                .schedule(new Runnable() {
                              @Override
                              public void run() {
                                  System.out.println("Task executed after 5 second");
                              }
                          },
                        5,
                        TimeUnit.SECONDS);

        executorService.shutdown();

    }
}

