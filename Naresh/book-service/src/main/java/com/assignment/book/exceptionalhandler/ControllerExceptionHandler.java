package com.assignment.book.exceptionalhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
   ErrorMessage message = new ErrorMessage(500,new Date(),"Something went wrong,Please try later","lease try later");
    return message;
  }
}
