package Q3customEvent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Component
public class DatabasePublisher implements ApplicationEventPublisherAware {
    ApplicationEventPublisher applicationEventPublisher;

    void connect() {
        DatabaseEvent customEvent = new DatabaseEvent(this);
        applicationEventPublisher.publishEvent(customEvent);
        System.out.println("Connecting to Database.....");
    }
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
