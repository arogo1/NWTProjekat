// package com.example.microserviceinquiry.Grpc;

// import java.time.LocalDateTime;

// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import com.exapmle.grpc.systemevent.SystemEventMessage;

// import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// public class CustomInterceptor extends HandlerInterceptorAdapter {
//     GrpcInquiryServiceClient grpcNotificationServiceClient;
//     public CustomInterceptor(GrpcInquiryServiceClient client) {
//         this.grpcNotificationServiceClient =  client;
//     }
//     @Override
//     public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception
//     {
//         String authToken = request.getHeader("Authorization");
//         if (authToken == null) {
//             authToken = "";
//         }
//         SystemEventMessage systemEventMessage = SystemEventMessage.newBuilder().setUser(authToken).
//                 setTimestamp(LocalDateTime.now().toString()).setServiceName("InquiryService").build();

//         grpcNotificationServiceClient.createSystemEvent(systemEventMessage);
//         System.out.println("MINIMAL: INTERCEPTOR AFTERCOMPLETION CALLED");
//     }
// }