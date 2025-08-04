package com.example.demo.util;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.example.demo.Domain.RestResponse;

import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class FormatRestResponse implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType,
            Class converterType) {
        return true; // Format tất cả response
    }

    @Override
    public Object beforeBodyWrite(Object body,
            MethodParameter returnType,
            MediaType selectedContentType,
            Class selectedConverterType,
            ServerHttpRequest request,
            ServerHttpResponse response) {

        // Lấy HTTP status code
        HttpServletResponse servletResponse = ((org.springframework.http.server.ServletServerHttpResponse) response)
                .getServletResponse();
        int status = servletResponse.getStatus();

        // Tạo response object
        RestResponse<Object> res = new RestResponse<>();

        // Phân loại theo status code
        if (status >= 400) {
            return body;
        } else {
            // SUCCESS CASE (2xx, 3xx)
            res.setData(body);
            res.setMessage("Call API success");
            res.setStatusCode(status);
        }

        return res;
    }
}