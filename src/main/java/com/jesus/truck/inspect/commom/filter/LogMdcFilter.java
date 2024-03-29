package com.jesus.truck.inspect.commom.filter;

import com.jesus.truck.inspect.commom.SystemConstant;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Component
public class LogMdcFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        try {
            if (request instanceof HttpServletRequest) {
                HttpServletRequest httpServletRequest = (HttpServletRequest) request;
                String traceLogId = httpServletRequest.getHeader(SystemConstant.TRACE_LOG_ID);
                if (StringUtils.isEmpty(traceLogId)) {
                    MDC.put(SystemConstant.TRACE_LOG_ID, UUID.randomUUID().toString().replace("-", ""));
                } else {
                    MDC.put(SystemConstant.TRACE_LOG_ID, traceLogId);
                }
                filterChain.doFilter(request, response);
            }
        } finally {
            MDC.remove(SystemConstant.TRACE_LOG_ID);
        }

    }
}