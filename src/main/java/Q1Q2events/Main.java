package Q1Q2events;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


//Q1    Invoke context Q1Q2events start(), stop() and close().
//Q2    Create listeners for spring Q1Q2events.
@SpringBootConfiguration
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =new AnnotationConfigApplicationContext("Q1Q2events");
        ctx.start();
        ExampleEvent ex=(ExampleEvent) ctx.getBean(ExampleEvent.class);
        ex.display();
        ctx.stop();
        ctx.close();
    }
}
