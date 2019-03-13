package Q4Q5Q6loggingAspect;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//Q4...Create a logging aspect. Create a pointcut to log all methods Of services .
//Q5...Add a logging statement before and after the method ends
//Q6...Log all the methods which throw IOException
public class Main {
    public static void main(String[] args){
        ConfigurableApplicationContext ctx =new ClassPathXmlApplicationContext("aspect.xml");
        Service s=ctx.getBean(Service.class);
        s.display();
        try {
            s.throwException1();
        } catch (Exception e) {
            System.out.println("Exception caused due to Exception1\n");
        }
        try {
            s.throwException2();
        } catch (Exception e) {
            System.out.println("Exception caused due to Exception2\n");
        }
        s.getInteger(2);
    }

}
