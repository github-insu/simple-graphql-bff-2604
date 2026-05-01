package com.example.simple_graphql_grpc_project_2604.post.graphql.dto;

public record PublishPostInput(
        String title,
        String content,

        Long userId
) {
}
