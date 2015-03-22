package com.wave.controller.dashboard;

import com.wave.controller.command.UserCommand;
import com.wave.controller.referral.Converter;
import com.wave.controller.utils.CookieUtils;
import com.wave.referral.ReferralData;
import com.wave.referral.service.ReferralService;
import com.wave.user.UserService;
import com.wave.user.dao.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static com.wave.controller.referral.Converter.getUserCommand;

@Controller
public class DashBoardController {

    @Autowired
    UserService userService;

    @Autowired
    ReferralService referralService;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView showForm(@CookieValue(value = "TRIAGE", required = true) String cookie) {
        ModelAndView mv = new ModelAndView("dashboard");

        UserData userData = userService.getUserData(CookieUtils.getUserIdFromCookie(cookie));
        UserCommand userCommand = getUserCommand(userData);
        mv.addObject("user", userCommand);

        List<ReferralData> newReferrals = referralService.getAllNewReferrals();


        mv.addObject("newReferrals", Converter.getReferralCommands(newReferrals));


        List<ReferralData> allReferralsByUserId = referralService.getAllClaimedAndOpenReferralsByUserId(userData.getUserId());
        mv.addObject("claimedReferrals", Converter.getReferralCommands(allReferralsByUserId));

        return mv;
    }



}
