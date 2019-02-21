package Q10CoffeeShop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char a;

        Order o=new Order();
        do{
            o.placeOrder();
            System.out.println("do you want to place more order?");
            Scanner sc=new Scanner(System.in);
            a=sc.next().charAt(0);
        }while (a=='y'||a=='Y');
        o.prepareOrder();
        o.orderReady();

    }
}
