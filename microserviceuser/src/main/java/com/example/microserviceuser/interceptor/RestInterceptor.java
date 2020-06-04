package com.example.microserviceuser.interceptor;

import com.example.microserviceuser.GrpcClient;
import com.google.protobuf.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.example.microserviceuser.Grpc.Example;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;

@Component
public class RestInterceptor extends HandlerInterceptorAdapter {
    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private GrpcClient grpcClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            grpcClient.checkConnectivity();
            return true;
        } catch (Exception ex) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setHeader("Content-Type", "application/json");
            response.getWriter().write(ex.getMessage());
            response.getWriter().flush();
            response.getWriter().close();
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        invokeClient(request, response);
        super.afterCompletion(request, response, handler, ex);
    }

    private void invokeClient(HttpServletRequest request, HttpServletResponse response) {
        Long userId = 0L;

        Example.Request.ActionType actionType = getActionType(request.getMethod());

        String resource = request.getRequestURI();

        Instant time = Instant.now();
        Timestamp timestamp = Timestamp.newBuilder().setSeconds(time.getEpochSecond())
                .setNanos(time.getNano()).build();

        Integer statusCode = response.getStatus();

        grpcClient.invoke(timestamp, appName, userId, actionType, resource, statusCode);
    }

    private Example.Request.ActionType getActionType(String requestMethod) {
        switch (requestMethod) {
            case "GET":
                return Example.Request.ActionType.GET;
            case "POST":
                return Example.Request.ActionType.CREATE;
            case "PUT":
                return Example.Request.ActionType.UPDATE;
            case "DELETE":
                return Example.Request.ActionType.DELETE;
        }
        return Example.Request.ActionType.UNRECOGNIZED;
    }
}

