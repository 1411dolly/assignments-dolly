import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        //Q1Write Java code to define List . Insert 5 floating point numbers in List, and using an iterator, find the sum of the numbers in List.
        List<Float> list = new ArrayList<>();
        list.add(12.78f);
        list.add(78.12f);
        list.add(90.21f);
        list.add(45.21f);
        list.add(473.56f);
        sumFLoat(list);

        //Q2Write a method that takes a string and returns the number of unique characters in the string.
        String s = "hello world great day ahead";
        characterCount(s);
        System.out.println(s.chars().distinct().count());

        //Q3Write a method that takes a string and print the number of occurrence of each character characters in the string.
        ocuurenceCount(s);

        //Q4Write a program to sort Employee objects based on highest salary using Comparator. Employee class{ Double Age; Double Salary; String Name}
        Employee e1 = new Employee(12, 323, "dolly");
        Employee e2 = new Employee(22, 213, "amarjeet");
        Employee e3 = new Employee(32, 100, "buddy");
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(e2);
        employees.add(e3);
        employees.add(e1);
        System.out.println(employees);
        Collections.sort(employees, new SalaryComparator());
        System.out.println(employees);

        //Q5Write a program to sort the Student objects based on Score , if the score are same then sort on First Name . Class Student{ String Name; Double Score; Double Age}
        Student s1 = new Student("Dolly", 90, 18);
        Student s2 = new Student("Amarjeet", 90, 15);
        Student s3 = new Student("Buddy", 90, 18);
        List<Student> student = new ArrayList<>();
        student.add(s1);
        student.add(s2);
        student.add(s3);
        System.out.println(student);
        Collections.sort(student, new ScoreComparator().thenComparing(new NameComparator()));
        System.out.println(student);

        //Q6Print the elements of an array in the decreasing frequency if 2 numbers have same frequency then print the one which came first.
        int input[] = {3, 5, 2, 3};
        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        for (int i = 0; i < input.length; i++) {
            if (null != map.get(input[i])) {
                int k = map.get(input[i]) + 1;
                map.put(input[i], k);
            } else {
                map.put(input[i], 1);
            }
        }
        System.out.println(map);

        //Q7Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. (Expected complexity ­ O(1))
        //ATTACHED AS SPECIALSTACK

        //Q8Write a program to format date as example "21-March-2016"
        SimpleDateFormat format = new SimpleDateFormat("dd-MMMMM-yyyy");
        Date date = new Date();
        System.out.println(format.format(date));

        //Q9Write a program to display times in different country format.
        Date d1 = new Date();
        System.out.println("Today is " + d1.toString());
        Locale locItalian = new Locale("it", "ch");
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locItalian);
        System.out.println("today is in Italian Language in Switzerland Format : " + df.format(d1));

    }

    public static void sumFLoat(List<Float> list) {
        Iterator<Float> itr = list.iterator();
        float i, sum = 0;
        while (itr.hasNext()) {
            i = itr.next();
            sum += i;
        }
        System.out.println("Sum::" + sum);
    }

    public static void characterCount(String s) {
        String buffer = "";
        for (int i = 0; i < s.length(); i++) {
            if (buffer.indexOf(s.charAt(i)) == -1)
                buffer += s.charAt(i);

        }
        System.out.println(buffer);
        System.out.println(buffer.length());
    }

    public static void ocuurenceCount(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            if (count.containsKey(c))
                count.put(c, count.get(c) + 1);
            else
                count.put(c, 1);
        }
        for (Map.Entry entry : count.entrySet()) {
            System.out.println(entry.getKey() + "::" + entry.getValue());
        }
    }

}
