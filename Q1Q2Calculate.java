import java.util.function.BiFunction;

//Write the following a functional interface and implement it using lambda:
//        (1) First number is greater than second number or not             Parameter (int ,int ) Return boolean
//        (2) Increment the number by 1 and return incremented value    Parameter (int) Return int
//        (3) Concatination of 2 string                                                             Parameter (String , String ) Return (String)
//        (4) Convert a string to uppercase and return .                                Parameter (String) Return (String)
interface Calculation {
    boolean isgreater(int a,int b);
}
interface Increment{
    int increment(int a);
}
interface ConcatSttring{
    String conString(String a,String b);
}
interface Toupper{
    String toupperstring(String a);
}
interface Add{
    Integer add(Integer a,Integer b);
}

public class Q1Q2Calculate {
    public static void main(String[] args) {

        Calculation c = (a, b) -> { return  a > b? true :  false; };
        c.isgreater(5, 6);

        Increment i = (a) -> a += 1;
        System.out.println(i.increment(4));

        ConcatSttring concat = (a, b) -> a.concat(b);
        System.out.println(concat.conString("dolly", "thakur"));

        Toupper t = (a) -> a.toUpperCase();
        System.out.println(t.toupperstring("dolly"));

//Q2        Create a functional interface whose method takes 2 integers and return one integer.
        BiFunction<Integer,Integer,Integer> biFunction=(a,b)->a+b;
        System.out.println(biFunction.apply(5,9));

        Add addno=(a,b)->a+b;
        System.out.println(addno.add(4,6));
    }
}
