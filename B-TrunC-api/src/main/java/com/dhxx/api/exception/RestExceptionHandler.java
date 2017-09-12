package com.dhxx.api.exception;

import com.dhxx.common.message.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// 会被Spring-MVC自动扫描，但又不属于Controller的annotation。
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    
    private static Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    /**
     * 处理RestException.
     */
    @ExceptionHandler(value = { RestException.class })
    public ResponseMessage toResponse(BusinessException ex) {
        log.debug("业务异常>>>>>>>>>>>>>>>code:" + ex.getCode() + ", message:" + ex.getMsg());
        ResponseMessage rm = new ResponseMessage(false, ex.getMsg());
        return rm;
    }
}