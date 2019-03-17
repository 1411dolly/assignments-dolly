package com.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("spring-config.xml");
        UserDao userDao = applicationContext.getBean(UserDao.class);

//        Q1...Use JdbcTemplate to get the count of users
          userDao.display();

//        Q2...Get name of the user by providing username to the parametrized query
          userDao.getUserName();

//        Q3...Insert one record using JdbcTemplate
          User user=new User();
          user.setUsername("dolly");
          user.setPassword("dolly");
          user.setUsername("dolly");
          user.setAge(21);
          user.setDob(new Date());
          userDao.insertUser(user);

//          Q4...Use QueryForMap to fetch the user details of the  user
        userDao.queryForMapDemo();

//        Q5...Use QueryForList to fetch records of all users
        userDao.queryForListDemo();

//        Q6...Use a rowmapper to get the User object when you query for a user
        userDao.getUser();

//        Q7...Integrate Hibernate with Spring and use hql query to count the number of records in user table.
        userDao.sessionFactoryDemo();



/*
        Q8...Use @Transactional to save to save 2 records using jdbc template with the following prapogation options
                REQUIRED
        REQUIRES_NEW
                NESTED
        MANDATORY
                NEVER
        NOT_SUPPORTED
                SUPPORTS
*/

        try{ userDao.testRequiredParent();}
        catch (Exception e){
              System.out.println("continue;"); }

        userDao.testRequirednewParent();

        userDao.testNestedParent();

        userDao.testMandatoryParent();

        userDao.testNeverParent();

        userDao.testNotSupportedParent();

        try{userDao.testSupportedParent();}
        catch (Exception e){
                System.out.println("Used if want to use the same context as caller (higher context)," +
                        "\n if your caller was running in transaction,\n" +
                        " then you run in too. If it didn't, you are also non-transactional"); }


/*
        Demonstrate the use of following options of @Transactional annotation

        read-only
        timeout
        rollback-for
        no-rollback-for
*/

        try{
        userDao.readonly();}
        catch (Exception e)
        {
            System.out.println("only read only allowed!!!");
        }
        userDao.timeOut();
        userDao.rollBackFor();
        userDao.noRollBackFor();
    }
}
