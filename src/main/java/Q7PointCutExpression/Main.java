package Q7PointCutExpression;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//Q7...Apply execution, within, args, this and bean expressions on the before and after advice of service bean.
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =new ClassPathXmlApplicationContext("aspect.xml");
        Service service=ctx.getBean(Service.class);
        service.display();
        service.getInteger(10);
    }
}
