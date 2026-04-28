package com.example.simple_graphql_grpc_project_2604.graphql;

import com.example.simple_graphql_grpc_project_2604.domain.User;
import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserEditRequest;
import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserEditResponse;
import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserSignUpRequest;
import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserSignUpResponse;
import com.example.simple_graphql_grpc_project_2604.graphql.mapper.DtoResultMapper;
import com.example.simple_graphql_grpc_project_2604.usecase.DeleteUserUseCase;
import com.example.simple_graphql_grpc_project_2604.usecase.EditUserUseCase;
import com.example.simple_graphql_grpc_project_2604.usecase.SignUpUserUseCase;
import com.example.simple_graphql_grpc_project_2604.usecase.model.UserInfoResult;
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

    private final DtoResultMapper dtoResultMapper;

    @MutationMapping
    public UserSignUpResponse signUpUser(@Argument UserSignUpRequest request) {
        log.info("[MutationResolver/signUpUser()] input user name: {}", request.name());
        User inputUser = User.create(request.name());
        UserInfoResult savedUser = signUpUserUseCase.signUp(inputUser);
        log.info("[MutationResolver/signUpUser()] saved user name: {}", savedUser.name());

        return dtoResultMapper.toSignUpResponse(savedUser);
    }

    @MutationMapping
    public UserEditResponse editUser(@Argument UserEditRequest request) {
        log.info("[MutationResolver/editUser()] input user id: {}", request.id());
        log.info("[MutationResolver/editUser()] input user name: {}", request.name());
        User user = User.restore(request.id(), request.name());
        UserInfoResult editedUser = editUserUseCase.editUser(user);
        log.info("[MutationResolver/editUser()] edited user name: {}", editedUser.name());

        return dtoResultMapper.toEditResponse(editedUser);
    }

    @MutationMapping
    public Long deleteUser(@Argument Long userId) {
        log.info("[MutationResolver/deleteUser()] input user id: {}", userId);

        Long deletedUserId = deleteUserUseCase.deleteUser(userId);
        return deletedUserId;
    }
}
