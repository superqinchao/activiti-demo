package com.example.lambda.activiti.service.impl;

import com.example.lambda.activiti.service.ActivitiDemoService;
import org.activiti.engine.*;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName ActivitiDemoServiceImpl
 * @Description TODO
 * @Author Chao.Qin
 * @Datw 2019/9/2 14:22
 */
public class ActivitiDemoServiceImpl implements ActivitiDemoService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private HistoryService historyService;

    public void test(){
        //项目中每创建一个新用户，对应的要创建一个Activiti用户
        //两者的userId和userName一致
        User user = identityService.newUser("1");
        user.setLastName("总经理");
        identityService.saveUser(user);

        //项目中每创建一个角色，对应的要创建一个Activiti用户组
        Group group = identityService.newGroup("1");
        group.setName("经理");
        identityService.saveGroup(group);

        //用户与用户组关系绑定
        identityService.createMembership("1","1");

    }
}
