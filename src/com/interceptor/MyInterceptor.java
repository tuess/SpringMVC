package com.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截器，必须实现接口HandlerInterceptor，然后将拦截器配置在springMVC中
public class MyInterceptor implements HandlerInterceptor {
//    拦截请求
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("拦截请求");
//        return true/false表示拦截后是否放行，相当于Filter中的chain
        return true;
    }

//    拦截响应
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截响应");
    }

//    页面渲染完毕之后触发
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("页面渲染完毕");
    }
}
