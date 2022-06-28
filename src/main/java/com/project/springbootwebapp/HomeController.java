package com.project.springbootwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    // (Assuming the default directory is not changed in application.properties)
    @GetMapping("home1")
    public String home1() {

        return "home.html";

    }

    // SpringBoot seems to always look for .jsp files in the "webapp" folder.
    // (Assuming the default directory is not changed in application.properties)
    @GetMapping("home2")
    public String home2() {

        return "home";

    }

    @RequestMapping("home3")
    public String home3(HttpServletRequest req, HttpServletResponse res) {

        // Sample of how to pass data into endpoint.
        // http://localhost:8080/home3?name=George
        String name = req.getParameter("name");

        HttpSession session = req.getSession();
        session.setAttribute("username", name);

        return "newhome";

    }

    // Sample of how to pass data into endpoint.
    // http://localhost:8080/home4?name=George
    @RequestMapping("home4")
    public String home4(String name, HttpSession session) {

        session.setAttribute("username", name);

        return "newhome0";

    }

    // @RequestParam allows you to set the parameter name that Sprint Boot looks for in the URL.
    // Using @RequestParam allows you to set whatever variable name you want in the controller method.
    @RequestMapping("home5")
    public String home5(@RequestParam("name") String myName, HttpSession session) {

        session.setAttribute("username", myName);

        return "newhome0";

    }

}