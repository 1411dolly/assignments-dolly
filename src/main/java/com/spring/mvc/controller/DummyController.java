package com.spring.mvc.controller;
import com.spring.mvc.entityCO.UserCO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class DummyController {
//Q3...Use annotation in StudentController to define a default action index which renders a jsp page.
    @RequestMapping("/")
    ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

//Q4...Create one more annotation based action hello inside the StudentController which
// and use @ResponseBody annotation from it to display Hello world.
    @ResponseBody
    @RequestMapping("/helloworld")
    String hello(){
        return "Hello World!!!";
    }


//Q5...Create one more action which sends Model HelloWorld to the jsp file.
//    @ResponseBody
    @RequestMapping("/index")
    ModelAndView indexmsg() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("msg", "Hello World");
        return modelAndView;
    }

//Q6...Use @PathVariable annotation to access firstname and lastname in an action inside StudentController place
// both the parameters in different arguments and access them.
    @RequestMapping("/dummy/{firstname}/{lastname}")
    @ResponseBody
    String returnCountryName(@PathVariable("firstname") String first,@PathVariable("lastname") String last) {
        return "Hello "+first+" "+last;

    }

//Q7...Now place both the arguments inside a Map and access the Map instead.
    @RequestMapping("/index/{firstname}/{lastname}")
    @ResponseBody
    String returnCountryAndState(@PathVariable Map<String, String> requestMap) {
        return "Hello(map)::"+requestMap.get("firstname") + " " + requestMap.get("lastname");
    }

//Q8...Use @RequestParam annotation to access the firstname and lastname in formData action of StudentController.
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("formStudent");
        return modelAndView;
    }

//Q9...Use @RequestParam annotation to access the firstname and lastname in formData action of StudentController.
    @RequestMapping(value = "/submitForm", method = RequestMethod.POST)
    @ResponseBody
    String submitForm(String username, String password)
    {
        return "Username::" + username + " Password::" + password;
    }

//Q10...Create a StudentCO and bind firstname and lastname with instance variable of StudentCO.
    @RequestMapping(value = "/submitUser", method = RequestMethod.POST)
    @ResponseBody
    ModelAndView submitUserForm(@ModelAttribute("user") UserCO userCO) {
        ModelAndView modelAndView = new ModelAndView("submittedData");
        return modelAndView;
    }

//Q11...Use @ModelAttribute annotation to add Heading "Spring MVC Demo" in every model.
    @ModelAttribute
    void addingObject(Model model){
        model.addAttribute("heading","Spring MVC Demo");
    }
}
