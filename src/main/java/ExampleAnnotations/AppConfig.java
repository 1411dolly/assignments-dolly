package ExampleAnnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@ComponentScan("ExampleAnnotations")
@Configuration
public class AppConfig {
    @Bean
    public Tea getTea()
    {
        Tea tea=new Tea();
        tea.setType("masalaTea");
        return tea;
    }
//    @Bean
//    public Restaurant getRestaurant()
//    {
//        return new Restaurant();
//    }



}
