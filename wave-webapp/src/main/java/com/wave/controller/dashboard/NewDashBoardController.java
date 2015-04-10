package com.wave.controller.dashboard;

import com.wave.controller.command.UserCommand;
import com.wave.controller.utils.Converter;
import com.wave.controller.utils.CookieUtils;
import com.wave.referral.ReferralData;
import com.wave.referral.service.ReferralService;
import com.wave.status.Status;
import com.wave.user.UserService;
import com.wave.user.dao.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.wave.controller.utils.Converter.getReferralCommands;
import static com.wave.controller.utils.Converter.getUserCommand;

@Controller
public class NewDashBoardController {

    @Autowired
    UserService userService;

    @Autowired
    ReferralService referralService;

    @RequestMapping(value = "/newdashboard", method = RequestMethod.GET)
    public ModelAndView showForm(@CookieValue(value = "TRIAGE", required = true) String cookie) {
        ModelAndView mv = new ModelAndView("newdashboard");

        UserData userData = userService.getUserData(CookieUtils.getUserIdFromCookie(cookie));
        UserCommand userCommand = getUserCommand(userData);
        mv.addObject("user", userCommand);

        List<ReferralData> newReferrals = referralService.getAllReferralsByStatus(Status.NEW);


        mv.addObject("newReferrals", getReferralCommands(newReferrals));


        List<ReferralData> allReferralsByUserId = referralService.getAllReferralsByStatus(Status.CHECKOUT, userData.getUserId());
        mv.addObject("claimedReferrals", getReferralCommands(allReferralsByUserId));


        List<ReferralData> validatedReferrals = referralService.getAllReferralsByStatus(Status.VALIDATED, userData.getUserId());
        mv.addObject("validatedReferrals", Converter.getReferralCommands(validatedReferrals));

        List<ReferralData> incompleteReferrals = referralService.getAllReferralsByStatus(Status.REFERRAL_INCOMPLETE, userData.getUserId());
        mv.addObject("incompleteReferrals", Converter.getReferralCommands(incompleteReferrals));

        return mv;
    }



}
