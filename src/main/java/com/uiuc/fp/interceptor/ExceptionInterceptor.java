package com.uiuc.fp.interceptor;

import com.uiuc.fp.interceptor.dto.ExceptionDto;
import com.uiuc.fp.exception.ValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;


@ControllerAdvice
public class ExceptionInterceptor {

  @ExceptionHandler(ValidationException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ExceptionDto handleValidationException(ValidationException ex) {
    return new ExceptionDto("400", ex.getMessage());
  }

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ExceptionDto handleConstraintViolationException(ConstraintViolationException ex) {
    Optional<ConstraintViolation<?>> violation = ex.getConstraintViolations().stream().findFirst();
    return new ExceptionDto("400", violation.isPresent() ? violation.get().getMessage() : ex.getMessage());
  }
}
