abstract class Car
{
    String carType;
    String location;

    public Car(String carType, String location) {
        this.carType = carType;
        this.location = location;
    }


    abstract void design();

    @Override
    public String toString() {
        return "car{" +
                "carType='" + carType + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
class SuperCar extends Car
{

    public SuperCar(String location) {
        super("SuperCar",location);
    }

    @Override
    void design() {
        System.out.println("designing super car");
    }
}

class Luxurycar extends Car
{

    public Luxurycar(String location) {
        super("LuxuryCar", location);
    }

    @Override
    void design() {
        System.out.println("designing luxury car");
    }
}

class FactoryOfIndia
{
    static Car buildCar(String carType)
    {
        Car car=null;
        switch (carType)
        {
            case "SuperCar" : car=new SuperCar("India"); break;
            case "LuxuryCar" : car=new Luxurycar("India");  break;
            default:
                System.out.println("factory of india error");
        }
        return car;
    }
}

class FactoryOfChina
{
    static Car buildCar(String carType)
    {
        Car car=null;
        switch (carType)
        {
            case "SuperCar" : car=new SuperCar("China"); break;
            case "LuxuryCar" : car=new Luxurycar("China"); break;
        }
        return car;
    }
}
class CarFactory
{
    static Car buildCar(String cartype,String location)
    {
        Car car=null;
        switch (location)
        {
            case "India" : car=FactoryOfIndia.buildCar(cartype);  break;
            case "China" : car=FactoryOfChina.buildCar(cartype);  break;
        }
        return car;
    }
}
public class Q3AbstractFactoryCar {
    public static void main(String[] args) {
        Car car=CarFactory.buildCar("SuperCar","India");
        car.design();
        System.out.println(CarFactory.buildCar("LuxuryCar","India"));
        System.out.println(CarFactory.buildCar("SuperCar","China"));
        System.out.println(CarFactory.buildCar("LuxuryCar","China"));
    }
}
