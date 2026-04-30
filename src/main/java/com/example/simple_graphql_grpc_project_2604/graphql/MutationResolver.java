package com.example.simple_graphql_grpc_project_2604.graphql;

import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserEditInput;
import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserEditPayload;
import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserSignUpInput;
import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserSignUpPayload;
import com.example.simple_graphql_grpc_project_2604.graphql.mapper.GraphqlToGrpcMapper;
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

    private final GraphqlToGrpcMapper graphqlToGrpcMapper;

    @MutationMapping
    public UserSignUpPayload signUpUser(@Argument UserSignUpInput input) {
        log.info("[MutationResolver/signUpUser()] input user name: {}", input.name());

        UserSignUpRequest request = graphqlToGrpcMapper.toUserSignUpRequest(input);
        log.info("[MutationResolver/signUpUser()] request user name: {}", request.getName());

        return signUpUserUseCase.signUp(request);
    }

    @MutationMapping
    public UserEditPayload editUser(@Argument UserEditInput input) {
        log.info("[MutationResolver/editUser()] input user id: {}", input.id());
        log.info("[MutationResolver/editUser()] input user name: {}", input.name());
        UserEditRequest request = graphqlToGrpcMapper.toUserEditRequest(input);

        return editUserUseCase.editUser(request);
    }

    @MutationMapping
    public Long deleteUser(@Argument Long userId) {
        log.info("[MutationResolver/deleteUser()] input user id: {}", userId);
        UserDeleteRequest request = graphqlToGrpcMapper.toUserDeleteRequest(userId);

        return deleteUserUseCase.deleteUser(request);
    }
}
