package com.example.simple_graphql_grpc_project_2604.usecase;

import com.example.simple_graphql_grpc_project_2604.grpc.UserGrpcClient;
import com.example.simplegraphqlgrpcproject2604.grpc.UserDeleteRequest;
import com.example.simplegraphqlgrpcproject2604.grpc.UserDeleteResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteUserUseCase {

    private final UserGrpcClient userGrpcClient;

    public Long deleteUser(UserDeleteRequest request) {
        log.info("[DeleteUserUseCase/deleteUser] request id: {}", request.getId());
        UserDeleteResponse response = userGrpcClient.deleteUser(request);
        log.info("[DeleteUserUseCase/deleteUser] request id: {}", response.getId());

        return response.getId();
    }

}
