package com.xjch.test.springcloud.hello.client.zuul.error;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@SuppressWarnings("unused")
//@Component
public class MyErrorAttribute extends DefaultErrorAttributes {

    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> result = super.getErrorAttributes((WebRequest)requestAttributes, includeStackTrace);
        result.put("status", 222);
        result.put("error", "error");
        result.put("exception", "exception");
        result.put("message", "message");
        return result;
    }
}
