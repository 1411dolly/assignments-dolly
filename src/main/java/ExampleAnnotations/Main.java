package ExampleAnnotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {


//        Q9...Use @Autowired annotation to wire Tea with Restaurant class Using setter method, field and constructor.

//        Q10...Use @Component, @Controller, @Repository etc annotation to configure Tea and Restaurant in Spring Container.


        AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext("ExampleAnnotations");
        Restaurant restaurant=ctx.getBean(Restaurant.class);
        ctx.start();
        System.out.println("Tea(Autowired)::"+restaurant.getTea().getType());
    }
}
