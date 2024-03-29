package com.jesus.truck.inspect.commom;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import java.io.IOException;

public class HttpRequestAddTraceLogId implements HttpRequestInterceptor {

    @Override
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        if (!StringUtils.isEmpty(MDC.get(SystemConstant.TRACE_LOG_ID))) {
            httpRequest.addHeader(SystemConstant.TRACE_LOG_ID, MDC.get(SystemConstant.TRACE_LOG_ID));
        }
    }
}
