package com.wave.controller.user;


import com.wave.command.RoleCommand;
import com.wave.command.UserCommand;
import com.wave.role.RoleData;
import com.wave.user.UserService;
import com.wave.user.dao.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserListViewController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/userlistview", method = RequestMethod.GET)
    public ModelAndView createForm(@RequestParam(value = "type", required = false) String type){
        ModelAndView mv=new ModelAndView("userlistview");
        List<UserCommand> userCommandList = new ArrayList<UserCommand>();
        List<UserData> userDataList=null;
        if(type.toUpperCase().equals("NEW")){
            userDataList=userService.getAllNewUsers();
        }else if (type.toUpperCase().equals("ALL")) {
            userDataList=userService.getAllUsers();
        }


        if(userDataList==null){
            mv.addObject("users",userCommandList);
            return mv;
        }
        for(UserData userdata : userDataList){
            UserCommand userCommand=new UserCommand();
            userCommand.setActive(userdata.isActive());
            List<RoleCommand> list=new ArrayList<RoleCommand>();
            for(RoleData role : userdata.getRoles()){
                RoleCommand roleCmd=new RoleCommand();
                roleCmd.setDescription(role.getDescription());
                roleCmd.setId(role.getId());
                roleCmd.setName(role.getName());
                list.add(roleCmd);
            }
            userCommand.setRoles(list);
            userCommand.setName(userdata.getUserName());
            userCommand.setDisplayName(userdata.getDisplayName());
            userCommand.setDateOfBirth(userdata.getDateOfBirth());
            userCommand.setGender(userdata.getGender());
            userCommand.setCreateDate(userdata.getCreateDate());
            userCommand.setEmail(userdata.getEmail());
            userCommandList.add(userCommand);
        }
        mv.addObject("users",userCommandList);
        return mv;
    }
}
