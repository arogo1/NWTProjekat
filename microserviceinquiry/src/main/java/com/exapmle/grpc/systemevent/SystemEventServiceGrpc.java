package com.exapmle.grpc.systemevent;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: SystemEvent.proto")
public final class SystemEventServiceGrpc {

  private SystemEventServiceGrpc() {}

  public static final String SERVICE_NAME = "com.exapmle.grpc.systemevent.SystemEventService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.exapmle.grpc.systemevent.SystemEventMessage,
      com.exapmle.grpc.systemevent.Ack> getSaveSystemEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveSystemEvent",
      requestType = com.exapmle.grpc.systemevent.SystemEventMessage.class,
      responseType = com.exapmle.grpc.systemevent.Ack.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.exapmle.grpc.systemevent.SystemEventMessage,
      com.exapmle.grpc.systemevent.Ack> getSaveSystemEventMethod() {
    io.grpc.MethodDescriptor<com.exapmle.grpc.systemevent.SystemEventMessage, com.exapmle.grpc.systemevent.Ack> getSaveSystemEventMethod;
    if ((getSaveSystemEventMethod = SystemEventServiceGrpc.getSaveSystemEventMethod) == null) {
      synchronized (SystemEventServiceGrpc.class) {
        if ((getSaveSystemEventMethod = SystemEventServiceGrpc.getSaveSystemEventMethod) == null) {
          SystemEventServiceGrpc.getSaveSystemEventMethod = getSaveSystemEventMethod = 
              io.grpc.MethodDescriptor.<com.exapmle.grpc.systemevent.SystemEventMessage, com.exapmle.grpc.systemevent.Ack>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.exapmle.grpc.systemevent.SystemEventService", "saveSystemEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.exapmle.grpc.systemevent.SystemEventMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.exapmle.grpc.systemevent.Ack.getDefaultInstance()))
                  .setSchemaDescriptor(new SystemEventServiceMethodDescriptorSupplier("saveSystemEvent"))
                  .build();
          }
        }
     }
     return getSaveSystemEventMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SystemEventServiceStub newStub(io.grpc.Channel channel) {
    return new SystemEventServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SystemEventServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SystemEventServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SystemEventServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SystemEventServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SystemEventServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void saveSystemEvent(com.exapmle.grpc.systemevent.SystemEventMessage request,
        io.grpc.stub.StreamObserver<com.exapmle.grpc.systemevent.Ack> responseObserver) {
      asyncUnimplementedUnaryCall(getSaveSystemEventMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSaveSystemEventMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.exapmle.grpc.systemevent.SystemEventMessage,
                com.exapmle.grpc.systemevent.Ack>(
                  this, METHODID_SAVE_SYSTEM_EVENT)))
          .build();
    }
  }

  /**
   */
  public static final class SystemEventServiceStub extends io.grpc.stub.AbstractStub<SystemEventServiceStub> {
    private SystemEventServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SystemEventServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SystemEventServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SystemEventServiceStub(channel, callOptions);
    }

    /**
     */
    public void saveSystemEvent(com.exapmle.grpc.systemevent.SystemEventMessage request,
        io.grpc.stub.StreamObserver<com.exapmle.grpc.systemevent.Ack> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSaveSystemEventMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SystemEventServiceBlockingStub extends io.grpc.stub.AbstractStub<SystemEventServiceBlockingStub> {
    private SystemEventServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SystemEventServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SystemEventServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SystemEventServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.exapmle.grpc.systemevent.Ack saveSystemEvent(com.exapmle.grpc.systemevent.SystemEventMessage request) {
      return blockingUnaryCall(
          getChannel(), getSaveSystemEventMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SystemEventServiceFutureStub extends io.grpc.stub.AbstractStub<SystemEventServiceFutureStub> {
    private SystemEventServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SystemEventServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SystemEventServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SystemEventServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.exapmle.grpc.systemevent.Ack> saveSystemEvent(
        com.exapmle.grpc.systemevent.SystemEventMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getSaveSystemEventMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAVE_SYSTEM_EVENT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SystemEventServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SystemEventServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAVE_SYSTEM_EVENT:
          serviceImpl.saveSystemEvent((com.exapmle.grpc.systemevent.SystemEventMessage) request,
              (io.grpc.stub.StreamObserver<com.exapmle.grpc.systemevent.Ack>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SystemEventServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SystemEventServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.exapmle.grpc.systemevent.SystemEvent.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SystemEventService");
    }
  }

  private static final class SystemEventServiceFileDescriptorSupplier
      extends SystemEventServiceBaseDescriptorSupplier {
    SystemEventServiceFileDescriptorSupplier() {}
  }

  private static final class SystemEventServiceMethodDescriptorSupplier
      extends SystemEventServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SystemEventServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SystemEventServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SystemEventServiceFileDescriptorSupplier())
              .addMethod(getSaveSystemEventMethod())
              .build();
        }
      }
    }
    return result;
  }
}