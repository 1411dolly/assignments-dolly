package Q10CoffeeShop;
import java.util.Scanner;

public class Order implements CoffeeShop {
    static int MAX=10,top=0,order_id=1;
    int order_queue[]=new int[MAX];
    int ready_queue[]=new int[MAX];;

    @Override
    public int placeOrder() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Pay your Bill");
        float amount=sc.nextFloat();
        if(amount>=0)
        {
            System.out.println("Please wait while your order::"+order_id+" is being prepared....");
            order_queue[top++]=order_id++;
            return order_id;
        }
        else {System.out.println("Sorry!!! try again.");
        return 0;}
    }

    @Override
    public void prepareOrder() {
        if(order_queue.length>0) {
            for(int i=0;i<order_queue.length;i++) {
                if(order_queue[i]==0) {
                    break;
                } else {
                    System.out.println("Order id " + order_queue[i] + " is being prepared");
                    ready_queue[i] = order_queue[i];
                }
            }
            order_queue=null;
        }
    }

    @Override
    public void orderReady() {
        if(ready_queue.length>0) {
            for(int i=0;i<ready_queue.length;i++) {
                if(ready_queue[i]==0) {
                    break;
                } else {
                    System.out.println("Order id " + ready_queue[i] + " is ready.Enjoy!!!");
                }
            }
            ready_queue=null;
        }
    }
}
