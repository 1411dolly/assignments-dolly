class Department
{
    private int id;
    private String name;

    public Department(int id, String name)
    {
        this.id = id;
        this.name = name;
    }


}
class Employee implements Cloneable{
    private int empoyeeId;
    private String employeeName;
    private Department department;
    public Employee(int id, String name, Department dept)
    {
        this.empoyeeId = id;
        this.employeeName = name;
        this.department = dept;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getEmpoyeeId() {
        return empoyeeId;
    }

}
public class Q5Cloneable  {

public static void main(String[]args) throws CloneNotSupportedException {
        Department dept = new Department(1, "JVM");
        Employee original = new Employee(1, "Admin", dept);

        //clone of original object
        Employee cloned = (Employee) original.clone();

        //Let verify using employee id, if cloning actually workded
        System.out.println(cloned.getEmpoyeeId());

        //Must be true and objects must have different memory addresses
        System.out.println(original != cloned);

        //As we are returning same class; so it should be true
        System.out.println(original.getClass() == cloned.getClass());

        //Default equals method checks for references so it should be false. If we want to make it true,
        //then we need to override equals method in Employee class.
        System.out.println(original.equals(cloned));
        }
}
