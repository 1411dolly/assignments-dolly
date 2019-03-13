package Q3customEvent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DatabaseListener implements ApplicationListener<DatabaseEvent> {
    @Override
    public void onApplicationEvent(DatabaseEvent event) {
        System.out.println("Databse Listener::"+event.getTimestamp());
    }
}
