package me.leshchenkor.springcatalog.controller;

import me.leshchenkor.springcatalog.entity.BaseResponse;
import me.leshchenkor.springcatalog.exceptions.NotFoundProductException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProductAppControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundProductException.class)
    public BaseResponse handleNotFoundProduct(Exception exception, WebRequest webRequest ) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setErrorCode(1);
        baseResponse.setErrorMessage(exception.getMessage());
        return baseResponse;
    }
}
