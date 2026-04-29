package com.example.simple_graphql_grpc_project_2604.graphql.dto;

import java.util.List;

public record UserListReadPayload(
        List<UserReadOnePayload> userList
) {
}
