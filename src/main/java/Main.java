import entity.Employee;
import entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import repository.EmployeeRepository;
import repository.PersonRepository;

import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(PersistenceContext.class);
        EmployeeRepository employeeRepository=applicationContext.getBean(EmployeeRepository.class);

        /*Employee emp =new Employee();
        emp.setName("dolly");
        emp.setAge(21);
        emp.setSalary(21);
        EmployeeRepository employeeRepository=applicationContext.getBean(EmployeeRepository.class);
        System.out.println(employeeRepository.findById(1));
        System.out.println(employeeRepository.countByName("dolly"));
        List<Employee> list1=employeeRepository.findByNameIs("dolly");
        List<Employee> list2=employeeRepository.findByNameOrderByIdDesc("dolly");

        System.out.println(list1);
        System.out.println(list2);*/

//      Q3...For class Person find person declare methods in repository to find person by firstname, lastname and Id.
        PersonRepository personRepository=applicationContext.getBean(PersonRepository.class);

        /*
        Person person=new Person("dolly","thakur",15f,21);
        personRepository.save(person);
        Person person1=personRepository.findOne(1);
        System.out.println(person1);
        boolean ifexist=personRepository.exists(1);
        System.out.println(ifexist);
        Iterable<Person> personIterable=personRepository.findAll();
        System.out.println(personIterable);

        ArrayList<Integer> personidlist=new ArrayList<>();
        personidlist.add(1);
        personidlist.add(2);
        personidlist.add(3);
        Iterable<Person> personIterable1=personRepository.findAll(personidlist);
        System.out.println(personIterable1);

        int count= (int) personRepository.count();
        System.out.println(count);

        personRepository.delete(12);

        Person person2=new Person(11,"dolly","thakur",15f,21);
        personRepository.delete(person2);

        ArrayList<Person> personiddeletelist=new ArrayList<>();
        Person person10=new Person(10,"dolly","thakur",15f,21);
        Person person9=new Person(9,"dolly","thakur",15f,21);
        Person person8=new Person(8,"dolly","thakur",15f,21);
        Person person7=new Person(7,"dolly","thakur",15f,21);
        Person person6=new Person(6,"dolly","thakur",15f,21);
        personiddeletelist.add(person10);
        personiddeletelist.add(person9);
        personiddeletelist.add(person8);
        personiddeletelist.add(person7);
        personiddeletelist.add(person6);
        personRepository.delete(personiddeletelist);

        personRepository.deleteAll();
        */

        /*
//Q4...For class Person find person declare methods in repository to find person by firstname, lastname and Id
//        Q5...Use the methods declared above to fetch the person.
        List<Person> findbyname=personRepository.findByFirstname("amarjeet");
        System.out.println("FIND BY NAME::"+findbyname);
        List<Person> findbylastname=personRepository.findByLastname("aditya");
        System.out.println("FIND BY LAST NAME::"+findbylastname);
        Person findbyid=personRepository.findById(1);
        System.out.println("FIND BY ID"+findbyid);
//        Q6...Use @Query to fetch firstname of the Person whose age is 25.
        String name=personRepository.findByAge25();
        System.out.println("FIRSTNAME WHOSE AGE IS 25::"+name);
        String name2=personRepository.findBynameAge25();
//        Q7...Use @Query to fetch firstname and lastname of the Person whose age is 25.
        String name3=personRepository.getPerson();
        System.out.println("FIRSTNAME & LASTNAME WHOSE AGE IS 25::"+name3);
//        Q8...Get complete information of the Employee whose age is 25 using @Query.
        Employee employee= employeeRepository.findById(6);
        System.out.println("INFO OF EMPLOYEE::"+employee);

//        Q9..Count Person where name is "Peter" using @Query.
        int count=personRepository.countname();
        System.out.println("COUNT::"+count);

*/

        /*Q10...Implement following methods for Person repository:

        count
                distinct
        or
                and
        between
                LessThan
        GreaterThan
                Like
        Not
                In
        IgnoreCase



        int count=personRepository.countByFirstname("peter");
        System.out.println("COUNT BY ID 1::"+count);

        List<Person> listperson1=personRepository.findDistinctByFirstname("peter");
        System.out.println("FIND DISTINCT BY FIRST NAME::"+listperson1);


        List<Person> listperson2=personRepository.findByFirstnameOrAge("dolly",21);
        System.out.println("FIND BY FIRST NAME OR AGE::"+listperson2);


        List<Person> listperson3=personRepository.findByFirstnameAndAge("peter",25);
        System.out.println("FIND BY FIRST NAME AND AGE::"+listperson3);
        List<Person> listperson4=personRepository.findByAgeBetween(19,21);
        System.out.println("FIND BY AGE BETWEEN::"+listperson4);
        List<Person> listperson5=personRepository.findByAgeLessThan(20);
        System.out.println("FIND BY AGE LESS THAN::"+listperson5);
        List<Person> listperson6=personRepository.findByAgeGreaterThan(25);
        System.out.println("FIND BY AGE GREATER THAN::"+listperson6);
        List<Person> listperson7=personRepository.findByFirstnameLike("peter");
        System.out.println("FIND BT FIRST NAME LIKE::"+listperson7);
        List<Person> listperson8=personRepository.findByFirstnameNot("amarjeet");
        System.out.println("FIND BY FIRST NAME NOT::"+listperson8);
        List<Integer> agelist= Arrays.asList(19,20,21);
        List<Person> listperson9=personRepository.findByAgeIn(agelist);
        System.out.println("FIND BY AGE IN::"+listperson9);
        List<Person> listperson10=personRepository.findByFirstnameIgnoreCase("PETER");
        System.out.println("FIND BY FIRST NAME IGNORE CASE::"+listperson10);

*/

//      Q11...Get the persons greater than age 25 and sort them in descending order according to id by method query.
        List<Person> listperson11=personRepository.findByAgeGreaterThanSortById();
        System.out.println("AGE GREATER THAN 25 AND DESC SORT::"+listperson11);
//      Q12...Do  the question above using the Sort class.
        List<Person> listperson12= personRepository.findByAgeGreaterThan(25,new Sort(Sort.Direction.DESC,"id"));
        System.out.println("USING SORT::"+listperson12);
//      Q13...Apply Pagination on Person entities
        Page<Person> personPage=personRepository.findAll(
                new PageRequest(0,3,new Sort(Sort.Direction.DESC,"id")));
        List<Person> personList13=personPage.getContent();
        System.out.println("PAGE(0,3)::"+personList13);

    }
}
