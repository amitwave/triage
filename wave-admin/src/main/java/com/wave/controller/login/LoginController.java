package com.wave.controller.login;

import com.wave.controller.command.UserCommand;

import com.wave.user.UserService;
import com.wave.user.dao.UserData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import static com.wave.controller.utils.CookieUtils.getCookie;

@Controller
public class LoginController {


    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showForm() {
        ModelAndView mv = new ModelAndView("login");
        UserCommand userCommand = new UserCommand();

        mv.addObject("user", userCommand);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView printWelcome(@ModelAttribute("user") UserCommand userCommand, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("login");
        if(StringUtils.isEmpty(userCommand.getName()) || StringUtils.isEmpty(userCommand.getPassword())){
            mv = new ModelAndView(new RedirectView("login"));
            return mv;
        }

        UserData userData = userService.getUserByUserName(userCommand.getName());
        mv = new ModelAndView(new RedirectView("dashboard"));
        if (userData != null && userCommand.getPassword().equals(userData.getPassword())) {
            response.addCookie(getCookie(userData));
        } else{
            mv = new ModelAndView(new RedirectView("login"));
        }

        return mv;

    }


}
