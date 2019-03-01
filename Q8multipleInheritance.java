//Q8Implement multiple inheritance with default method inside  interface.
interface Example1
{
//    void method1();
    default void method2()
    {
        System.out.println("Example1 default method 2");
    }
}
interface Example2
{
//    void method1();
    default void method2()
    {
        System.out.println("Example2 default method 2");
    }
    default void method3()
    {
        System.out.println("Example2 default method 3");
    }
}
public class Q8multipleInheritance implements Example1,Example2  {
    public static void main(String[] args) {
        Q8multipleInheritance multipleInheritance=new Q8multipleInheritance();
        multipleInheritance.method2();
        multipleInheritance.method3();

    }

    @Override
    public void method2() {
//        System.out.println("Explicit definition of method2");
            Example1.super.method2();
            Example2.super.method2();
    }
}
