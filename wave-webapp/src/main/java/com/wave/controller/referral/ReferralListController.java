package com.wave.controller.referral;

import com.wave.command.ReferralCommand;
import com.wave.controller.utils.Converter;
import com.wave.referral.ReferralData;
import com.wave.referral.service.ReferralService;
import com.wave.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static com.wave.controller.utils.CookieUtils.getUserIdFromCookie;
import static com.wave.controller.utils.PaginationUtil.getPaginationCommand;

@Controller
@RequestMapping(value = "/referrallist")
public class ReferralListController {


    @Autowired
    ReferralService referralService;

    @Value("${page.size}")
    private Integer pageSize;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showForm(@RequestParam(value = "type", required = false) Status type,
                                 @CookieValue(value = "TRIAGE", required = true) String cookie, @RequestParam(value = "page", required = false) Integer page) {

        Long userId = getUserIdFromCookie(cookie);



        ModelAndView mv = new ModelAndView("referralsdashboard");
        List<ReferralData> allReferrals = null;
        if(Status.NEW == type) {
            if(page == null) {
                page = 1;
            }
            allReferrals = referralService.getAllReferralsByStatusAndPage(type, page);
            Long allReferralsCountByStatus = referralService.getAllReferralsCountByStatus(type);


            mv.addObject("paginations", getPaginationCommand(page, allReferralsCountByStatus, pageSize));
        }else {
            allReferrals = referralService.getAllReferralsByStatus(type, userId);
            Long allReferralsCountByStatus = referralService.getAllReferralsCountByStatus(type, userId);


            mv.addObject("paginations", getPaginationCommand(page, allReferralsCountByStatus, pageSize));
        }

        List<ReferralCommand> referrals = new ArrayList<ReferralCommand>();
        for (ReferralData referralData : allReferrals) {
            ReferralCommand referralCommand = Converter.getReferralCommand(referralData);

            referrals.add(referralCommand);
        }


        mv.addObject("referrals", referrals);
        mv.addObject("type", type);
        return mv;
    }




}
