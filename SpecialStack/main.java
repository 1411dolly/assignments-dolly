package SpecialStack;

import java.util.Scanner;

public class main {
    final static int MAX = 100;
    static int top = -1;
    static int stack[] = new int[MAX];
    static int specialStack[] = new int[MAX];
    static int min = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch;
        do {
            System.out.println("Operations");
            System.out.println("1.Push(only greater than 0)");
            System.out.println("2.Pop");
            System.out.println("3.FindMin");
            System.out.println("4.IsFull");
            System.out.println("5.IsEmpty");
            System.out.println("6.Print");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("enter element");
                    int ele = sc.nextInt();
                    push(ele);
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    try{findMin();}
                    catch (Exception e)
                    {
                        System.out.println("Not Empty");
                    }
                    break;
                case 4:
                    try{isFull();}
                    catch (Exception e)
                    {
                        System.out.println("Not full");
                    }
                    break;
                case 5:
                    isEmpty();
                    break;
                case 6:print();
                        break;
                default:
                    System.out.println("enter valid choice!!!");
            }
            System.out.println("do you want to continue?");
            ch = sc.next().charAt(0);
        } while (ch == 'y' || ch == 'Y');
    }

    public static void isFull()
    {
        if (top == MAX - 1)
            System.out.println("Stack Overflow");
        else
            System.out.println("Not full");
    }

    public static void isEmpty ()
    {

        if (top == -1)
            System.out.println("Stack Underflow");
        else
            System.out.println("Not Empty");

        }

    public static void push(int item) {
        if (top == MAX - 1)
            System.out.println("Stack Overflow");

        else {
            stack[++top] = item;
            if (top == 0) {
                min = item;
                specialStack[top] = item;
            }
            if (min < item)
                specialStack[top] = min;
            else {
                min = item;
                specialStack[top] = min;
            }
        }
        System.out.println("pushing " + item + " in stack !!!");
    }

    public static int pop() {
        int temp = 0, temp1 = 0;
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            temp = stack[top--];
        }
        System.out.println("popping " + temp + " from stack !!!");
        return temp;
    }

    public static int findMin() {
        if (top == -1)
            System.out.println("Stack empty");
        System.out.println("findmin::" + specialStack[top]);
        return specialStack[top];
    }

    public static void print()
    {
        System.out.println("Stack");
        if(top==-1)
            System.out.println("No element in array");
        else{
        for(int i=top;i>=0;i--)
            System.out.println(stack[i]);}
    }
}
