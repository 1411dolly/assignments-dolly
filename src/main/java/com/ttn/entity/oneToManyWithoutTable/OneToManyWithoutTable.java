package com.ttn.entity.oneToManyWithoutTable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Date;

public class OneToManyWithoutTable {

    public void withoutTableOneToMany()
    {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
         Author author1=new Author("William","Shakespeare",52,new Date("1564/04/23"));
         Author author2=new Author("Charles","Dickens",58,new Date("1812/02/07"));
         Address address1=new Address(6,"Henley St","UK");
         Address address2=new Address(48,"Doughty St","London");
        author1.setAddress(address1);
        author2.setAddress(address2);
        ArrayList<String> williamSub=new ArrayList<>();
        williamSub.add("Hamlet");
        williamSub.add("Romoeo and Juliet");
        williamSub.add("Macbeth");

        ArrayList<String> charlesSub=new ArrayList<>();
        charlesSub.add("Oliver Twist");
        charlesSub.add("Romoeo and Juliet");
        charlesSub.add("The Battle of Life");

        author1.setSubjects(williamSub);
        author2.setSubjects(charlesSub);

        Book book1=new Book("Book1");
        Book book2=new Book("Book2");
        Book book3=new Book("Book3");
        Book book4=new Book("Book4");
        Book book5=new Book("Book5");

        book1.setAuthor(author1);
        book2.setAuthor(author1);
        book3.setAuthor(author1);
        book4.setAuthor(author2);
        book5.setAuthor(author2);

        author1.getBook().add(book1);
        author1.getBook().add(book2);
        author1.getBook().add(book3);
        author2.getBook().add(book4);
        author2.getBook().add(book5);

        session.beginTransaction();
        session.save(author1);
        session.save(author2);
        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);
        session.getTransaction().commit();
        session.close();



    }
}
