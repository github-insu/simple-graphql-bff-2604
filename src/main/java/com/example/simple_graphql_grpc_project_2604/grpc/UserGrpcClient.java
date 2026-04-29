package com.example.simple_graphql_grpc_project_2604.grpc;

import com.example.simplegraphqlgrpcproject2604.grpc.UserServiceGrpc;
import com.example.simplegraphqlgrpcproject2604.grpc.UserSignUpRequest;
import com.example.simplegraphqlgrpcproject2604.grpc.UserSignUpResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserGrpcClient {

    private final UserServiceGrpc.UserServiceBlockingStub stub;

    public UserSignUpResponse signUp(UserSignUpRequest request) {

        log.info("[UserGrpcClient/signUp] request name: {}",request.getName());

        return stub.signUp(request);
    }
}
