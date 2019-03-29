package com.ttn.thymeleaf.controller;

import com.ttn.thymeleaf.entity.Employee;
import com.ttn.thymeleaf.entity.User;
import com.ttn.thymeleaf.entity.UserEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@Controller
public class DemoController {
    List<Employee> employees=new ArrayList<>();
    List<User> users=new ArrayList<>();
    List<UserEnum> userEnums=new ArrayList<>();

    //  Q1...Create an external JS file and use it to show an alert on click of a button.
//  Q2...Create an external CSS file and use it to modify hello world page background color to grey.
    @GetMapping("sayHello")
    public String sayHello() {
        return "hello";
    }

    //  Q3...Create an Employee registration form and bind it's requested values on the controller.
    @GetMapping("form")
    public ModelAndView form()
    {
        ModelAndView form=new ModelAndView("form");
        form.addObject("employee",new Employee());
        return form;
    }

    //  Q4...Create a dynamic HTML page and render an Employee table with emp object return from the controller
    @PostMapping("submit")
    public ModelAndView submitform(Employee employee) {
        ModelAndView submit=new ModelAndView("submit");
        employees.add(employee);
        submit.addObject("emplist",employees);
        return submit;
    }

//Q5...Show different custom greeting message based on the type of user.
// For example, if the user is of type admin=true then show "Hello Admin" message on Page else show
// "Hello User" basis on isAdmin attribute value passed in model data.
    @GetMapping("greet")
    public ModelAndView greet() {
        ModelAndView form=new ModelAndView("greet");
        form.addObject("user",new User());
        return form;
    }

    @PostMapping("greeting")
    public ModelAndView checkGreet(User user) {
        ModelAndView submit=new ModelAndView("isAdminGreet");
        users.add(user);
        submit.addObject("userlist",users);
        return submit;
    }

//Q6...Create and split common header and footer in the above-created listing page.
    //in greet.html


//Q7...Make a web page to show server time using ajax call.
    @GetMapping("time")
    public String time() {
        return "time";
    }
//Q8...Create a user listing table show alternate row color using a conditional tag.
    //done in Q3 and Q4

//Q9...Create an ENUM with values USER, ADMIN, SUPER_ADMIN and iterate it to show a custom message to users
// basis on the ENUM value
    @GetMapping("enumPerson")
    public ModelAndView enumPerson() {
        ModelAndView enumview=new ModelAndView("person");
        enumview.addObject("enumPerson",new UserEnum());
        return enumview;
    }

    @PostMapping("enum")
    public ModelAndView enummessage(UserEnum userEnum) {
        ModelAndView submit=new ModelAndView("enum");
        userEnums.add(userEnum);
        submit.addObject("enumlist",userEnums);
        return submit;
    }
//Q10...Add loader in registration form submission which renders load till server return success form submission response.
    @GetMapping("onload")
    public String onload() {
        return "onload";
    }

    @PostMapping("/ajaxloader")
    @ResponseBody
    public String ajaxloader() throws InterruptedException {
        Thread.sleep(3000);
        return "data from ajax";
    }

}
