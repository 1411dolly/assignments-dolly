package Q3customEvent;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//Q3    Create a CustomEvent which should get published when you invoke connect method of database bean.
@SpringBootConfiguration
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =new AnnotationConfigApplicationContext("Q3customEvent");
        ctx.start();
        DatabasePublisher customEventPublisher=ctx.getBean(DatabasePublisher.class);
        customEventPublisher.connect();
        ctx.stop();
    }
}
