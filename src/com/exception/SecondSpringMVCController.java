package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("second")
public class SecondSpringMVCController {

    @RequestMapping("testExceptionHandler")
    public String testExceptionHandler(){
//        这句打印会抛出ArithmeticException异常
        System.out.println(1/0);
        return "success";
    }

//    如果i=3，跳转到testResponseStatus
    @RequestMapping("testMyException")
    public String testMyException(@RequestParam("i") Integer i){
        if(i==3){
            return "redirect:testResponseStatus";
        }
        return "success";
    }

//    在方法前加@ResponseStatus注解也可以让前端显示不同的错误页面
    @ResponseStatus(value = HttpStatus.CHECKPOINT,reason = "测试错误代码！")
    @RequestMapping("testResponseStatus")
    public String testResponseStatus(){
        return "success";
    }

//    该方法可以捕获本类中抛出的ArithmeticException异常，会将异常参数传递给e，然后再打印e。如果捕获多个异常，方法参数需要写成基类exception。方法参数只能有一个
//    异常处理遵循着就近处理的原则，此类中有异常处理方法，则异常会被此类中的方法捕获，而不会被MyExceptionHandler中的方法捕获
    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handlerArithmeticException(ArithmeticException e){
        ModelAndView mv = new ModelAndView("error");
        System.out.println(e);
        mv.addObject("e",e);
        return mv;
    }
}
