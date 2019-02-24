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
                    findMin();
                    break;
                default:
                    System.out.println("enter valid choice!!!");
            }
            System.out.println("do you want to continue?");
            ch = sc.next().charAt(0);
        } while (ch == 'y' || ch == 'Y');
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
        System.out.println("pushing" + item + "in stack !!!");
    }

    public static int pop() {
        int temp = 0, temp1 = 0;
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            temp = stack[top--];
        }
        System.out.println("popping" + temp + "from stack !!!");
        return temp;
    }

    public static int findMin() {
        if (top == -1)
            System.out.println("Stack empty");
        System.out.println("findmin::" + specialStack[top]);
        return specialStack[top];
    }
}
