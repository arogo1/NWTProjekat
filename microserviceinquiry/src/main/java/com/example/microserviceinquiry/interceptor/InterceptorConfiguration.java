package com.example.microserviceinquiry.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    @Autowired
    com.example.microserviceinquiry.interceptor.RestInterceptor restInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(restInterceptor);
    }
}
