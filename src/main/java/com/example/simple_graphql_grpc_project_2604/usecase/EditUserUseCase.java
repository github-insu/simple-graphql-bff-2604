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
public class EditUserUseCase {

    private final  UserService userService;

    private final UserResultMapper userResultMapper;

    public UserInfoResult editUser(User user) {

        log.info("[EditUserUseCase/editUser] user id: {}", user.id());

        // TODO: UserService gRPC통신
        User editedUser = userService.editUser(user);
        return userResultMapper.toInfoResult(editedUser);
    }
}
