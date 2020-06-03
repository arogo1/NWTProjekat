package com.example.SystemEvents;

import com.example.SystemEvents.Model.Event;
import com.example.SystemEvents.grpc.Example;
import com.example.SystemEvents.grpc.Example.APIResponse;
import com.example.SystemEvents.grpc.Example.Request;
import com.example.SystemEvents.grpc.actionGrpc.actionImplBase;
import com.google.protobuf.Timestamp;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

@GRpcService
@Component
public class SystemEventsService extends actionImplBase {
    private ConnectionConfig connectionConfig = new ConnectionConfig();

    @Override
    public void check(Example.Empty request, StreamObserver<APIResponse> responseObserver) {
       APIResponse.Builder response = APIResponse.newBuilder();
       response.setResponseMessage("Server running...").setResponseType(APIResponse.ResponseType.SUCCESS);

       responseObserver.onNext(response.build());
       responseObserver.onCompleted();
    }

    @Override
    public void logAction(Request request, StreamObserver<APIResponse> responseObserver) {
        System.out.println("234567898765432345678i987654323456789876543");
        APIResponse.Builder response = APIResponse.newBuilder();
        try {
            Event event = EventBuilder(request);
            PreparedStatement preparedStatement = addEvent(event);

            preparedStatement.executeUpdate();
            response.setResponseMessage("Action saved.").setResponseType(APIResponse.ResponseType.SUCCESS);
        }
        catch (Exception e) {
            response.setResponseMessage(e.getMessage()).setResponseType(APIResponse.ResponseType.ERROR);
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    private Event EventBuilder (Request request) {
        Timestamp timestamp = request.getTimestamp();
        Long userId = request.getUserId();
        String serviceName = request.getServiceName();
        Integer actionType = request.getActionTypeValue();
        String resourceName = request.getResourceName();
        Integer statusCode = request.getStatusCode();

        return new Event(timestamp, userId, serviceName, actionType, resourceName, statusCode);
    }

    private PreparedStatement addEvent(Event event) throws Exception {
        String sql = "INSERT INTO events(timestamp, user_id, action_type, resource_name, service_name, status_code) VALUES(?,?,?,?,?,?)";
        ArrayList<String> connectionProps = connectionConfig.getConnectionProps();

        Connection connection = DriverManager.getConnection(connectionProps.get(0), connectionProps.get(1), connectionProps.get(2));
        try{

            PreparedStatement st = null;
            st = connection.prepareStatement(sql);

            st.setString(1, event.getTimestamp());
            st.setLong(2, event.getUserId());
            st.setInt(3, event.getActionType());
            st.setString(4, event.getResourceName());
            st.setString(5, event.getServiceName());
            st.setInt(6, event.getStatusCode());

            return st;
        }
        catch (Exception e) {
            throw e;
        }
    }
}