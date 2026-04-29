package com.example.simple_graphql_grpc_project_2604.graphql.mapper;

import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserSignUpInput;
import com.example.simplegraphqlgrpcproject2604.grpc.UserSignUpRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GraphqlToGrpcMapper {

    UserSignUpRequest toUserSignUpRequest(UserSignUpInput input);
}
