package com.wave.controller.referral;

import com.wave.address.AddressData;
import com.wave.contact.ContactData;
import com.wave.controller.command.*;
import com.wave.controller.utils.Converter;
import com.wave.gender.Gender;
import com.wave.master.EthnicityData;
import com.wave.master.dao.title.TitleDao;
import com.wave.master.service.ethnicity.EthnicityService;
import com.wave.master.service.title.TitleService;
import com.wave.name.NameData;
import com.wave.patient.PatientData;
import com.wave.referral.ReferralData;
import com.wave.referral.service.ReferralService;
import com.wave.referralstatus.ReferralStatusData;
import com.wave.referrer.dao.ReferrerDao;
import com.wave.status.Status;
import com.wave.user.dao.UserDao;
import com.wave.user.dao.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.wave.controller.utils.Converter.getReferralCommand;
import static com.wave.controller.utils.CookieUtils.getUserIdFromCookie;

@Controller
@RequestMapping(value = "/referral")
public class ReferralController {


    @Autowired
    ReferralService referralService;

    @Autowired
    UserDao userDao;

    @Autowired
    TitleService titleService;

    @Autowired
    EthnicityService ethnicityService;

    @Autowired
    ReferrerDao referrerDao;


    @RequestMapping( method = RequestMethod.GET)
    public ModelAndView showForm(@RequestParam(value = "referralId", required = false) Long referralId) {
        return getReferralData(referralId, "referral");
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveReferral(@ModelAttribute("referralCommand") ReferralCommand referralCommand,
                               @CookieValue(value = "TRIAGE", required = true) String cookie) {

        Long userId = getUserIdFromCookie(cookie);
        referralService.saveReferralData(getReferralData(referralCommand, userId));


        return "redirect:dashboard";

    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView showReferral(@RequestParam(value = "referralId", required = false) Long referralId) {
        return getReferralData(referralId, "referralView");
    }

    private ModelAndView getReferralData(Long referralId, String view) {
        ModelAndView mv = new ModelAndView(view);

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
        mv.addObject("titleList", Converter.getTitleCommands(titleService.getAllTitleData()));
        mv.addObject("genders", Gender.values());
        mv.addObject("ethnicity", Converter.getEthnicityCommands(ethnicityService.getAllEthnicityData()));

        return mv;
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

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public ModelAndView validate(@ModelAttribute("referralCommand") ReferralCommand referralCommand,
                                @CookieValue(value = "TRIAGE", required = true) String cookie) {

        Long userId = getUserIdFromCookie(cookie);
        referralService.validate(referralCommand.getId(), userId);

        return new ModelAndView(new RedirectView("../dashboard"));


    }

    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    public ModelAndView reject(@ModelAttribute("referralCommand") ReferralCommand referralCommand,
                                 @CookieValue(value = "TRIAGE", required = true) String cookie) {

        Long userId = getUserIdFromCookie(cookie);
        referralService.setReferralStatus(referralCommand.getId(), userId, Status.IN_VALIDATION);

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
        patientData.setDateOfBirth(patientCommand.getDateOfBirth());
        EthnicityData ethnicityData = getEthnicityData(patientCommand.getEthnicity());
        patientData.setEthnicity(ethnicityData);
        patientData.setGender(patientCommand.getGender());

        patientData.setLastUpdated(new Date());

        patientData.setAddress(getAddressData(patientCommand.getAddress(), patientData.getAddress()));

        patientData.setContactDetails(getContactData(patientData.getContactDetails(), patientCommand.getContactDetails()));
        patientData.setNameData(getNameData(patientCommand.getName(), patientData.getNameData()));


        patientData.setPrimarySpokenLanguage(patientCommand.getPrimarySpokenLanguage());
        patientData.setSecondarySpokenLanguage(patientCommand.getSecondarySpokenLanguage());
        patientData.setWrittenLanguage(patientCommand.getWrittenLanguage());
        patientData.setAssistanceRequired(patientCommand.isAssistanceRequired());
        patientData.setInterpreterRequired(patientCommand.isInterpreterRequired());

        return patientData;
    }

    private NameData getNameData(NameCommand nameCommand, NameData nameData) {
        if(nameData == null) {
            nameData = new NameData();
        }

        nameData.setFirstName(nameCommand.getFirstName());
        nameData.setMiddleName(nameCommand.getMiddleName());
        nameData.setLastName(nameCommand.getLastName());
        nameData.setPreferredName(nameCommand.getPreferredName());
        TitleCommand titleCommand = nameCommand.getTitle();

        nameData.setTitle(titleService.getTitleData(titleCommand.getId()));
        return nameData;
    }

    private ContactData getContactData(ContactData contactDetails, ContactCommand contactDetailsCommand) {
        if(contactDetails == null) {
            contactDetails = new ContactData();
        }

        contactDetails.setEmail(contactDetailsCommand.getEmail());
        contactDetails.setMobile(contactDetailsCommand.getMobile());
        contactDetails.setPhone(contactDetailsCommand.getPhone());
        contactDetails.setPreferred(contactDetailsCommand.getPreferred());
        return contactDetails;
    }

    private AddressData getAddressData(AddressCommand address, AddressData addressData) {
        if(addressData == null) {
            addressData = new AddressData();
        }


        addressData.setCity(address.getCity());
        addressData.setCounty(address.getCounty());
        addressData.setCountry(address.getCountry());
        addressData.setLine1(address.getLine1());
        addressData.setLine2(address.getLine2());
        addressData.setLine3(address.getLine3());
        addressData.setPostCode(address.getPostCode());
        return addressData;
    }

    private EthnicityData getEthnicityData(EthnicityCommand ethnicity) {
        return ethnicityService.getEthnicityData(ethnicity.getId());

    }


    @InitBinder
    protected void initBinder(HttpServletRequest request,
                              ServletRequestDataBinder binder) throws Exception
    {
        // bind empty strings as null
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

}
