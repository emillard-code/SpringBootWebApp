package com.project.springbootwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    // Adding slashes to the endpoints causes some of these links to not work.
    // Try to find out why later.

    // @ResponseBody annotation causes the String to be printed directly as text.
    // (Rather than be treated as a file name)
    @RequestMapping("home0")
    @ResponseBody
    public String home0() {

        return "Hello World! (From controller method)";

    }

    // SpringBoot seems to look for html files in "resources/static".
    @GetMapping("home1")
    public String home1() {

        return "home.html";

    }

    // SpringBoot seems to always look for .jsp files in the "webapp" folder.
    @GetMapping("home2")
    public String home2() {

        return "home.jsp";

    }

}