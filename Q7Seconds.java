import java.util.Scanner;

public class Q7Seconds {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter seconds");
        int n=sc.nextInt();
        int day = n / (24 * 3600);
        n = n % (24 * 3600);
        int hour = n / 3600;
        n %= 3600;
        int minutes = n / 60 ;
        n %= 60;
        int seconds = n;
        System.out.println("Days::"+day+"\tHours::"+hour+"\tMinutes::"+minutes+"\tSeconds::"+seconds);
    }
}
