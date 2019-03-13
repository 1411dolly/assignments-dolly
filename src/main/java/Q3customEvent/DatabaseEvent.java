package Q3customEvent;

import org.springframework.context.ApplicationEvent;


public class DatabaseEvent extends ApplicationEvent {
    public DatabaseEvent(Object source) {
        super(source);
        System.out.println("Database Event timestamp::"+getTimestamp());
    }
}
