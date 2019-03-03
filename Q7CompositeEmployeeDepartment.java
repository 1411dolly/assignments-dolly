import java.util.ArrayList;
import java.util.List;

interface Directory
{
    void showDir();
}
class Employee implements Directory
{
    int id;
    String name;

    public Employee(int id, String name) {
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void showDir() {
        System.out.println( "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}');
    }
}
class Manager implements Directory
{
    int id;
    String section;

    public Manager(int id, String section) {
        this.id=id;
        this.section=section;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", section='" + section + '\'' +
                '}';
    }

    @Override
    public void showDir() {
        System.out.println( "Manager{" +
                "id=" + id +
                ", section='" + section + '\'' +
                '}');
    }
}
class CompanyDirectory implements Directory
{
    List<Directory> companyDir=new ArrayList<>();

    @Override
    public void showDir() {
        System.out.println("Company Directory");
        companyDir.forEach(e->e.showDir());
    }
}
class EmployeeDirectory implements Directory
{
    List<Employee> employeeDir=new ArrayList<>();

    @Override
    public void showDir() {
        System.out.println("Employee Directory");
        employeeDir.forEach(e->e.showDir());
    }
}
class ManagerDirectory implements Directory
{
    List<Manager> managerDir=new ArrayList<>();

    @Override
    public void showDir() {
        System.out.println("Manager Directory");
        managerDir.forEach(e->e.showDir());
    }
}
public class Q7CompositeEmployeeDepartment {
    public static void main(String[] args) {
        Employee emp1=new Employee(1,"Dolly");
        Employee emp2=new Employee(2,"Mohit");
        Manager manager1=new Manager(3,"finance");
        Manager manager2=new Manager(4,"section supervisor");

        ManagerDirectory managerDirectory=new ManagerDirectory();
        EmployeeDirectory employeeDirectory=new EmployeeDirectory();

        managerDirectory.managerDir.add(manager1);
        employeeDirectory.employeeDir.add(emp1);
        managerDirectory.managerDir.add(manager2);
        employeeDirectory.employeeDir.add(emp2);

        CompanyDirectory companyDirectory=new CompanyDirectory();
        companyDirectory.companyDir.add(managerDirectory);
        companyDirectory.companyDir.add(employeeDirectory);

        companyDirectory.showDir();
    }

}
