package com.example.simple_graphql_grpc_project_2604.usecase;

import com.example.simple_graphql_grpc_project_2604.graphql.model.User;
import com.example.simple_graphql_grpc_project_2604.grpc.UserGrpcClient;
import com.example.simple_graphql_grpc_project_2604.usecase.mapper.GraphqlGrpcMapper;
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

    private final GraphqlGrpcMapper graphqlGrpcMapper;

    public User readUserOne(Long userId) {
        log.info("[ReadUserOneUseCase/readUserOne] request user id: {}", userId);

        UserReadOneRequest request = graphqlGrpcMapper.toUserReadOneRequest(userId);
        log.info("[ReadUserOneUseCase/readUserOne] request id: {}", request.getId());

        UserReadOneResponse response = userGrpcClient.readUserOne(request);
        log.info("[ReadUserOneUseCase/readUserOne] response id: {}", response.getId());

        return graphqlGrpcMapper.toUser(response);
    }
}
