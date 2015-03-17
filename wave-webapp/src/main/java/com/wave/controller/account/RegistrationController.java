package com.wave.controller.account;

import com.wave.controller.command.UserCommand;
import com.wave.user.UserService;
import com.wave.user.dao.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {


    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showForm(@RequestParam(value = "userId", required = false) Long userId) {
        ModelAndView mv = new ModelAndView("registration");
        UserCommand userCommand = new UserCommand();
        if(userId != null){
            UserData userData = userService.getUserData(userId);
            if(userData != null){
                userCommand.setEmail(userData.getEmail());
                userCommand.setName(userData.getDisplayName());
            }
        }
        mv.addObject("user", userCommand);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView printWelcome(@ModelAttribute("user") UserCommand userCommand) {

        UserData userData = new UserData();
        userData.setPassword(userCommand.getPassword());
        userData.setEmail(userCommand.getEmail());
        userData.setDateOfBirth(new Date());
        userData.setCreateDate(new Date());
        userData.setGender("M");
        userData.setActive(true);
        userData.setUserGuid(UUID.randomUUID().toString());
        userData.setUserName(userCommand.getName());
        userData.setDisplayName(userCommand.getName());
        if (userService == null) System.out.println("userService null =======");
        else System.out.println("userService not null =======");
        userService.saveUserData(userData);
        UserData userData1 = userService.getUserData(userData.getUserId());

        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("userId", userData1.getUserId());
        return mv;

    }
}
