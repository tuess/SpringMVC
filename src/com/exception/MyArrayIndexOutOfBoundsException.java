package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "数组越界！")
public class MyArrayIndexOutOfBoundsException extends Exception {
//    自定义异常，以后如果抛出该异常且如果没有被捕获的话会显示在前端页面
}
