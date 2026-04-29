package com.example.simple_graphql_grpc_project_2604.graphql;

import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserReadOnePayload;
import com.example.simple_graphql_grpc_project_2604.graphql.mapper.GraphqlToGrpcMapper;
import com.example.simple_graphql_grpc_project_2604.usecase.ReadUserListUseCase;
import com.example.simple_graphql_grpc_project_2604.usecase.ReadUserOneUseCase;
import com.example.simplegraphqlgrpcproject2604.grpc.UserReadOneRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class QueryResolver {

    private final ReadUserOneUseCase readUserOneUseCase;
    private final ReadUserListUseCase readUserListUseCase;

    private final GraphqlToGrpcMapper graphqlToGrpcMapper;

    @QueryMapping
    public UserReadOnePayload readOneUser(@Argument Long userId) {
        log.info("[QueryResolver/readOneUser()] input user id: {}", userId);
        UserReadOneRequest request = graphqlToGrpcMapper.toUserReadOneRequest(userId);

        return readUserOneUseCase.readUserOne(request);
    }

    @QueryMapping
    public List<UserReadOnePayload> readUserList() {
        log.info("[QueryResolver/readUserList()] 호출 성공");

        return readUserListUseCase.readUserList();
    }
}
