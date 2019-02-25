package SpecialStack;

import java.util.*;

public class SpecialStackMap {
    static Map<Integer, Integer> SpecialStack = new LinkedHashMap<>();
    static int min;
    static int MAX = 5, size = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch;
        do {
            System.out.println("Operations");
            System.out.println("1.Push");
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
                    findmin();
                    break;
                case 4:
                    isFull();
                    break;
                case 5:
                    isEmpty();
                    break;
                case 6:
                    print();
                    break;
                default:
                    System.out.println("enter valid choice!!!");
            }
            System.out.println("do you want to continue?");
            ch = sc.next().charAt(0);
        } while (ch == 'y' || ch == 'Y');
    }

    public static void push(int ele) {
        if (SpecialStack.size() > MAX)
            System.out.println("Stack full!!!");
        else {
            if (SpecialStack.isEmpty()) {
                min = ele;
                SpecialStack.put(ele, ele);
                size++;
            }
            if (min < ele) {
                SpecialStack.put(ele, min);
                size++;
            } else {
                SpecialStack.put(ele, ele);
                min = ele;
                size++;
            }
        }
    }

    public static void pop() {
        if (SpecialStack.isEmpty())
            System.out.println("Stack empty!!!");
        else {
            Set set = SpecialStack.entrySet();
            Iterator i = set.iterator();
            int j = 0;
            while (i.hasNext()) {
                Map.Entry me = (Map.Entry) i.next();
                if (!i.hasNext()) {
                    j = (int) me.getKey();
                    System.out.print(me.getKey() + " removed!!!");
                }
            }
            SpecialStack.remove(j);
            size--;
        }
    }

    public static void findmin() {
        if (SpecialStack.isEmpty())
            System.out.println("Stack empty!!!");
        else {
            Set set = SpecialStack.entrySet();
            Iterator i = set.iterator();
            int j = 0;
            while (i.hasNext()) {
                Map.Entry me = (Map.Entry) i.next();
                if (!i.hasNext()) {
                    System.out.println("Minimum element::"+me.getValue());
                }
            }
        }
    }

    public static void isEmpty() {
        if (SpecialStack.isEmpty())
            System.out.println("Stack empty!!!");
        else System.out.println("Stack not empty!!!");
    }

    public static void isFull() {
        if (SpecialStack.size() >= MAX)
            System.out.println("Stack full!!!");
        else System.out.println("Stack not full!!!");

    }

    public static void print()
    {
        if (SpecialStack.isEmpty())
            System.out.println("Stack empty!!!");
        Set set = SpecialStack.entrySet();
        Iterator i = set.iterator();
        int j = 0;
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.println(me.getKey());
        }
    }
}
