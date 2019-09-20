package com.example.lambda.web;

import com.example.lambda.generator.mapper.HiTaskinstMapper;
import com.example.lambda.generator.pojo.HiTaskinst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ActivitiCollection
 * @Description TODO
 * @Author Chao.Qin
 * @Datw 2019/9/9 15:03
 */
@RestController
public class ActivitiController {

    @RequestMapping("/test")
    public String test() {
        System.out.println("hello word!!");
        return "hello word!!";
    }

    @Autowired
    private HiTaskinstMapper hiTaskinstMapper;

    @RequestMapping("ttt")
    public void test1() {
        HiTaskinst hiTaskinst = hiTaskinstMapper.selectByPrimaryKey("10005");
        System.out.println(hiTaskinst);
    }
}
