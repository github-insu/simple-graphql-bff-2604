package com.example.simple_graphql_grpc_project_2604.usecase;

import com.example.simple_graphql_grpc_project_2604.domain.User;
import com.example.simple_graphql_grpc_project_2604.service.UserService;
import com.example.simple_graphql_grpc_project_2604.usecase.mapper.UserResultMapper;
import com.example.simple_graphql_grpc_project_2604.usecase.model.UserInfoResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReadUserListUseCase {

    private final UserService userService;

    private final UserResultMapper userResultMapper;

    public List<UserInfoResult> readUserList() {
        log.info("[ReadUserListUseCase/readUserList()]");
        // TODO: UserService gRPC통신
        List<User> savedUserList = userService.readUserList();
        log.info("[ReadUserListUseCase/readUserList()] saved user list size: {}", savedUserList.size());

        return savedUserList.stream()
                .map(userResultMapper::toInfoResult)
                .toList();
    }
}
