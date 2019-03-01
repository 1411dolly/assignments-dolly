//Create an Employee Class with instance variables (String) name, (Integer)age, (String)city and get the instance of the Class using constructor reference
interface EmployeeInterface
{
    Employee getEmployee(String name,Integer age,String city);
}
class Employee {
    String name;
    Integer age;
    String city;

    public Employee(String name, Integer age, String city)
    {
        this.name=name;
        this.age=age;
        this.city=city;
        System.out.println("Name:"+this.name+" Age:"+this.age+" City:"+this.city);
    }
}
public class Q4Employee
{
    public static void main(String[] args) {
        EmployeeInterface employeeInterface=Employee::new;
        employeeInterface.getEmployee("Dolly",23,"Delhi");

    }
}
