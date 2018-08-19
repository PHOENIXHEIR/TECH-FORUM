package com.practice.springbootdemo.com.practice.springbootdemo.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**Error handler.
 * Created by debanikd on 7/20/2018.
 */
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value=Exception.class)
    public ModelAndView handleException(Exception exception){
        ModelAndView modelAndView =  new ModelAndView("error");
        modelAndView.addObject("error", exception.getMessage());
        return modelAndView;
    }
}
