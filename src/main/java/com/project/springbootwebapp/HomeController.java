package com.project.springbootwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("home")
    public String home() {

        return "home.jsp";

    }

    @RequestMapping("home1")
    public String homeHtml() {

        return "home.html";

    }

    @RequestMapping("test1")
    @ResponseBody
    public String test1() {

        return "This text will be printed.";

    }

}