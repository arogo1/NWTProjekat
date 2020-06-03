package com.example.SystemEvents.grpc;

        import static io.grpc.MethodDescriptor.generateFullMethodName;
        import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
        import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
        import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
        import static io.grpc.stub.ClientCalls.asyncUnaryCall;
        import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
        import static io.grpc.stub.ClientCalls.blockingUnaryCall;
        import static io.grpc.stub.ClientCalls.futureUnaryCall;
        import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
        import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
        import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
        import static io.grpc.stub.ServerCalls.asyncUnaryCall;
        import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
        import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.15.0)",
        comments = "Source: example.proto")
public final class actionGrpc {

    private actionGrpc() {}

    public static final String SERVICE_NAME = "action";

    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<com.example.SystemEvents.grpc.Example.Request,
            com.example.SystemEvents.grpc.Example.APIResponse> getLogActionMethod;

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "logAction",
            requestType = com.example.SystemEvents.grpc.Example.Request.class,
            responseType = com.example.SystemEvents.grpc.Example.APIResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.example.SystemEvents.grpc.Example.Request,
            com.example.SystemEvents.grpc.Example.APIResponse> getLogActionMethod() {
        io.grpc.MethodDescriptor<com.example.SystemEvents.grpc.Example.Request, com.example.SystemEvents.grpc.Example.APIResponse> getLogActionMethod;
        if ((getLogActionMethod = actionGrpc.getLogActionMethod) == null) {
            synchronized (actionGrpc.class) {
                if ((getLogActionMethod = actionGrpc.getLogActionMethod) == null) {
                    actionGrpc.getLogActionMethod = getLogActionMethod =
                            io.grpc.MethodDescriptor.<com.example.SystemEvents.grpc.Example.Request, com.example.SystemEvents.grpc.Example.APIResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "action", "logAction"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.example.SystemEvents.grpc.Example.Request.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.example.SystemEvents.grpc.Example.APIResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new actionMethodDescriptorSupplier("logAction"))
                                    .build();
                }
            }
        }
        return getLogActionMethod;
    }

    private static volatile io.grpc.MethodDescriptor<com.example.SystemEvents.grpc.Example.Empty,
            com.example.SystemEvents.grpc.Example.APIResponse> getCheckMethod;

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "check",
            requestType = com.example.SystemEvents.grpc.Example.Empty.class,
            responseType = com.example.SystemEvents.grpc.Example.APIResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.example.SystemEvents.grpc.Example.Empty,
            com.example.SystemEvents.grpc.Example.APIResponse> getCheckMethod() {
        io.grpc.MethodDescriptor<com.example.SystemEvents.grpc.Example.Empty, com.example.SystemEvents.grpc.Example.APIResponse> getCheckMethod;
        if ((getCheckMethod = actionGrpc.getCheckMethod) == null) {
            synchronized (actionGrpc.class) {
                if ((getCheckMethod = actionGrpc.getCheckMethod) == null) {
                    actionGrpc.getCheckMethod = getCheckMethod =
                            io.grpc.MethodDescriptor.<com.example.SystemEvents.grpc.Example.Empty, com.example.SystemEvents.grpc.Example.APIResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "action", "check"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.example.SystemEvents.grpc.Example.Empty.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.example.SystemEvents.grpc.Example.APIResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new actionMethodDescriptorSupplier("check"))
                                    .build();
                }
            }
        }
        return getCheckMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static actionStub newStub(io.grpc.Channel channel) {
        return new actionStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static actionBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        return new actionBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static actionFutureStub newFutureStub(
            io.grpc.Channel channel) {
        return new actionFutureStub(channel);
    }

    /**
     */
    public static abstract class actionImplBase implements io.grpc.BindableService {

        /**
         */
        public void logAction(com.example.SystemEvents.grpc.Example.Request request,
                              io.grpc.stub.StreamObserver<com.example.SystemEvents.grpc.Example.APIResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getLogActionMethod(), responseObserver);
        }

        /**
         */
        public void check(com.example.SystemEvents.grpc.Example.Empty request,
                          io.grpc.stub.StreamObserver<com.example.SystemEvents.grpc.Example.APIResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getCheckMethod(), responseObserver);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getLogActionMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.example.SystemEvents.grpc.Example.Request,
                                            com.example.SystemEvents.grpc.Example.APIResponse>(
                                            this, METHODID_LOG_ACTION)))
                    .addMethod(
                            getCheckMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.example.SystemEvents.grpc.Example.Empty,
                                            com.example.SystemEvents.grpc.Example.APIResponse>(
                                            this, METHODID_CHECK)))
                    .build();
        }
    }

    /**
     */
    public static final class actionStub extends io.grpc.stub.AbstractStub<actionStub> {
        private actionStub(io.grpc.Channel channel) {
            super(channel);
        }

        private actionStub(io.grpc.Channel channel,
                           io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected actionStub build(io.grpc.Channel channel,
                                   io.grpc.CallOptions callOptions) {
            return new actionStub(channel, callOptions);
        }

        /**
         */
        public void logAction(com.example.SystemEvents.grpc.Example.Request request,
                              io.grpc.stub.StreamObserver<com.example.SystemEvents.grpc.Example.APIResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getLogActionMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void check(com.example.SystemEvents.grpc.Example.Empty request,
                          io.grpc.stub.StreamObserver<com.example.SystemEvents.grpc.Example.APIResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getCheckMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     */
    public static final class actionBlockingStub extends io.grpc.stub.AbstractStub<actionBlockingStub> {
        private actionBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private actionBlockingStub(io.grpc.Channel channel,
                                   io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected actionBlockingStub build(io.grpc.Channel channel,
                                           io.grpc.CallOptions callOptions) {
            return new actionBlockingStub(channel, callOptions);
        }

        /**
         */
        public com.example.SystemEvents.grpc.Example.APIResponse logAction(com.example.SystemEvents.grpc.Example.Request request) {
            return blockingUnaryCall(
                    getChannel(), getLogActionMethod(), getCallOptions(), request);
        }

        /**
         */
        public com.example.SystemEvents.grpc.Example.APIResponse check(com.example.SystemEvents.grpc.Example.Empty request) {
            return blockingUnaryCall(
                    getChannel(), getCheckMethod(), getCallOptions(), request);
        }
    }

    /**
     */
    public static final class actionFutureStub extends io.grpc.stub.AbstractStub<actionFutureStub> {
        private actionFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private actionFutureStub(io.grpc.Channel channel,
                                 io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected actionFutureStub build(io.grpc.Channel channel,
                                         io.grpc.CallOptions callOptions) {
            return new actionFutureStub(channel, callOptions);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<com.example.SystemEvents.grpc.Example.APIResponse> logAction(
                com.example.SystemEvents.grpc.Example.Request request) {
            return futureUnaryCall(
                    getChannel().newCall(getLogActionMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<com.example.SystemEvents.grpc.Example.APIResponse> check(
                com.example.SystemEvents.grpc.Example.Empty request) {
            return futureUnaryCall(
                    getChannel().newCall(getCheckMethod(), getCallOptions()), request);
        }
    }

    private static final int METHODID_LOG_ACTION = 0;
    private static final int METHODID_CHECK = 1;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final actionImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(actionImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_LOG_ACTION:
                    serviceImpl.logAction((com.example.SystemEvents.grpc.Example.Request) request,
                            (io.grpc.stub.StreamObserver<com.example.SystemEvents.grpc.Example.APIResponse>) responseObserver);
                    break;
                case METHODID_CHECK:
                    serviceImpl.check((com.example.SystemEvents.grpc.Example.Empty) request,
                            (io.grpc.stub.StreamObserver<com.example.SystemEvents.grpc.Example.APIResponse>) responseObserver);
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

    private static abstract class actionBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        actionBaseDescriptorSupplier() {}

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return com.example.SystemEvents.grpc.Example.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("action");
        }
    }

    private static final class actionFileDescriptorSupplier
            extends actionBaseDescriptorSupplier {
        actionFileDescriptorSupplier() {}
    }

    private static final class actionMethodDescriptorSupplier
            extends actionBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        actionMethodDescriptorSupplier(String methodName) {
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
            synchronized (actionGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new actionFileDescriptorSupplier())
                            .addMethod(getLogActionMethod())
                            .addMethod(getCheckMethod())
                            .build();
                }
            }
        }
        return result;
    }
}