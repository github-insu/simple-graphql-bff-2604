package com.example.simple_graphql_grpc_project_2604.graphql;

import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserEditInput;
import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserEditPayload;
import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserSignUpInput;
import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserSignUpPayload;
import com.example.simple_graphql_grpc_project_2604.graphql.mapper.GraphqlToGrpcMapper;
import com.example.simple_graphql_grpc_project_2604.usecase.UserSignUpUseCase;
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

    private final UserSignUpUseCase userSignUpUseCase;

    private final GraphqlToGrpcMapper graphqlToGrpcMapper;

    @MutationMapping
    public UserSignUpPayload signUpUser(@Argument UserSignUpInput input) {
        log.info("[MutationResolver/signUpUser()] input user name: {}", input.name());

        UserSignUpRequest request = graphqlToGrpcMapper.toUserSignUpRequest(input);
        log.info("[MutationResolver/signUpUser()] request user name: {}", request.getName());

        return userSignUpUseCase.signUp(request);
    }

    @MutationMapping
    public UserEditPayload editUser(@Argument UserEditInput request) {
        log.info("[MutationResolver/editUser()] input user id: {}", request.id());
        log.info("[MutationResolver/editUser()] input user name: {}", request.name());

        return null;
    }

    @MutationMapping
    public Long deleteUser(@Argument Long userId) {
        log.info("[MutationResolver/deleteUser()] input user id: {}", userId);

        return null;
    }
}
