package com.example.simple_graphql_grpc_project_2604.grpc;

import com.example.simplegraphqlgrpcproject2604.grpc.UserDeleteRequest;
import com.example.simplegraphqlgrpcproject2604.grpc.UserDeleteResponse;
import com.example.simplegraphqlgrpcproject2604.grpc.UserEditRequest;
import com.example.simplegraphqlgrpcproject2604.grpc.UserEditResponse;
import com.example.simplegraphqlgrpcproject2604.grpc.UserReadOneRequest;
import com.example.simplegraphqlgrpcproject2604.grpc.UserReadOneResponse;
import com.example.simplegraphqlgrpcproject2604.grpc.UserReadOneResponseList;
import com.example.simplegraphqlgrpcproject2604.grpc.UserServiceGrpc;
import com.example.simplegraphqlgrpcproject2604.grpc.UserSignUpRequest;
import com.example.simplegraphqlgrpcproject2604.grpc.UserSignUpResponse;
import com.google.protobuf.Empty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserGrpcClient {

    public static final Empty EMPTY = Empty.getDefaultInstance();

    private final UserServiceGrpc.UserServiceBlockingStub stub;

    public UserSignUpResponse signUp(UserSignUpRequest request) {
        log.info("[UserGrpcClient/signUp] 호출");
        return stub.signUp(request);
    }

    public UserReadOneResponse readUserOne(UserReadOneRequest request) {
        log.info("[UserGrpcClient/readUserOne] 호출");
        return stub.readUserOne(request);
    }

    public UserReadOneResponseList readUserList() {
        log.info("[UserGrpcClient/readUserList] 호출");
        return stub.readUserList(EMPTY);
    }

    public UserEditResponse editUser(UserEditRequest request) {
        log.info("[UserGrpcClient/editUser] 호출");
        return stub.editUser(request);
    }

    public UserDeleteResponse deleteUser(UserDeleteRequest request) {
        log.info("[UserGrpcClient/deleteUser] 호출");
        return stub.deleteUser(request);
    }
}
