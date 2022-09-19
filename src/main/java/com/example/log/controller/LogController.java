package com.example.log.controller;

import com.example.log.annotation.LoggerAnnotation;
import com.example.log.pojo.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    //参数传各个字段的。
    //运行起来，在浏览器输入下面的网址即可看效果。idea控制台有相应打印效果
    //http://localhost:1001/log/updateEmp?id=5&empName=cl&phone=333&address=sh
    //这边用get是为了直接在url里写参数。实际更新操作是要用post的
    @GetMapping("/updateEmp")
    @LoggerAnnotation(modelName = LoggerAnnotation.Logger.update_emp)  //改了数据库的操作都要加上这个注解。
    public String updateEmp(Integer id,String empName, String phone, String address){
        System.out.println("1111111111111111111111111");
        return "1111111去idea控制台看效果";
    }

    //参数传对象的。
    //运行起来，在浏览器输入下面的网址即可看效果。idea控制台有相应打印效果
    //http://localhost:1001/log/updateSpend?id=10&params=cl233333
    //这边用get是为了直接在url里写参数。实际更新操作是要用post的
    @GetMapping("/updateSpend")
    @LoggerAnnotation(modelName = LoggerAnnotation.Logger.update_spend)  //改了数据库的操作都要加上这个注解。
    public String updateEmp(Log log){
        System.out.println("22222222222");
        return "222去idea控制台看效果";
    }

}
