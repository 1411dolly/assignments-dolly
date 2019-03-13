package Q4Q5Q6loggingAspect;

import org.aspectj.lang.annotation.*;

@Aspect
public class AspectExample {
    //Q4...Create a logging aspect. Create a pointcut to log all methods Of services .
    @Pointcut("execution(* Q4Q5Q6loggingAspect.Service.*(..))")
    private void selectAll(){ }

    //Q5...Add a logging statement before and after the method ends
    @Before("selectAll()")
    public void beforeAdvice(){
        System.out.println("Before PointCut");
    }
    @After("selectAll()")
    public void afterAdvice() {
        System.out.println("After PointCut\n");
    }

    //Q6...Log all the methods which throw IOException
    @AfterThrowing(pointcut = "execution(* Q4Q5Q6loggingAspect.Service.*(..))", throwing = "ex")
    public void logError(Exception ex) {
        ex.printStackTrace();
    }

}
