package com.wave.controller;

import com.wave.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginControllerService {


    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/xml", method = RequestMethod.POST , consumes = "application/xml")
    public @ResponseBody String printWelcome(@RequestBody User user) {
        System.out.println("hello " + user.getName() + " " + user.getEmail());
        return "hello " + user.getName() + " = =  " + user.getEmail();
    }

    @RequestMapping(value = "/serv", method = RequestMethod.POST)
    public @ResponseBody String printWelcome1(@RequestBody String user) {
        System.out.println("hello " + user);
        return "hello " + user;

    }
}
