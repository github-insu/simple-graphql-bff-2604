package com.example.simple_graphql_grpc_project_2604.user.graphql.mapper;

import com.example.simple_graphql_grpc_project_2604.user.graphql.dto.EditUserInput;
import com.example.simple_graphql_grpc_project_2604.user.graphql.dto.SignUpUserInput;
import com.example.simplegraphqlgrpcproject2604.grpc.UserDeleteRequest;
import com.example.simplegraphqlgrpcproject2604.grpc.UserEditRequest;
import com.example.simplegraphqlgrpcproject2604.grpc.UserSignUpRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InputRequestMapper {
    UserSignUpRequest toUserSignUpRequest(SignUpUserInput input);
    UserEditRequest toUserEditRequest(EditUserInput input);
    UserDeleteRequest toUserDeleteRequest(Long id);
}
