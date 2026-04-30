package com.example.simple_graphql_grpc_project_2604.usecase;

import com.example.simple_graphql_grpc_project_2604.graphql.model.User;
import com.example.simple_graphql_grpc_project_2604.grpc.UserGrpcClient;
import com.example.simple_graphql_grpc_project_2604.usecase.mapper.ResponseUserMapper;
import com.example.simplegraphqlgrpcproject2604.grpc.UserEditRequest;
import com.example.simplegraphqlgrpcproject2604.grpc.UserEditResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EditUserUseCase {

    private final UserGrpcClient userGrpcClient;

    private final ResponseUserMapper responseUserMapper;

    public User editUser(UserEditRequest request) {
        log.info("[EditUserUseCase/editUser] request name: {}", request.getName());
        UserEditResponse response = userGrpcClient.editUser(request);
        log.info("[EditUserUseCase/editUser] response name: {}", response.getName());

        return responseUserMapper.toUser(response);
    }
}
