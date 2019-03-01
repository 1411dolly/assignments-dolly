//Q6Create and access default and static method of an interface.
//Q7Override the default method of the interface.
interface Q6InterfaceExample
{
    default void method1()
    {
        System.out.println("default method 1");
    }

    static void method2()
    {
        System.out.println("static method 2");
    }
}
public class Q6Q7Example implements Q6InterfaceExample{
    public static void main(String[] args) {
        Q6InterfaceExample.method2();
        Q6Q7Example example=new Q6Q7Example();
        example.method1();

    }

    public void method1()
    {
        System.out.println("override deafult method 1");
    }
}
