package com.example.microserviceinquiry;

import com.google.protobuf.Timestamp;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.example.microserviceinquiry.grpc.actionGrpc;

@Configuration
public class GrpcClient {
    @Autowired
    private EurekaClient client;
    public void invoke(Timestamp timestamp, String serviceName, Long userId,
                       com.example.microserviceinquiry.grpc.Example.Request.ActionType actionType, String resourceName, Integer statusCode) {
        final InstanceInfo instanceInfo = client.getNextServerFromEureka("SystemEvent", false);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
        com.example.microserviceinquiry.grpc.actionGrpc.actionBlockingStub actionBlockingStub = com.example.microserviceinquiry.grpc.actionGrpc.newBlockingStub(channel);
        com.example.microserviceinquiry.grpc.Example.Request actionRequest = com.example.microserviceinquiry.grpc.Example.Request.newBuilder()
                .setTimestamp(timestamp)
                .setServiceName(serviceName)
                .setUserId(userId)
                .setActionType(actionType)
                .setResourceName(resourceName)
                .setStatusCode(statusCode)
                .build();
                com.example.microserviceinquiry.grpc.Example.APIResponse apiResponse = actionBlockingStub.logAction(actionRequest);
    }

    public void checkConnectivity() throws Exception {
        try {
            final InstanceInfo instanceInfo = client.getNextServerFromEureka("SystemEvent", false);
            ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
            actionGrpc.actionBlockingStub actionBlockingStub = com.example.microserviceinquiry.grpc.actionGrpc.newBlockingStub(channel);
            com.example.microserviceinquiry.grpc.Example.Empty empty = com.example.microserviceinquiry.grpc.Example.Empty.newBuilder().build();
            actionBlockingStub.check(empty);
        }
        catch (Exception ex) {
            throw new Exception("{\"message\": \"system-events service not available\"}");
        }
    }
}