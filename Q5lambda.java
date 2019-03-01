import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
//Q5Implement following functional interfaces from java.util.function using lambdas:
//
//        (1) Consumer
//
//        (2) Supplier
//
//        (3) Predicate
//
//        (4) Function
public class Q5lambda {
    public static void main(String[] args) {
        Consumer<String> con=s-> System.out.println(s);
        con.accept("Dolly");

        Supplier<String> sup=()-> new String("hello world");
        System.out.println(sup.get());

        Predicate<Integer> pre=(s)->{ return s>5?true:false; };
        System.out.println(pre.test(10));

        Function<Integer,String> func=(a)-> String.valueOf(a);
        System.out.println(func.apply(0));
    }
}
