package com.example.SystemEvents.Services;

import com.example.SystemEvents.Repository.SystemEventRepository;
import com.exapmle.grpc.systemevent.Ack;
import com.exapmle.grpc.systemevent.SystemEvent;
import com.exapmle.grpc.systemevent.SystemEventMessage;
import com.exapmle.grpc.systemevent.SystemEventServiceGrpc;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;

@GRpcService
public class SystemEventService extends SystemEventServiceGrpc.SystemEventServiceImplBase {
    @Autowired
    SystemEventRepository systemEventRepository;


    @Override
    public void saveSystemEvent(SystemEventMessage request, StreamObserver<Ack> responseObserver) {
        LocalDateTime dateTime = LocalDateTime.parse(request.getTimestamp());


        com.example.SystemEvents.Model.SystemEvent systemEvent = new  com.example.SystemEvents.Model.SystemEvent(dateTime, request.getServiceName(), request.getUser());
        systemEventRepository.save(systemEvent);
        Ack.Builder builder = Ack.newBuilder();
        builder.setMessage("System Event spasen");
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
