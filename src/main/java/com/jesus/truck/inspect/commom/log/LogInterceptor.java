package com.jesus.truck.inspect.commom.log;

import com.jesus.truck.inspect.commom.SystemConstant;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class LogInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String traceId = request.getHeader(SystemConstant.TRACE_LOG_ID);
        if (traceId == null) {
            traceId = UUID.randomUUID().toString().replace("-", "");
        }

        MDC.put(SystemConstant.TRACE_LOG_ID, traceId);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //调用结束后删除
        MDC.remove(SystemConstant.TRACE_LOG_ID);
    }
}
