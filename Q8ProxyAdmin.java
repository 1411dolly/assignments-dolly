interface AccessRecords
{
    void getRecord();
}
class Person{
    private String designation;

    public Person(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
class Admin implements AccessRecords
{
    protected Person person;

    public Admin(Person person) {
        this.person = person;
    }

    @Override
    public void getRecord() {
        System.out.println("get records!!!");
    }
}

class AdminProxy extends Admin
{

    public AdminProxy(Person person) {
        super(person);
    }

    public void getRecord()
    {
        if(!person.getDesignation().equals("Admin"))
            System.out.println("Access Denied!!!");
        else {
            System.out.println("redirecting.....");
            super.getRecord();
        }
    }
}
public class Q8ProxyAdmin {
    public static void main(String[] args) {
        Person dolly=new Person("Student");
        AccessRecords adminProxy=new AdminProxy(dolly);
        adminProxy.getRecord();
        Person admin=new Person("Admin");
        AccessRecords adminProxy2=new AdminProxy(admin);
        adminProxy2.getRecord();
    }
}
