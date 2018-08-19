package com.practice.springbootdemo.handlers;

import com.practice.springbootdemo.exceptions.PermissionDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/** Error handler to specify what to return when an error occurs.
 *  All errors are handled the same way, with the exception message returned to the client with "error" tag.
 *  Created by debanikd on 7/20/2018.
 */
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value= {Exception.class})
    public Map handleException(Exception exception){
        Map<String, String> map = new HashMap<>();
        map.put("error", exception.getMessage());
        return map;
    }
}
