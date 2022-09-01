package com.example.log.controller;

import com.example.log.annotation.LoggerAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    //运行起来，在浏览器输入下面的网址即可看效果。idea控制台有相应打印效果
    //http://localhost:1001/log/updateEmp?empName=cl&phone=333
    //这边用get是为了直接在url里写参数。实际更新操作是要用post的
    @GetMapping("/updateEmp")
    @LoggerAnnotation(modelName = LoggerAnnotation.Logger.update_emp)  //改了数据库的操作都要加上这个注解。
    public String updateEmp(String empName, String phone){
        System.out.println("1111111111111111111111111");
        return "1111111111111111111111111";
    }

}
