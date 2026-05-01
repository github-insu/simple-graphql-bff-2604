package com.example.simple_graphql_grpc_project_2604.post.graphql.model;

public record Post(
        Long id,
        String title,
        String content,

        Long userId
) {
}
