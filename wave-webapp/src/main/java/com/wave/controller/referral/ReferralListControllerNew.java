package com.wave.controller.referral;

import com.wave.controller.command.PatientCommand;
import com.wave.controller.command.ReferralCommand;
import com.wave.patient.PatientData;
import com.wave.referral.ReferralData;
import com.wave.referral.service.ReferralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/referrallistnew")
public class ReferralListControllerNew {


    @Autowired
    ReferralService referralService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showForm(@RequestParam(value = "page", required = false) Long page, @RequestParam(value = "type", required = false) Long type) {
        ModelAndView mv = new ModelAndView("referrallist");
        List<ReferralData> allReferrals = referralService.getAllReferrals();

        List<ReferralCommand> referrals = new ArrayList<ReferralCommand>();
        for (ReferralData referralData : allReferrals) {
            ReferralCommand referralCommand = Converter.getReferralCommand(referralData);

            referrals.add(referralCommand);
        }


        mv.addObject("referrals", referrals);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView saveReferral(@ModelAttribute("referralCommand") ReferralCommand referralCommand) {


        referralService.saveReferralData(getReferralData(referralCommand));

        ModelAndView mv = new ModelAndView("referral");
        mv.addObject("referralCommand", referralCommand);
        return mv;

    }


    private ReferralData getReferralData(ReferralCommand referralCommand) {

        ReferralData referralData = new ReferralData();

        referralData.setActive(referralCommand.isActive());
        referralData.setUbrn(referralCommand.getUbrn());
        referralData.setDescription(referralCommand.getDescription());
        referralData.setType(referralCommand.getType());

        PatientCommand patientCommand = referralCommand.getPatient();
        PatientData patientData = getPatientData(patientCommand);
        referralData.setPatient(patientData);

        return referralData;

    }

    private PatientData getPatientData(PatientCommand patientCommand) {
        PatientData patientData = new PatientData();

        patientData.setNhsNumber(patientCommand.getNhsNumber());
        return patientData;
    }
}
