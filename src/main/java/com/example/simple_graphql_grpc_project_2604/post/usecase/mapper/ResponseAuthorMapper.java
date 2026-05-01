package com.example.simple_graphql_grpc_project_2604.post.usecase.mapper;

import com.example.simple_graphql_grpc_project_2604.user.graphql.model.User;
import com.example.simplegraphqlgrpcproject2604.grpc.UserReadOneResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponseAuthorMapper {

    User toAuthor(UserReadOneResponse response);
}
