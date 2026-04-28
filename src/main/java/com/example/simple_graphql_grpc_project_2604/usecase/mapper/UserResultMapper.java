package com.example.simple_graphql_grpc_project_2604.usecase.mapper;

import com.example.simple_graphql_grpc_project_2604.domain.User;
import com.example.simple_graphql_grpc_project_2604.usecase.model.UserInfoResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserResultMapper {

    @Mapping(target = "id", expression = "java(user.id())")
    @Mapping(target = "name", expression = "java(user.name())")
    UserInfoResult toInfoResult(User user);
}
