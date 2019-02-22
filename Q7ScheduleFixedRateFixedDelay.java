import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Q7ScheduleFixedRateFixedDelay {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleWithFixedDelay(new Runnable() {
                                            @Override
                                            public void run() {
                                                try {
                                                    Thread.sleep(2000L);
                                                    System.out.println("Scheduled Task executed after fixed delay of 1");
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace();
                                                }

                                            }
                                        }, 0, 1, TimeUnit.SECONDS);

        executorService.scheduleAtFixedRate(new Runnable() {
                                         @Override
                                         public void run() {
                                             try {
                                                 Thread.sleep(2000L);
                                                 System.out.println("Scheduled task executed after fixed interval of 1");
                                             } catch (InterruptedException e) {
                                                 e.printStackTrace();
                                             }
                                         }
                                     }, 0, 3, TimeUnit.SECONDS);


    }
}
