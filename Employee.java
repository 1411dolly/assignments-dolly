public class Employee  {
    Double Age;
    Double Salary;
    String Name;

    public Employee(double i, double j, String k) {
        Age = i;
        Salary = j;
        Name = k;
    }


    public Double getAge() {
        return Age;
    }

    public void setAge(Double age) {
        Age = age;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String toString() {
        return "name:" + getName() + "\tage:" + getAge() + "\tsalary:" + getSalary();
    }
}



