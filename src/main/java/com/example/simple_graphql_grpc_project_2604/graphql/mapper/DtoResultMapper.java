package com.example.simple_graphql_grpc_project_2604.graphql.mapper;

import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserEditResponse;
import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserListReadResponse;
import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserReadOneResponse;
import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserSignUpResponse;
import com.example.simple_graphql_grpc_project_2604.usecase.model.UserInfoResult;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DtoResultMapper {

    UserSignUpResponse toSignUpResponse(UserInfoResult result);
    UserEditResponse toEditResponse(UserInfoResult result);

    UserReadOneResponse toReadOneResponse(UserInfoResult result);
}
