package com.wave.controller.account;

import com.wave.command.RoleCommand;
import com.wave.command.UserCommand;
import com.wave.role.RoleData;
import com.wave.user.UserService;
import com.wave.user.dao.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class RegistrationController {


    @Autowired
    UserService userService;

    @RequestMapping(value = "/registration" ,method = RequestMethod.GET)
    public ModelAndView showForm(@RequestParam(value = "userId", required = false) Long userId) {
        ModelAndView mv = new ModelAndView("/registration");
        UserCommand userCommand = new UserCommand();
        if(userId != null){
            UserData userData = userService.getUserData(userId);
            if(userData != null){
                userCommand.setEmail(userData.getEmail());
                userCommand.setName(userData.getUserName());
                userCommand.setDisplayName(userData.getDisplayName());
                List<RoleCommand> list=new ArrayList<RoleCommand>();
                for(RoleData role : userData.getRoles()){
                    RoleCommand roleCmd=new RoleCommand();
                    roleCmd.setDescription(role.getDescription());
                    roleCmd.setId(role.getId());
                    roleCmd.setName(role.getName());
                    list.add(roleCmd);
                }
                userCommand.setRoles(list);
                userCommand.setPassword(userData.getPassword());
                userCommand.setActive(userData.isActive());
                userCommand.setGender(userData.getGender());
                userCommand.setDateOfBirth(userData.getDateOfBirth());
            }
        }
        mv.addObject("user", userCommand);
        mv.addObject("info", "Welcome to Triage Signup Page");
        return mv;
    }

    @RequestMapping(value = "./registration",method = RequestMethod.POST)
    public ModelAndView printWelcome(@ModelAttribute("user") UserCommand userCommand,@ModelAttribute("info") String info) {
        ModelAndView mv = new ModelAndView("./registration");
        UserData userData = new UserData();
        userData.setPassword(userCommand.getPassword());
        userData.setEmail(userCommand.getEmail());
        userData.setDateOfBirth(userCommand.getDateOfBirth());
        userData.setCreateDate(new Date());
        userData.setGender(userCommand.getGender());
        userData.setActive(false);
        userData.setUserGuid(UUID.randomUUID().toString());
        userData.setUserName(userCommand.getName());
        userData.setDisplayName(userCommand.getName());
        if (userService == null){
            UserCommand uCommand = new UserCommand();
            mv.addObject("user", uCommand);
            mv.addObject("info", "ERROR Could not registered");
            return mv;
        }
        userService.saveUserData(userData);
        mv.addObject("user", userCommand);
        mv.addObject("info", "Successfully registered waiting for admin validation");
        return mv;

    }
}
