package com.example.spring.Advice;

import com.example.spring.Exception.CustomException;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> InvalidArgumentHandler(MethodArgumentNotValidException ex){
        Map<String,String> errorMap=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            errorMap.put(error.getField(),error.getDefaultMessage()));
        return errorMap;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
   @ExceptionHandler(CustomException.class)
    public Map<String,String> ManualHandler(CustomException ex){
        Map<String ,String > errorMap=new HashMap<>();
        errorMap.put("Error ",ex.getMessage());
        return errorMap;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String,String> NoObject(HttpMessageNotReadableException ex){
        Map<String ,String > errorMap=new HashMap<>();
        errorMap.put("Error ","Data missing or incorrect in the object");
        return errorMap;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UsernameNotFoundException.class)
    public Map<String,String> NoUser(UsernameNotFoundException ex){
        Map<String ,String > errorMap=new HashMap<>();
        errorMap.put("Error ","User not found");
        return errorMap;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Map<String,String> WrongMethod(HttpRequestMethodNotSupportedException ex){
        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("Error ","Choose correct method");
        return errorMap;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UnexpectedTypeException.class)
    public Map<String,String> WrongType(UnexpectedTypeException ex){
        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("Error ","Enter valid data");
        return errorMap;
    }
}
