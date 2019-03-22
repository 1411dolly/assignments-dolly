package com.spring.mvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Q2...Now remove AbstractController and useMultiActionController for StudentController which contains 2 actions one action renders a jsp view
// and another action uses HttpServletResponse to show the output on the Web browser.
public class HelloController extends MultiActionController {

    public ModelAndView hello(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView("hello");
        return modelAndView;
    }

    public void hello2(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setContentType("text/html");
        httpServletResponse.getWriter().println("<b>HELLO2 WORLD</b>");
    }
}
