package com.controller;

import com.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/FormDemo")
public class FormDemo {

    @RequestMapping("testForm")
    public String testForm(Map<String,Object> map){
        Student student = new Student();
        student.setId(10001);
        student.setName("wqq");
        student.setSex(true);
        List<String> hobbies = new ArrayList<>();
        hobbies.add("football");
        hobbies.add("basketball");
        student.setHobbies(hobbies);
//        默认put的key为command
        map.put("command",student);
        return "forward:/springEL.jsp";
    }

    @RequestMapping(value = "testMethod",method = RequestMethod.DELETE)
    public String testDelete(){
        System.out.println("delete---");
        return "index";
    }

    @RequestMapping(value = "testMethod",method = RequestMethod.PUT)
    public String testPut(){
        System.out.println("put---");
        return "index";
    }
}