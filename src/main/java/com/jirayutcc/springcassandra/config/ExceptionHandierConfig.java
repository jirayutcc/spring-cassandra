package com.jirayutcc.springcassandra.config;

import com.jirayutcc.springcassandra.exception.BusinessException;
import com.jirayutcc.springcassandra.exception.GeneralException;
import com.jirayutcc.springcassandra.models.ErrorResponse;
import com.jirayutcc.springcassandra.utils.ErrorMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandierConfig {

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.OK)
    public ErrorResponse exception(Exception ex) {
        log.error("Exception : ", ex);
        ErrorResponse resp = new ErrorResponse();
        resp.setStatus(ErrorMapping.CODE9999.getCode());
        resp.setMessage(ErrorMapping.CODE9999.getMessage());

        return resp;
    }

    @ExceptionHandler(value = {GeneralException.class})
    @ResponseStatus(HttpStatus.OK)
    public ErrorResponse generalException(GeneralException ex) {
        log.error("GeneralException : ", ex);
        ErrorResponse resp = new ErrorResponse();
        resp.setStatus(ErrorMapping.CODE9999.getCode());
        resp.setMessage(ErrorMapping.CODE9999.getMessage());

        return resp;
    }

    @ExceptionHandler(value = {BusinessException.class})
    @ResponseStatus(HttpStatus.OK)
    public ErrorResponse businessException(BusinessException ex) {
        log.error("BusinessException : ", ex);
        ErrorResponse resp = new ErrorResponse();
        resp.setStatus(ex.getCode());
        resp.setMessage(ex.getMessage());

        return resp;
    }
}
