package Q8Q9PointCutReuse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@org.aspectj.lang.annotation.Aspect
public class Aspect {
    //Q8...Demonstrate the use of pointCut @Pointcut annotation and Reuse the expression created
    @Before("displayPointcut() || getStringPointcut()")
    void beforeAdvice() {
        System.out.println("Running before advice");
    }

    @After("displayPointcut()")
    void afterAdvice(){
        System.out.println("Running after advice\n");
    }

    @Pointcut("execution(void display())")
    void displayPointcut(){}

    @Pointcut("execution(String getString())")
    void getStringPointcut(){}

    //Q9...Access the properties of the JoinPoint in before advice.
    // Print Signature of method being called and its arguments
    @Before("execution(int getInteger(int))")
    void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Running before advice");
        System.out.println("joinPoint::"+joinPoint);
        System.out.println("class::"+joinPoint.getThis());
        System.out.println("signature::"+joinPoint.getSignature());
        System.out.println("Args are:");
        Object [] objects=joinPoint.getArgs();
        for (Object object:objects){
            System.out.println(object);
        }
    }


}
