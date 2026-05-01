package com.example.simple_graphql_grpc_project_2604.user.usecase;

import com.example.simple_graphql_grpc_project_2604.user.graphql.model.User;
import com.example.simple_graphql_grpc_project_2604.user.grpc.UserGrpcClient;
import com.example.simple_graphql_grpc_project_2604.user.usecase.mapper.ResponseUserMapper;
import com.example.simplegraphqlgrpcproject2604.grpc.UserSignUpRequest;
import com.example.simplegraphqlgrpcproject2604.grpc.UserSignUpResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SignUpUserUseCase {

    private final UserGrpcClient userGrpcClient;

    private final ResponseUserMapper responseUserMapper;

    public User signUp(UserSignUpRequest request) {
        log.info("[UserSignUpUseCase/signUp] request name: {}", request.getName());
        UserSignUpResponse response = userGrpcClient.signUp(request);
        log.info("[UserSignUpUseCase/signUp] saved id: {}", response.getId());
        log.info("[UserSignUpUseCase/signUp] saved name: {}", response.getName());

        return responseUserMapper.toUser(response);
    }
}
