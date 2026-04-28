package com.example.simple_graphql_grpc_project_2604.graphql;

import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserReadOneResponse;
import com.example.simple_graphql_grpc_project_2604.graphql.mapper.DtoResultMapper;
import com.example.simple_graphql_grpc_project_2604.usecase.ReadOneUserUseCase;
import com.example.simple_graphql_grpc_project_2604.usecase.ReadUserListUseCase;
import com.example.simple_graphql_grpc_project_2604.usecase.model.UserInfoResult;
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

    private final ReadOneUserUseCase readOneUserUseCase;
    private final ReadUserListUseCase readUserListUseCase;

    private final DtoResultMapper dtoResultMapper;

    @QueryMapping
    public UserReadOneResponse readOneUser(@Argument Long userId) {
        log.info("[QueryResolver/readOneUser()] input user id: {}", userId);
        UserInfoResult getUser = readOneUserUseCase.readOneUser(userId);
        log.info("[QueryResolver/readOneUser()] get user name: {}", getUser.name());

        return dtoResultMapper.toReadOneResponse(getUser);
    }

    @QueryMapping
    public List<UserReadOneResponse> readUserList() {
        log.info("[QueryResolver/readUserList()]");
        List<UserInfoResult> resultList = readUserListUseCase.readUserList();
        log.info("[QueryResolver/readUserList()] list size: {}", resultList.size());

        return resultList.stream()
                .map(dtoResultMapper::toReadOneResponse)
                .toList();
    }
}
