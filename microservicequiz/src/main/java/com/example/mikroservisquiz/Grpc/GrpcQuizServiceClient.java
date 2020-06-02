package com.example.mikroservisquiz.Grpc;

import javax.annotation.PostConstruct;

import com.exapmle.grpc.systemevent.Ack;
import com.exapmle.grpc.systemevent.SystemEventMessage;
import com.exapmle.grpc.systemevent.SystemEventServiceGrpc;
import com.exapmle.grpc.systemevent.SystemEventServiceGrpc.SystemEventServiceBlockingStub;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.EurekaClientConfig;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class GrpcQuizServiceClient {
    @Autowired
    EurekaClient eurekaClient;
    SystemEventServiceGrpc.SystemEventServiceStub systemEventServiceStub;



    public void createSystemEvent(SystemEventMessage systemEventMessage){

        StreamObserver<Ack> streamObserver = new StreamObserver<Ack>() {
            @Override
            public void onNext(Ack ack) {
                System.out.println("Logged"+ack.toString());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error "+throwable.getLocalizedMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Completed everything");
            }
        };



        systemEventServiceStub.saveSystemEvent(systemEventMessage,streamObserver);


    }


    @PostConstruct
    private void initializeClient(){
        final InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("SystemEvent", false);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
        systemEventServiceStub = SystemEventServiceGrpc.newStub(channel);

    }
}