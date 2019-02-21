package Q1LibraryManagement;

import java.util.Scanner;

public class ManageBook implements LibraryManagement {

    int book[]=new int[500];
    Scanner sc=new Scanner(System.in);
    @Override
    public void issueBook(int bookid) {

        if(book[bookid]==0)
        {
            System.out.println("Enter student id book to be issued::");
            int stu_id=sc.nextInt();
            book[bookid]=stu_id;

        }
        else System.out.println("book already issued!!! sorry");
    }

    @Override
    public void returnBook(int bookid) {
        book[bookid]=0;
        System.out.println("book returned");
    }

}
