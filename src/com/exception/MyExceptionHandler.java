package com.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//此注解代表该类是专业处理异常的类，该注解
@ControllerAdvice
public class MyExceptionHandler {
//    该注解@ControllerAdvice中的异常除了方法可以处理任何类中的异常
    @ExceptionHandler({Exception.class})
    public ModelAndView handlerException(Exception e){
        ModelAndView mv = new ModelAndView("error");
        System.out.println(e+"该注解@ControllerAdvice中的异常除了方法可以处理任何类中的异常");
        mv.addObject("e",e);
        return mv;
    }
}
