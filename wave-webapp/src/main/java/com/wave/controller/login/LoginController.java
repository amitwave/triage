package com.wave.controller.login;

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

@Controller
public class LoginController {


    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showForm(@RequestParam(value = "userId") Long userId) {
        ModelAndView mv = new ModelAndView("login");
        UserCommand userCommand = new UserCommand();
        if (userId != null) {
            UserData userData = userService.getUserData(userId);
            if (userData != null) {
                userCommand.setEmail(userData.getEmail());
                userCommand.setName(userData.getDisplayName());
            }
        }
        mv.addObject("user", userCommand);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView printWelcome(@ModelAttribute("user") UserCommand userCommand) {

        UserData userData = userService.getUserByUserName(userCommand.getName());
        ModelAndView mv = new ModelAndView("login");
        if (userData != null) {

            mv.addObject("userId", userData.getUserId());

        }

        return mv;

    }
}
