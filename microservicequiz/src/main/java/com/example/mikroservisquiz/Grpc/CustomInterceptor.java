package com.example.mikroservisquiz.Grpc;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exapmle.grpc.systemevent.SystemEventMessage;
import com.google.errorprone.annotations.Var;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@NoArgsConstructor

public class CustomInterceptor extends HandlerInterceptorAdapter {
    GrpcQuizServiceClient grpcQuizServiceClient;
    public CustomInterceptor(GrpcQuizServiceClient client){
        this.grpcQuizServiceClient =  client;
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception
    {
        String userId = "2";
        Var systemEventMessage = SystemEventMessage.newBuilder().setUser(userId).
                setTimestamp(LocalDateTime.now().toString()).setActionResult(Integer.toString(response.getStatus())).
                setServiceName("QuizService").setResourceObject(request.getRequestURI()).build();

        grpcQuizServiceClient.createSystemEvent(systemEventMessage);
        System.out.println("MINIMAL: INTERCEPTOR AFTERCOMPLETION CALLED");
    }
}