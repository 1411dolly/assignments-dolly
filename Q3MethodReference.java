import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
//Q3 Using (instance) Method reference create and apply add and subtract method and using (Static) Method reference create and apply multiplication method for the functional interface created.
class MethodRreferenceExample {
    static int addno(int a, int b) {
        return a + b;
    }

    static int subno(int a, int b) {
        return a - b;
    }

}

public class Q3MethodReference {
    public static void main(String[] args) {
        //method reference using functional interface
        BiFunction<Integer, Integer, Integer> bi = MethodRreferenceExample::addno;
        System.out.println(bi.apply(4, 7));
        BiFunction<Integer, Integer, Integer> bi1 = MethodRreferenceExample::subno;
        System.out.println(bi.apply(4, 7));

        //method reference using instance::instanceMethod
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        MyComparator myComparator = new MyComparator();
        Collections.sort(list, myComparator::compare);
        list.forEach(e -> System.out.println(e));
        Collections.sort(list, (a, b) -> myComparator.compare(a, b));

        //method reference using className::instanceMethod
        final List<Person> people = Arrays.asList(new Person("dolly"), new Person("amarjeet"));
        people.forEach(Person::printName);
        people.forEach(person -> person.printName());
        for (final Person person : people) {
            person.printName();
        }
    }

}

class MyComparator {
    public int compare(final Integer a, final Integer b) {
        return a.compareTo(b);
    }
}

class Person {
    private String name;
    public Person(final String name) {
        this.name = name;
    }
    public void printName() {
        System.out.println(name);
    }
}