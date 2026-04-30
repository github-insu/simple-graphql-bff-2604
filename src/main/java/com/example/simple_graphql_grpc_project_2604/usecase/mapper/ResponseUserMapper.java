package com.example.simple_graphql_grpc_project_2604.usecase.mapper;

import com.example.simple_graphql_grpc_project_2604.graphql.model.User;
import com.example.simplegraphqlgrpcproject2604.grpc.UserEditResponse;
import com.example.simplegraphqlgrpcproject2604.grpc.UserReadOneRequest;
import com.example.simplegraphqlgrpcproject2604.grpc.UserReadOneResponse;
import com.example.simplegraphqlgrpcproject2604.grpc.UserSignUpResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponseUserMapper {

    User toUser(UserReadOneResponse response);
    User toUser(UserSignUpResponse response);
    User toUser(UserEditResponse response);
    UserReadOneRequest toUserReadOneRequest(Long id);
}
