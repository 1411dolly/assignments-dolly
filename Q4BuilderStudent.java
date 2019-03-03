import java.util.concurrent.Future;
class Student
{
    public Student(StudentBuilder studentBuilder) {
        this.rollno=studentBuilder.getRollno();
        this.name=studentBuilder.getName();
        this.age=studentBuilder.getAge();
        this.address=studentBuilder.getAddress();
        this.gender=studentBuilder.getGender();
        this.nationality=studentBuilder.getNationality();
    }

    public int getRollno() {
        return rollno;
    }

    int rollno;
    String name;
    String address;
    int age;
    String gender;
    String nationality;

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "rollno:"+rollno+" name:"+name+" address:"+address+" age:"+age+" gender:"+gender+" nationality:"+nationality;
    }
}

class StudentBuilder
{
    int rollno;
    String name;
    String address;
    int age;
    String gender;
    String nationality;

    public StudentBuilder(int rollno) {
        this.rollno=rollno;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public StudentBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public StudentBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public int getAge() {
        return age;
    }

    public StudentBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public StudentBuilder withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public StudentBuilder withNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public Student build()
    {
        return new Student(this);
    }
}

public class Q4BuilderStudent {
    public static void main(String[] args) {
        Student student1=new StudentBuilder(1).withName("Dolly").withGender("F").withAddress("Badarpur").withAge(21).withNationality("Indian").build();
        System.out.println(student1);
    }
}
