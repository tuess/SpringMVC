package com.converter;

import com.entity.Student;
import org.springframework.core.convert.converter.Converter;

//自定义转换器
public class MyConverter implements Converter<String, Student> {
    @Override
    public Student convert(String s) {
//        接收前端传来的字符串2-ls
        Student student = new Student();
        String[] studentArray = s.split("-");
        student.setId(Integer.parseInt(studentArray[0]));
        student.setName((studentArray[1]));
        return student;
    }
}
