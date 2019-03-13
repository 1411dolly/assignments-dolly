package Q7PointCutExpression;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

@org.aspectj.lang.annotation.Aspect
public class Aspect {
    //Q7...Apply execution, within, args, this and bean expressions on the before and after advice of service bean.
    @Before("execution(void display())")
    void beforeAdvice() {
        System.out.println("before advice");
    }
    @After("execution(void display())")
    void afterAdvice() {
        System.out.println("after advice");
    }

    @Before("within(Q7PointCutExpression.*)")
    void beforewithinAdvice() {
        System.out.println("within before advice");
    }
    @After("within(Q7PointCutExpression.*)")
    void AfterwithinAdvice() {
        System.out.println("within after advice");
    }

    @Before("bean(service))")
    void beforeBeanAdvice() {
        System.out.println("Bean before advice");
    }
    @After("bean(service))")
    void afterBeanAdvice() {
        System.out.println("Bean after advice");
    }

    @Before("args(Integer)")
    void beforeArgsAdvice() {
        System.out.println("Agrs before advice");
    }
    @After("args(Integer)")
    void afterArgsAdvice() {
        System.out.println("Args before advice");
    }

    @Before("this(Q7PointCutExpression.Service)")
    void beforeThisAdvice() {
        System.out.println("This before advice");
    }
    @After("this(Q7PointCutExpression.Service)")
    void afterThisAdvice() {
        System.out.println("This after advice\n");
    }

}
