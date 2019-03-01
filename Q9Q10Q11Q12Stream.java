import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//Q9Collect all the even numbers from an integer list.
//Q10Sum all the numbers greater than 5 in the integer list.
//Q11Find average of the number inside integer list after doubling it.
//Q12Find the first even number in the integer list which is greater than 3.
public class Q9Q10Q11Q12Stream {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(2,7,12,78,34,2,35,3,4,5,7,56,7,32,3,45,45,4,67,76,5,63);
        list.stream().filter(e->e%2==0).collect(Collectors.toList()).forEach(e-> System.out.println(e));
        System.out.println("Sum::"+list.stream().filter(e->e>5).mapToInt(i->i.intValue()).sum());
        System.out.println("Average after double::"+list.stream().mapToInt(e->e*2).average().getAsDouble());
        System.out.println("First even number greater than 3::"+list.stream().filter(e->e%2==0).filter(e->e>3).findFirst().get());
    }
}
