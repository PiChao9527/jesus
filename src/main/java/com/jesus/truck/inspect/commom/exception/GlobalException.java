package com.jesus.truck.inspect.commom.exception;

import com.jesus.truck.inspect.vo.ResBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
@ResponseBody
public class GlobalException {

    /**
     * 处理自定义异常
     * @param e BusinessException
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public ResBean<String> businessException(BusinessException e) {
        log.error("业务异常 code={}, BusinessException = {}", e.getCode(), e.getMessage(), e);
        return ResBean.error(e.getCode(), e.getMsg());
    }

    /**
     * 处理空指针的异常
     * @param e NullPointerException
     * @return
     * @description 空指针异常定义为前端传参错误，返回400
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ResBean<String> nullPointerException(NullPointerException e) {
        log.error("空指针异常 NullPointerException ", e);
        return ResBean.error(ReturnCode.RC400.getCode(), ReturnCode.RC400.getMsg());
    }

    /**
     * 处理404异常
     * @param e NoHandlerFoundException
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResBean<String> noHandlerFoundException(HttpServletRequest req, Exception e) {
        log.error("404异常 NoHandlerFoundException, method = {}, path = {} ", req.getMethod(), req.getServletPath(), e);
        return ResBean.error(ReturnCode.RC404.getCode(), ReturnCode.RC404.getMsg());
    }

    /**
     * 处理请求方式错误(405)异常
     * @param e HttpRequestMethodNotSupportedException
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResBean<String> HttpRequestMethodNotSupportedException(HttpServletRequest req, Exception e) {
        log.error("请求方式错误(405)异常 HttpRequestMethodNotSupportedException, method = {}, path = {}", req.getMethod(), req.getServletPath(), e);
        return ResBean.error(ReturnCode.RC405.getCode(), ReturnCode.RC405.getMsg());
    }

    /**
     * 处理其他异常
     * @param e otherException
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResBean<String> exception(Exception e) {
        log.error("未知异常 exception = {}", e.getMessage(), e);
        return ResBean.error(ReturnCode.RC500.getCode(), ReturnCode.RC500.getMsg());
    }
}
