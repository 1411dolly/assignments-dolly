public class OverloadingEx {

    public int add(int a,int b) { return a+b; }

    public float add(int a,float b)
    {
        return a+b;
    }

    public int add(int a,int b,int c) { return a+b+c; }
    public double add(int a,double b)
    {
        return a+b;
    }
    public double add(double a,double b)
    {
        return a+b;
    }
    public float multiply(float a,float b)
    {
        return a*b;
    }
    public int multiply(int a ,int b)
    {
        return a*b;
    }
    public String concatString(String a,String b)
    {
        System.out.println("concat");
        return a.concat(b);
    }

    public String concat3string(String a,String b,String c)
    {
        return a.concat(b).concat(c);
    }
}
