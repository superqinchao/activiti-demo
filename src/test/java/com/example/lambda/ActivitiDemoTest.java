package com.example.lambda;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName A
 * @Description TODO
 * @Author Chao.Qin
 * @Datw 2019/9/5 16:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiDemoTest {

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

    /**
     * 发布流程
     *
     * @throws IOException
     */
    @Test
    public void deploymentProcesses_zip() throws IOException {

        Deployment deploy = repositoryService.createDeployment()//创建一个部署的对象
                .name("请假流程定义")//创建流程名称
                .addClasspathResource("processes/leaveTask.bpmn")//指定zip完成部署
                .deploy();
//        long count = repositoryService.createProcessDefinitionQuery().count();
        System.out.println("部署id" + deploy.getId());
        System.out.println("部署名称" + deploy.getName());
        System.out.println("部署名称" + deploy.getKey());

//        System.out.println("部署名称"+count);

    }

    private List<Map<String, Object>> data = new ArrayList<>();

    @Before
    public void init() {
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", i + 1);
            map.put("username", "员工" + i);
            map.put("title", "请假" + i);
            map.put("day", i);
            data.add(map);
        }
    }

    /**
     * 启动流程
     * RuntimeService
     */
    @Test
    public void startProcess() {
        String processDefinitionKey = "leaveTask";
        //可根据id、key、message启动流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, "qinchao");
        System.out.println(processInstance.getName());
        System.out.println(processInstance.getProcessDefinitionId());
        System.out.println(processInstance.getId());
    }

    /**
     * 查看任务
     * TaskService
     */
    @Test
    public void queryTask() {
        //根据assignee(代理人)查询任务
        String assignee = "pm";
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(assignee).list();

        int size = tasks.size();
        for (int i = 0; i < size; i++) {
            Task task = tasks.get(i);

        }

        //获取最新一条
        for (Task task : tasks) {
            System.out.println("taskId:" + task.getId() +
                    ",taskName:" + task.getName() +
                    ",assignee:" + task.getAssignee() +
                    ",createTime:" + task.getCreateTime());
        }
    }

    /**
     * 办理任务
     */
    @Test
    public void handleTask() {
        //根据上一步生成的taskId执行任务
        String taskId = "10005";
        // 选通过taskId查询任务
        // getProcessInstanceId()从任务里拿到流程实例id
        String task = taskService.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();
        System.out.println(task);
        // 批注信息
        String message = "批准";
        //当前批准的用户id
//        Authentication.setAuthenticatedUserId("qinchao");
        // 给任务添加批注
        taskService.addComment(taskId, task, message);
        taskService.complete(taskId);
    }

    /**
     * 办理任务
     */
    @Test
    public void handleTask1() {
        //根据上一步生成的taskId执行任务
        String taskId = "47505";
        // 选通过taskId查询任务
        // getProcessInstanceId()从任务里拿到流程实例id
        String task = taskService.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();
        System.out.println(task);
        Map<String, Object> variables = new HashMap<>();
        variables.put("date", 4);
        taskService.complete(taskId, variables);
    }


}
