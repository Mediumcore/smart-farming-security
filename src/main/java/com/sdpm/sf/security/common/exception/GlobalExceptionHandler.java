package com.sdpm.sf.security.common.exception;

import com.sdpm.sf.security.common.rest.RestMessage;
import com.sdpm.sf.security.common.rest.ResultStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 *
 * @author rukey
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestMessage jsonErrorHandler(HttpServletRequest req, HttpServletResponse response, Exception e) {
        e.printStackTrace();
        RestMessage restMessage = new RestMessage();
        restMessage.setSuccess(false);
        restMessage.setMsg(e.getMessage());
        if (e instanceof SmartFarmingSecurityException) {
            restMessage.setCode(ResultStatus.application_error.getErrorCode());
        } else if (e instanceof RuntimeException) { //500
            restMessage.setCode(ResultStatus.http_status_internal_server_error.getErrorCode());
        } else {
            restMessage.setCode(ResultStatus.EXCEPTION.getErrorCode());
            response.setStatus(ResultStatus.EXCEPTION.getErrorCode());
        }
        return restMessage;
    }
}
