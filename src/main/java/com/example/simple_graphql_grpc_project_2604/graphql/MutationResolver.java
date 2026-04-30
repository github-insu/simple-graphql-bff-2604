package com.example.simple_graphql_grpc_project_2604.graphql;

import com.example.simple_graphql_grpc_project_2604.graphql.dto.EditUserInput;
import com.example.simple_graphql_grpc_project_2604.graphql.dto.SignUpUserInput;
import com.example.simple_graphql_grpc_project_2604.graphql.mapper.InputRequestMapper;
import com.example.simple_graphql_grpc_project_2604.graphql.model.User;
import com.example.simple_graphql_grpc_project_2604.usecase.DeleteUserUseCase;
import com.example.simple_graphql_grpc_project_2604.usecase.EditUserUseCase;
import com.example.simple_graphql_grpc_project_2604.usecase.SignUpUserUseCase;
import com.example.simplegraphqlgrpcproject2604.grpc.UserDeleteRequest;
import com.example.simplegraphqlgrpcproject2604.grpc.UserEditRequest;
import com.example.simplegraphqlgrpcproject2604.grpc.UserSignUpRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MutationResolver {

    private final SignUpUserUseCase signUpUserUseCase;
    private final EditUserUseCase editUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    private final InputRequestMapper inputRequestMapper;

    @MutationMapping
    public User signUpUser(@Argument SignUpUserInput input) {
        log.info("[MutationResolver/signUpUser()] input user name: {}", input.name());

        UserSignUpRequest request = inputRequestMapper.toUserSignUpRequest(input);
        log.info("[MutationResolver/signUpUser()] request user name: {}", request.getName());

        return signUpUserUseCase.signUp(request);
    }

    @MutationMapping
    public User editUser(@Argument EditUserInput input) {
        log.info("[MutationResolver/editUser()] input user id: {}", input.id());
        log.info("[MutationResolver/editUser()] input user name: {}", input.name());
        UserEditRequest request = inputRequestMapper.toUserEditRequest(input);

        return editUserUseCase.editUser(request);
    }

    @MutationMapping
    public Long deleteUser(@Argument Long id) {
        log.info("[MutationResolver/deleteUser()] input user id: {}", id);
        UserDeleteRequest request = inputRequestMapper.toUserDeleteRequest(id);

        return deleteUserUseCase.deleteUser(request);
    }
}
