package com.example.simple_graphql_grpc_project_2604.usecase;

import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserReadOnePayload;
import com.example.simple_graphql_grpc_project_2604.grpc.UserGrpcClient;
import com.example.simplegraphqlgrpcproject2604.grpc.UserReadOneRequest;
import com.example.simplegraphqlgrpcproject2604.grpc.UserReadOneResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReadUserOneUseCase {

    private final UserGrpcClient userGrpcClient;

    public UserReadOnePayload readUserOne(UserReadOneRequest request) {
        log.info("[ReadUserOneUseCase/readUserOne] request id: {}", request.getId());
        UserReadOneResponse response = userGrpcClient.readUserOne(request);
        log.info("[ReadUserOneUseCase/readUserOne] response id: {}", response.getId());

        return new UserReadOnePayload(response.getId(), response.getName());
    }
}
