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
import static com.wave.controller.utils.CookieUtils.getUserIdFromCookie;

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
        if (referralId != null) {
            referralData = referralService.getReferralData(referralId);
        }


        ReferralCommand referralCommand = new ReferralCommand();
        referralCommand.setPatient(new PatientCommand());
        if (referralData != null) {
            referralCommand = getReferralCommand(referralData);
        }


        mv.addObject("referralCommand", referralCommand);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveReferral(@ModelAttribute("referralCommand") ReferralCommand referralCommand,
                               @CookieValue(value = "TRIAGE", required = true) String cookie) {

        Long userId = getUserIdFromCookie(cookie);
        referralService.saveReferralData(getReferralData(referralCommand, userId));


        return "redirect:dashboard";

    }

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public ModelAndView checkout(@ModelAttribute("referralCommand") ReferralCommand referralCommand,
                                 @CookieValue(value = "TRIAGE", required = true) String cookie) {

        Long userId = getUserIdFromCookie(cookie);
        referralService.checkoutReferralData(referralCommand.getId(), userId);

        return new ModelAndView(new RedirectView("../dashboard"));


    }

    @RequestMapping(value = "/release", method = RequestMethod.POST)
    public ModelAndView release(@ModelAttribute("referralCommand") ReferralCommand referralCommand,
                                @CookieValue(value = "TRIAGE", required = true) String cookie) {

        Long userId = getUserIdFromCookie(cookie);
        referralService.releaseReferralData(referralCommand.getId(), userId);

        return new ModelAndView(new RedirectView("../dashboard"));


    }


    private ReferralData getReferralData(ReferralCommand referralCommand, Long userId) {

        ReferralData referralData = new ReferralData();
        if (referralCommand.getId() != null) {
            referralData = referralService.getReferralData(referralCommand.getId());
        }

        referralData.setActive(referralCommand.isActive());
        referralData.setUbrn(referralCommand.getUbrn());
        referralData.setDescription(referralCommand.getDescription());
        referralData.setType(referralCommand.getType());

        List<ReferralStatusData> referralStatusDatasOld = referralData.getReferralStatusDatas();
        if (referralStatusDatasOld == null || referralStatusDatasOld.size() == 0) {

            ArrayList<ReferralStatusData> referralStatusDatas = new ArrayList<ReferralStatusData>();

            ReferralStatusData referralStatusData = new ReferralStatusData();
            referralStatusData.setLastUpdated(new Date());
            UserData user = userDao.getUserData(userId);
            referralStatusData.setUser(user);
            referralStatusData.setToStatus(Status.NEW);
            referralStatusData.setReferralData(referralData);
            referralStatusDatas.add(referralStatusData);

            referralData.setReferralStatusDatas(referralStatusDatas);
            referralData.setStatus(Status.NEW);
            referralData.setUser(null);
            referralData.setCreatedBy(user);
        } else {
            ReferralStatusData referralStatusData = new ReferralStatusData();
            referralStatusData.setLastUpdated(new Date());
            UserData user = userDao.getUserData(userId);
            referralStatusData.setUser(user);
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
        if (patientData == null) {
            patientData = new PatientData();
        }

        patientData.setNhsNumber(patientCommand.getNhsNumber());
        return patientData;
    }


}
