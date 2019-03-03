interface Pizza
{
    String getdesc();
    float getprice();
}
class VegPizza implements Pizza
{

    @Override
    public String getdesc() {
        return "VEG PIZZA";
    }

    @Override
    public float getprice() {
        return 250f;
    }
}

class NonVegPizza implements Pizza
{

    @Override
    public String getdesc() {
        return "NON VEG PIZZA";
    }

    @Override
    public float getprice() {
        return 500f;
    }
}

 abstract class PizzaTopping implements Pizza
{

    Pizza pizza;

    public PizzaTopping(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getdesc() {
        return "Toppings";
    }

    @Override
    public float getprice() {
        return pizza.getprice();
    }
}

class Cheese extends PizzaTopping
{

    public Cheese(Pizza pizza) {
        super(pizza);
    }

    public String getdesc()
    {
        return pizza.getdesc()+" Cheese Topping";
    }
    @Override
    public float getprice() {
        return pizza.getprice()+100f;
    }
}


class Olive extends PizzaTopping
{

    public Olive(Pizza pizza) {
        super(pizza);
    }

    public String getdesc()
    {
        return pizza.getdesc()+" Olive Topping";
    }
    @Override
    public float getprice() {
        return pizza.getprice()+50f;
    }
}
public class Q6DecoratorPizzaTopping {
    public static void main(String[] args) {
        Pizza p=new Olive(new VegPizza());
        System.out.println(p.getdesc());
        System.out.println(p.getprice());
        Pizza p2=new Cheese(new NonVegPizza());
        System.out.println(p2.getdesc());
        System.out.println(p2.getprice());
    }
}
