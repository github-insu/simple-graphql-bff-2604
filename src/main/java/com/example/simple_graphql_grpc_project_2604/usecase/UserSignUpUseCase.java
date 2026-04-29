package com.example.simple_graphql_grpc_project_2604.usecase;

import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserSignUpPayload;
import com.example.simple_graphql_grpc_project_2604.grpc.UserGrpcClient;
import com.example.simplegraphqlgrpcproject2604.grpc.UserSignUpRequest;
import com.example.simplegraphqlgrpcproject2604.grpc.UserSignUpResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserSignUpUseCase {

    private final UserGrpcClient userGrpcClient;

    public UserSignUpPayload signUp(UserSignUpRequest request) {
        log.info("[UserSignUpUseCase/signUp] request name: {}", request.getName());
        UserSignUpResponse response = userGrpcClient.signUp(request);
        log.info("[UserSignUpUseCase/signUp] saved id: {}", response.getId());
        log.info("[UserSignUpUseCase/signUp] saved name: {}", response.getName());

        return new UserSignUpPayload(response.getId(), response.getName());
    }
}
