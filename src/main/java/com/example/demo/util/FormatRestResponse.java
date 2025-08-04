package com.example.demo.util;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class FormatRestResponse implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
            MethodParameter returnType,
            MediaType selectedContentType,
            Class selectedConverterType,
            ServerHttpRequest request,
            ServerHttpResponse response) {
        return body;
    }

    private int getStatusCode(ServerHttpResponse response) {
        // Cast về ServletServerHttpResponse để lấy status code
        if (response instanceof org.springframework.http.server.ServletServerHttpResponse) {
            HttpServletResponse servletResponse = ((org.springframework.http.server.ServletServerHttpResponse) response)
                    .getServletResponse();
            return servletResponse.getStatus();
        }
        return 200; // Default
    }

}
