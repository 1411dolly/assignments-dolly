import java.util.Comparator;
import java.util.Scanner;

public class Q2SortingString {
    public static void main(String[] args) {
        String original;
        System.out.println("enter String");
        Scanner sc=new Scanner(System.in);
        original=sc.next();

        int j = 0;
        char temp = 0;

        char[] chars = original.toCharArray();
//bubble sort
        for (int i = 0; i < chars.length; i++) {

            for (j = 0; j < chars.length; j++) {

                if (chars[j] > chars[i]) {
                    temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }

            }

        }

        for (int k = 0; k < chars.length; k++) {
            System.out.println(chars[k]);
        }

    }
}
