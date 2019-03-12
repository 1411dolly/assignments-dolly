package com.example.SpringAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringAssignmentApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
//		Q1...Create a class Database with 2 instance variables port and name. Configure Database class bean in spring container through Spring XML. Initialize instance variables using setter method.
//		Q2...Get the bean of the class from spring container and print the values of the instance variable.
		Database database=applicationContext.getBean(Database.class);
		System.out.println("Name::"+database.getName());
		System.out.println("Port::"+database.getPort());

//		Q3...create a bean with the name teaRestaurant of type Restaurant which inject Tea object as dependency using setter method.
//		Restaurant restaurantExpress1=applicationContext.getBean(Restaurant.class);
//		System.out.println(restaurantExpress1.getHotDrink());

//		Q4...Get both the beans and invoke prepareHotDrink method via hotDrink
//		instance variables. Try inner bean with expressTeaRestaurant.
//		Restaurant restaurantExpress2=applicationContext.getBean(Restaurant.class);
//		System.out.println(restaurantExpress2.getHotDrink());

//		Q5...complexBean. Get the bean and display the properties.
//		Complex complex=applicationContext.getBean(Complex.class);
//		System.out.println(complex.getList());
//		System.out.println(complex.getSet());
//		System.out.println(complex.getMap());
//		Restaurant restaurantTea=new Restaurant(new ExpressTea());
//		System.out.println(restaurantTea.getHotDrink());

//		Q6...Autowire hotDrink in Restaurant with tea bean byName, byType and constructor.
//		Restaurant restaurantExpress3=applicationContext.getBean(Restaurant.class);
//		System.out.println(restaurantExpress3.getHotDrink());

//		Q7...Set the scope of the teaRestaurant bean as proptotype and check the scope type after accessing the bean.
		Restaurant restaurantExpress4=applicationContext.getBean(Restaurant.class);
		System.out.println(restaurantExpress4.getHotDrink());
		Restaurant restaurantExpress5=applicationContext.getBean(Restaurant.class);
		System.out.println(restaurantExpress5.getHotDrink());

	}

}
