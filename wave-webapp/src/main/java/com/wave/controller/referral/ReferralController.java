package com.wave.controller.referral;

import com.wave.controller.command.UserCommand;
import com.wave.patient.PatientData;
import com.wave.referral.ReferralData;
import com.wave.referral.service.ReferralService;
import com.wave.referrer.ReferrerData;
import com.wave.user.UserService;
import com.wave.user.dao.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping(value = "/referral")
public class ReferralController {


    @Autowired
    ReferralService referralService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showForm(@RequestParam(value = "referralId", required = false) Long referralId) {
        ModelAndView mv = new ModelAndView("referral");

            ReferralData referralData = new ReferralData(); //referralService.getReferralData(1L);

        referralData.setPatient(new PatientData());
        mv.addObject("referralData", referralData);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView printWelcome(@ModelAttribute("referralData") ReferralData referralData) {


        referralService.saveReferralData(referralData);

        ModelAndView mv = new ModelAndView("referral");
        mv.addObject("referralData", referralData);
        return mv;

    }
}
