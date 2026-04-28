package com.example.simple_graphql_grpc_project_2604.usecase;

import com.example.simple_graphql_grpc_project_2604.domain.User;
import com.example.simple_graphql_grpc_project_2604.service.UserService;
import com.example.simple_graphql_grpc_project_2604.usecase.mapper.UserResultMapper;
import com.example.simple_graphql_grpc_project_2604.usecase.model.UserInfoResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReadOneUserUseCase {

    private final UserService userService;

    private final UserResultMapper userResultMapper;

    public UserInfoResult readOneUser(Long userId) {
        log.info("[ReadOneUserUseCase/readOneUser] get user id: {}", userId);
        // TODO: UserService gRPC통신
        User savedUser = userService.readOneUser(userId);
        log.info("[ReadOneUserUseCase/readOneUser] saved user id: {}", savedUser);

        return userResultMapper.toInfoResult(savedUser);
    }
}
