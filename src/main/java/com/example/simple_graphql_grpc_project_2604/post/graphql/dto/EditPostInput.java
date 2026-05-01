package com.example.simple_graphql_grpc_project_2604.post.graphql.dto;

public record EditPostInput(
        Long id,
        String title,
        String content,

        Long userId
) {
}
