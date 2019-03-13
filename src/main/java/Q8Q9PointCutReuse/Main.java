package Q8Q9PointCutReuse;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//Q8...Demonstrate the use of pointCut @Pointcut annotation and Reuse the expression created
//Q9...Access the properties of the JoinPoint in before advice. Print Signature of method being called and its arguments
public class Main {
    public static void main(String[] args){
        ConfigurableApplicationContext ctx =new ClassPathXmlApplicationContext("aspect.xml");
        Q8Q9PointCutReuse.Service s=ctx.getBean(Q8Q9PointCutReuse.Service.class);
        s.display();
        s.getString();
        s.getInteger(1000);
    }

}
