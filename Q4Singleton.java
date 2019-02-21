class Singleton
{
    private static Singleton single_instance = null;
    public String s;
    private Singleton()
    {
        s = "Singleton class";
    }
    public static Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();

        return single_instance;
    }
}
public class Q4Singleton {
    public static void main(String[] args) {
        Singleton x = Singleton.getInstance();
        Singleton y = Singleton.getInstance();
        Singleton z = Singleton.getInstance();
        x.s = (x.s).toUpperCase();
        System.out.println("x:" + x.s);
        System.out.println("y:" + y.s);
        System.out.println("z:" + z.s);
        System.out.println("\n");
        z.s = (z.s).toLowerCase();
        System.out.println("x:" + x.s);
        System.out.println("y:" + y.s);
        System.out.println("z:" + z.s);
    }

}
