package com.wave.controller.referral;

import com.wave.address.AddressData;
import com.wave.command.*;
import com.wave.contact.ContactData;
import com.wave.controller.utils.Converter;
import com.wave.destination.IGRDestinationData;
import com.wave.gender.Gender;
import com.wave.master.EthnicityData;
import com.wave.master.service.ethnicity.EthnicityService;
import com.wave.master.service.title.TitleService;
import com.wave.name.NameData;
import com.wave.patient.PatientData;
import com.wave.referral.ReferralData;
import com.wave.referral.service.ReferralService;
import com.wave.referralstatus.ReferralStatusData;
import com.wave.referrer.ReferrerData;
import com.wave.referrer.dao.ReferrerDao;
import com.wave.role.RoleData;
import com.wave.role.dao.RoleDao;
import com.wave.status.Status;
import com.wave.user.dao.UserDao;
import com.wave.user.dao.UserData;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    RoleDao roleDao;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private TaskService taskService;


    @RequestMapping( method = RequestMethod.GET)
    public ModelAndView showForm(@RequestParam(value = "referralId", required = false) Long referralId) {
        return getReferralCommandAndMasterCommands(referralId, "referral");
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveReferral(@ModelAttribute("referralCommand") ReferralCommand referralCommand,
                               @CookieValue(value = "TRIAGE", required = true) String cookie) {

        Long userId = getUserIdFromCookie(cookie);

        boolean newProcess = false;
        if(StringUtils.isEmpty(referralCommand.getProcessId())) {
            ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("referral");
            String processId = processInstance.getId();
            referralCommand.setProcessId(processId);
            newProcess = true;
        }

        ReferralData referralData = getReferralData(referralCommand, userId);
        referralService.saveReferralData(referralData);


        if(newProcess) {
            TaskQuery taskQuery = taskService.createTaskQuery().processInstanceId(referralCommand.getProcessId());
            List<Task> list = taskQuery.list();
            Task task = taskQuery.singleResult();
            // for (Task task : tasks) {
            System.out.println("Following task is available for accountancy group: " + task.getName());
            String processInstanceId = task.getProcessInstanceId();
            // claim it
            taskService.claim(task.getId(), userId + "");
            taskService.complete(task.getId());
            // }
        }

        return "redirect:referrallistview";

    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView showReferral(@RequestParam(value = "referralId", required = false) Long referralId) {
        return getReferralCommandAndMasterCommands(referralId, "referral");
    }

    private ModelAndView getReferralCommandAndMasterCommands(Long referralId, String view) {
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

        List<RoleData> roles = roleDao.getAllRoles();
        mv.addObject("roles", Converter.getAllRoleCommands(roles));

        return mv;
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public ModelAndView checkout(@ModelAttribute("referralCommand") ReferralCommand referralCommand,
                                 @CookieValue(value = "TRIAGE", required = true) String cookie) {

        Long userId = getUserIdFromCookie(cookie);

        TaskQuery taskQuery = taskService.createTaskQuery().processInstanceId(referralCommand.getProcessId());
        List<Task> list = taskQuery.list();
        Task task = taskQuery.singleResult();
        // for (Task task : tasks) {
        System.out.println("Following task is available for accountancy group: " + task.getName());
        String processInstanceId = task.getProcessInstanceId();
        // claim it
        taskService.claim(task.getId(), userId+"");

        referralService.checkoutReferralData(referralCommand.getId(), userId);

        return new ModelAndView(new RedirectView("../referrallistview?type=NEW"));
    }

    @RequestMapping(value = "/release", method = RequestMethod.POST)
    public ModelAndView release(@ModelAttribute("referralCommand") ReferralCommand referralCommand,
                                @CookieValue(value = "TRIAGE", required = true) String cookie) {

        Long userId = getUserIdFromCookie(cookie);

        TaskQuery taskQuery = taskService.createTaskQuery().processInstanceId(referralCommand.getProcessId());
        List<Task> list = taskQuery.list();
        Task task = taskQuery.singleResult();
        // for (Task task : tasks) {
        System.out.println("Following task is available for accountancy group: " + task.getName());
        String processInstanceId = task.getProcessInstanceId();
        // claim it
        taskService.unclaim(task.getId());

        referralService.releaseReferralData(referralCommand.getId(), userId);

        return new ModelAndView(new RedirectView("../referrallistview?type=CHECKOUT"));


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

        ReferralData referralData = null;
        if (referralCommand.getId() != null) {
            referralData = referralService.getReferralData(referralCommand.getId());
        } else{
            referralData = new ReferralData();
            referralData.setId(null);
            referralData.setVersion(0l);
        }

        referralData.setProcessId(referralCommand.getProcessId());
        referralData.setActive(referralCommand.isActive());
        referralData.setCreateDate(referralCommand.getCreateDate());
        referralData.setUbrn(referralCommand.getUbrn());
        referralData.setDescription(referralCommand.getDescription());
        referralData.setType(referralCommand.getType());

        referralData.setIgrDestinationData(getIGRDestinationData(referralCommand.getIgrDestination(), referralData.getIgrDestinationData()));

        List<ReferralStatusData> referralStatusDatasOld = referralData.getReferralStatusDatas();
        if (referralData.getId() == null) {

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
            if(referralStatusDatasOld == null) {
                referralStatusDatasOld = new ArrayList<ReferralStatusData>();
            }
            referralStatusDatasOld.add(referralStatusData);

            referralData.setReferralStatusDatas(referralStatusDatasOld);
        }
        PatientCommand patientCommand = referralCommand.getPatient();
        PatientData patientData = getPatientData(referralData.getPatient(), patientCommand);
        referralData.setPatient(patientData);


        ReferrerCommand referrerCommand = referralCommand.getReferrer();
        ReferrerData referrerData = referralData.getReferrerData();
        referrerData = getReferrerData(referrerCommand, referrerData);

        referralData.setReferrerData(referrerData);



        return referralData;

    }

    private ReferrerData getReferrerData(ReferrerCommand referrerCommand, ReferrerData referrerData) {
        if(referrerData == null) {
            referrerData = new ReferrerData();
        }

        RoleCommand role = referrerCommand.getRole();
        RoleData roleData = roleDao.getRoleData(role.getId());

        referrerData.setPracticeCode(referrerCommand.getPracticeCode());
        referrerData.setPracticeName(referrerCommand.getPracticeName());
        referrerData.setSpeciality(referrerCommand.getSpeciality());
        referrerData.setRoleData(roleData);
        referrerData.setAddress(getAddressData(referrerCommand.getAddress(), referrerData.getAddress()));
        referrerData.setContactDetails(getContactDetailsData(referrerData.getContactDetails(), referrerCommand.getContactDetails()));
        referrerData.setNameData(getNameData(referrerCommand.getName(), referrerData.getNameData()));
        referrerData.setLastUpdated(new Date());

        return referrerData;
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
        patientData.setDateOfBirth(patientCommand.getDateOfBirth());
        patientData.setLastUpdated(new Date());

        patientData.setAddress(getAddressData(patientCommand.getAddress(), patientData.getAddress()));

        patientData.setContactDetails(getContactDetailsData(patientData.getContactDetails(), patientCommand.getContactDetails()));
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
        if(titleCommand != null) {
            nameData.setTitle(titleService.getTitleData(titleCommand.getId()));
        }
        return nameData;
    }

    private ContactData getContactDetailsData(ContactData contactDetails, ContactCommand contactDetailsCommand) {
        if(contactDetails == null) {
            contactDetails = new ContactData();
        }

        contactDetails.setEmail(contactDetailsCommand.getEmail());
        contactDetails.setMobile(contactDetailsCommand.getMobile());
        contactDetails.setFax(contactDetailsCommand.getFax());
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
      //  binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }


    public static IGRDestinationData getIGRDestinationData(IGRDestinationCommand igrDestinationCommand, IGRDestinationData igrDestinationData){
        if(igrDestinationData == null) {
            igrDestinationData = new IGRDestinationData();
        }

        if(igrDestinationCommand != null) {

            igrDestinationData.setName(igrDestinationCommand.getName());
            igrDestinationData.setPracticeName(igrDestinationCommand.getPracticeName());
            igrDestinationData.setReferredTo(igrDestinationCommand.getReferredTo());
            igrDestinationData.setRegisteredName(igrDestinationCommand.getRegisteredName());
            igrDestinationData.setRegisteredPracticeName(igrDestinationCommand.getRegisteredPracticeName());
            igrDestinationData.setSpecialty(igrDestinationCommand.getSpecialty());
        }

        return igrDestinationData;
    }

}
