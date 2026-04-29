package com.example.simple_graphql_grpc_project_2604.graphql.mapper;

import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserEditInput;
import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserSignUpInput;
import com.example.simplegraphqlgrpcproject2604.grpc.UserDeleteRequest;
import com.example.simplegraphqlgrpcproject2604.grpc.UserEditRequest;
import com.example.simplegraphqlgrpcproject2604.grpc.UserReadOneRequest;
import com.example.simplegraphqlgrpcproject2604.grpc.UserSignUpRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GraphqlToGrpcMapper {

    UserSignUpRequest toUserSignUpRequest(UserSignUpInput input);
    UserEditRequest toUserEditRequest(UserEditInput input);
    UserDeleteRequest toUserDeleteRequest(Long id);

    UserReadOneRequest toUserReadOneRequest(Long id);
}
