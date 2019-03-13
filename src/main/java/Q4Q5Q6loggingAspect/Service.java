package Q4Q5Q6loggingAspect;

public class Service {

    public void display()
    {
        System.out.println("Display method of Example Service");
    }

    public int getInteger(int demo)
    {
        System.out.println("Get integer method of getInteger of Service");
        return demo ;
    }
    public void throwException1() throws Exception {
        System.out.println("Exception1");
        throw new Exception();
    }
    public void throwException2() throws Exception {
        System.out.println("Exception2");
        throw new Exception();
    }
}
