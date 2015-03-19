package com.wave.controller.referral;

import com.wave.controller.command.PatientCommand;
import com.wave.controller.command.ReferralCommand;
import com.wave.patient.PatientData;
import com.wave.referral.ReferralData;
import com.wave.referral.service.ReferralService;
import com.wave.referralstatus.ReferralStatusData;
import com.wave.status.Status;
import com.wave.user.dao.UserDao;
import com.wave.user.dao.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.wave.controller.referral.Converter.getReferralCommand;

@Controller
@RequestMapping(value = "/referral")
public class ReferralController {


    @Autowired
    ReferralService referralService;

    @Autowired
    UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showForm(@RequestParam(value = "referralId", required = false) Long referralId) {
        ModelAndView mv = new ModelAndView("referral");

        ReferralData referralData = new ReferralData();
        if(referralId != null) {
            referralData = referralService.getReferralData(referralId);
        }


        ReferralCommand referralCommand = new ReferralCommand();
        referralCommand.setPatient(new PatientCommand());
        if(referralData != null) {
            referralCommand =  getReferralCommand(referralData);
        }


        mv.addObject("referralCommand", referralCommand);
        return mv;
    }

    @RequestMapping( method = RequestMethod.POST)
    public String saveReferral(@ModelAttribute("referralCommand") ReferralCommand referralCommand) {


        referralService.saveReferralData(getReferralData(referralCommand));


        return "redirect:referrallist";

    }

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public ModelAndView checkout(@ModelAttribute("referralCommand") ReferralCommand referralCommand,
                           @CookieValue(value = "TRIAGE", required = true) String cookie) {

        String[] cookieKeyVal = cookie.split("=");
        Long userId = null;
        if("USER_ID".equals(cookieKeyVal[0])) {
             userId = Long.parseLong(cookieKeyVal[1]);
        }
        referralService.checkoutReferralData(referralCommand.getId(), userId);

        return new ModelAndView(new RedirectView("../referrallist"));


    }


    private ReferralData getReferralData(ReferralCommand referralCommand) {

        ReferralData referralData = new ReferralData();
        if(referralCommand.getId() != null) {
            referralData = referralService.getReferralData(referralCommand.getId());
        }

        referralData.setActive(referralCommand.isActive());
        referralData.setUbrn(referralCommand.getUbrn());
        referralData.setDescription(referralCommand.getDescription());
        referralData.setType(referralCommand.getType());

        List<ReferralStatusData> referralStatusDatasOld = referralData.getReferralStatusDatas();
        if(referralStatusDatasOld == null || referralStatusDatasOld.size() == 0) {

        ArrayList<ReferralStatusData> referralStatusDatas = new ArrayList<ReferralStatusData>();

        ReferralStatusData referralStatusData = new ReferralStatusData();
        referralStatusData.setLastUpdated(new Date());
        UserData admin = userDao.getUserByUserName("admin");
        referralStatusData.setUser(admin);
        referralStatusData.setToStatus(Status.NEW);
        referralStatusData.setReferralData(referralData);
        referralStatusDatas.add(referralStatusData);

        referralData.setReferralStatusDatas(referralStatusDatas);
        }else{
            ReferralStatusData referralStatusData = new ReferralStatusData();
            referralStatusData.setLastUpdated(new Date());
            UserData admin = userDao.getUserByUserName("admin");
            referralStatusData.setUser(admin);
            referralStatusData.setToStatus(Status.UPDATE);
            referralStatusData.setReferralData(referralData);
            referralStatusDatasOld.add(referralStatusData);

            referralData.setReferralStatusDatas(referralStatusDatasOld);
        }
        PatientCommand patientCommand = referralCommand.getPatient();
        PatientData patientData = getPatientData(referralData.getPatient(), patientCommand);
        referralData.setPatient(patientData);

        return referralData;

    }

    private PatientData getPatientData(PatientData patientData, PatientCommand patientCommand) {
        if(patientData == null) {
             patientData = new PatientData();
        }

        patientData.setNhsNumber(patientCommand.getNhsNumber());
        return patientData;
    }



}
