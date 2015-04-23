package com.wave.controller.referral;

import com.wave.command.ReferralCommand;
import com.wave.controller.utils.Converter;
import com.wave.referral.ReferralData;
import com.wave.referral.service.ReferralService;
import com.wave.status.Status;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
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
public class ReferralListController {


    @Autowired
    ReferralService referralService;

    @Value("${page.size}")
    private Integer pageSize;

    @Autowired
    private TaskService taskService;


    @RequestMapping(value = "/referrallistview", method = RequestMethod.GET)
    public ModelAndView createForm(@RequestParam(value = "type", required = false) Status type,
                                 @CookieValue(value = "TRIAGE", required = true) String cookie,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {

        Long userId = getUserIdFromCookie(cookie);




        ModelAndView mv = new ModelAndView("/referrallistview");
        List<ReferralData> allReferrals = null;

        if(Status.NEW == type || type == null){
            TaskQuery taskUnassigned = taskService.createTaskQuery().taskCandidateGroup("validator").taskUnassigned();
            allReferrals = getReferralDatas(type, page, mv, taskUnassigned);
        }else if(Status.CHECKOUT == type){
            TaskQuery taskUnassigned = taskService.createTaskQuery().taskAssignee(userId+"");
            allReferrals = getReferralDatas(type, page, mv, taskUnassigned);

           // allReferrals = referralService.getAllReferralsByStatus(type, userId);
          //  Long allReferralsCountByStatus = referralService.getAllReferralsCountByStatus(type, userId);
          //  mv.addObject("paginations", getPaginationCommand(page, allReferralsCountByStatus, pageSize));
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

    private List<ReferralData> getReferralDatas(Status type, Integer page, ModelAndView mv, TaskQuery taskUnassigned) {
        List<ReferralData> allReferrals = new ArrayList<ReferralData>();
        long count = taskUnassigned.count();
        List<Task> tasks = taskUnassigned.list();
        List<String> processIds = new ArrayList<String>();
        for (Task task : tasks) {

            String processInstanceId = task.getProcessInstanceId();
            processIds.add(processInstanceId);
            System.out.println("processInstanceId " + processInstanceId);
        }

        if(processIds != null && !processIds.isEmpty()) {
            allReferrals = referralService.getAllReferralsByProcessIds(processIds);
        }


        Long allReferralsCountByStatus = referralService.getAllReferralsCountByStatus(type);
        mv.addObject("paginations", getPaginationCommand(page, allReferralsCountByStatus, pageSize));
        return allReferrals;
    }


}
