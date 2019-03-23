package com.ttn;

//import com.ttn.entity.DebitAccount;
//import com.ttn.entity.Person;
//import com.ttn.entity.Vehicle;
import com.ttn.entity.manyToMany.ManyToMany;
import com.ttn.entity.oneToManyBiDirectional.OneToManyBi;
import com.ttn.entity.oneToManyUniDirectional.OneToManyUni;
import com.ttn.entity.oneToManyWithoutTable.OneToManyWithoutTable;

public class Application {

    public static void main(String[] args) {


/*
//        Q1...Create a class Author with instance variables firstName, lastName and age.
//        Q2...Perform CRUD operation for Author class.
        //create Author
         Author author=new Author();
        author.setFirstName("Paulo");
        author.setLastName("Coelho");
        author.setAge(71);

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();

/*        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
//        session.close();

        //read Author
        session.beginTransaction();
        Author author1=session.get(Author.class,1);
        session.getTransaction().commit();
        System.out.println(author1);
//        session.close();

        //Update Author

        session.beginTransaction();
        Author author2=session.get(Author.class,1);
        author2.setAge(70);
        session.update(author2);
        session.getTransaction().commit();
        System.out.println(author2);
//        session.close();


        //Delete Author
        session.beginTransaction();
        Author author3=session.get(Author.class,1);
        session.delete(author3);
        session.getTransaction().commit();
        System.out.println(author3);
        session.close();
*/
//      Q3...Use hbm2ddl create to introduce Date of Birth for Author.
//      Q4...Use hbm2dll update to insert at least 4 records for Author.
        /*Author author4=new Author("William","Shakespeare",52,new Date("1564/04/23"));
        Author author5=new Author("Charles","Dickens",58,new Date("1812/02/07"));
        Author author6=new Author("Rudyard","Kipling",70,new Date("1865/12/30"));
        Author author7=new Author("Jonathan","Swift",77,new Date("1667/11/30"));

        session.beginTransaction();
        session.save(author4);
        session.save(author5);
        session.save(author6);
        session.save(author7);
        session.getTransaction().commit();*/
        //Q5...Perform hbm2dll create-drop by closing session factory.
//        session.close();


        //Q11...Create instance variable of Address class inside Author class and save it as embedded object
        /*Author author8=new Author("Rabindranath","Tagore",80,new Date("1861/05/07"));
        Address address1=new Address(6,"Henley St","UK");
        Address address2=new Address(48,"Doughty St","London");
        Address address3=new Address(1,"Bombay","India");
        Address address4=new Address(2,"Dublin","Ireland");
        Address address5=new Address(6,"Dwarakanath","Kolkata");
        author4.setAddress(address1);
        author5.setAddress(address2);
        author6.setAddress(address3);
        author7.setAddress(address4);
        author8.setAddress(address5);
        session.beginTransaction();
        session.save(author8);
        session.save(author4);
        session.save(author5);
        session.save(author6);
        session.save(author7);
        session.getTransaction().commit();
//        session.close();
*/
        //Q13...Persist 3 subjects for each author.
        /*ArrayList<String> williamSub=new ArrayList<>();
        williamSub.add("Hamlet");
        williamSub.add("Romoeo and Juliet");
        williamSub.add("Macbeth");

        ArrayList<String> charlesSub=new ArrayList<>();
        charlesSub.add("Oliver Twist");
        charlesSub.add("Romoeo and Juliet");
        charlesSub.add("The Battle of Life");

        ArrayList<String> rudyardSub=new ArrayList<>();
        rudyardSub.add("Hamlet");
        rudyardSub.add("Three Ghost Stories");
        rudyardSub.add("Macbeth");

        ArrayList<String> jonathanSub=new ArrayList<>();
        jonathanSub.add("If");
        jonathanSub.add("The Jungle Book");
        jonathanSub.add("Kim");

        ArrayList<String> rabindranathSub=new ArrayList<>();
        rabindranathSub.add("Gitanjali");
        rabindranathSub.add("Kabuliwala");
        rabindranathSub.add("Shesher Kabita");

        author4.setSubjects(williamSub);
        author5.setSubjects(charlesSub);
        author6.setSubjects(rudyardSub);
        author7.setSubjects(jonathanSub);
        author8.setSubjects(rabindranathSub);
        session.beginTransaction();
        session.save(author4);
        session.save(author5);
        session.save(author6);
        session.save(author7);
        session.save(author8);
        session.getTransaction().commit();*/
//        session.close();


//      Q15...Implement One to One mapping between Author and Book.

  /*
        Book book1=new Book("Book1");
        Book book2=new Book("Book2");
        Book book3=new Book("Book3");
        Book book4=new Book("Book4");
        Book book5=new Book("Book5");

        author4.setBook(book1);
        author5.setBook(book2);
        author6.setBook(book3);
        author7.setBook(book4);
        author8.setBook(book5);

        session.beginTransaction();
        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);
        session.save(author4);
        session.save(author5);
        session.save(author6);
        session.save(author7);
        session.save(author8);
        session.getTransaction().commit();
        session.close();
*/

//Q16...Implement One to Many Mapping between Author and Book(Unidirectional, BiDirectional and without additional table ) and  implement cascade save.

        OneToManyUni oneToManyUni=new OneToManyUni();
        oneToManyUni.unidirectionOneToMany();
        OneToManyBi oneToManyBi=new OneToManyBi();
        oneToManyBi.bidirectionOneToMany();
        OneToManyWithoutTable oneToManyWithoutTable=new OneToManyWithoutTable();
        oneToManyWithoutTable.withoutTableOneToMany();
//  Q17...Implement Many to Many Mapping between Author and Book.
        ManyToMany manyToMany=new ManyToMany();
        manyToMany.manyToMany();



    }
}
