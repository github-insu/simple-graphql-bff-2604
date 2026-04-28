package com.example.simple_graphql_grpc_project_2604.usecase;

import com.example.simple_graphql_grpc_project_2604.domain.User;
import com.example.simple_graphql_grpc_project_2604.service.UserService;
import com.example.simple_graphql_grpc_project_2604.usecase.mapper.UserResultMapper;
import com.example.simple_graphql_grpc_project_2604.usecase.model.UserInfoResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SignUpUserUseCase {

    private final UserService userService;

    private final UserResultMapper userResultMapper;

    public UserInfoResult signUp(User user) {
        log.info("[SignUpUserUseCase/signUp()] input user name: {}", user.name());
        // TODO: UserService gRPC통신
        User savedUser = userService.signUp(user);

        return userResultMapper.toInfoResult(savedUser);
    }
}
