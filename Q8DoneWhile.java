import java.util.Scanner;
public class Q8DoneWhile {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a word");
        String word = keyboard.next();
        while(!word.equals("done"))
        {
            if(word.charAt(0) == word.charAt(word.length() - 1))
            {
                System.out.println("First and last character are equals :: " + word);
            }
            else
            {
                System.out.println("First and last character are NOT equals :: " + word);
            }
            word = keyboard.next();
        }
    }
}
