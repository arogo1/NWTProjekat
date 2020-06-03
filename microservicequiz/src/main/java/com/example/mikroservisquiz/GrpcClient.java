package com.example.mikroservisquiz;

import com.google.protobuf.Timestamp;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.example.SystemEvents.grpc.actionGrpc;

@Configuration
public class GrpcClient {
    @Autowired
    private EurekaClient client;

    public void invoke(Timestamp timestamp, String serviceName, Long userId,
                       com.example.SystemEvents.grpc.Example.Request.ActionType actionType, String resourceName, Integer statusCode) {
        final InstanceInfo instanceInfo = client.getNextServerFromEureka("SystemEvent", false);
        System.out.println("ssssssssssss1");
        ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
        System.out.println("ssssssssssss2");
        com.example.SystemEvents.grpc.actionGrpc.actionBlockingStub actionBlockingStub = com.example.SystemEvents.grpc.actionGrpc.newBlockingStub(channel);
        System.out.println("ssssssssssss3");
        com.example.SystemEvents.grpc.Example.Request actionRequest = com.example.SystemEvents.grpc.Example.Request.newBuilder()
                .setTimestamp(timestamp)
                .setServiceName(serviceName)
                .setUserId(userId)
                .setActionType(actionType)
                .setResourceName(resourceName)
                .setStatusCode(statusCode)
                .build();
        System.out.println("ssssssssssss4");
                com.example.SystemEvents.grpc.Example.APIResponse apiResponse = actionBlockingStub.logAction(actionRequest);
    }

    public void checkConnectivity() throws Exception {
        try {
            System.out.println("errrrrrrrrrr1");
            final InstanceInfo instanceInfo = client.getNextServerFromEureka("SystemEvent", false);
            ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
            actionGrpc.actionBlockingStub actionBlockingStub = com.example.SystemEvents.grpc.actionGrpc.newBlockingStub(channel);
            System.out.println("errrrrrrrrrr4");
            com.example.SystemEvents.grpc.Example.Empty empty = com.example.SystemEvents.grpc.Example.Empty.newBuilder().build();
            actionBlockingStub.check(empty);
        }
        catch (Exception ex) {
            throw new Exception("{\"message\": \"system-events service not available\"}");
        }
    }
}