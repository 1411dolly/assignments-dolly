package Q1LibraryManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char choice;
        ManageBook mb=new ManageBook();
        do {
            System.out.println("1.issue book");
            System.out.println("2.return book");
            System.out.println("Enter choice(1/2)");
            int ch=sc.nextInt();
            if(ch==1)
            {
                System.out.println("enter book id to be issued");
                int book_id = sc.nextInt();
                mb.issueBook(book_id);
            }
            else {
                System.out.println("enter book id to be issued");
                int book_id = sc.nextInt();
                mb.returnBook(book_id);
            }
            System.out.println("do you want to continue?");
            choice=sc.next().charAt(0);
        }while (choice=='y'||choice=='Y');
    }
}
