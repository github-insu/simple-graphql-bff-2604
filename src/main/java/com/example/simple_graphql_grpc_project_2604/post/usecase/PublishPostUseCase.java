package com.example.simple_graphql_grpc_project_2604.post.usecase;

import com.example.simple_graphql_grpc_project_2604.post.graphql.model.Post;
import com.example.simple_graphql_grpc_project_2604.post.grpc.PostGrpcClient;
import com.example.simple_graphql_grpc_project_2604.post.usecase.mapper.ResponsePostMapper;
import com.example.simplegrpcpost2604.grpc.PostPublishRequest;
import com.example.simplegrpcpost2604.grpc.PostPublishResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PublishPostUseCase {

    private final PostGrpcClient postGrpcClient;

    private final ResponsePostMapper responsePostMapper;

    public Post publishPost(PostPublishRequest request) {
        log.info("[PublishPostUseCase/publishPost] request title: {}", request.getTitle());
        PostPublishResponse response = postGrpcClient.publishPost(request);
        log.info("[PublishPostUseCase/publishPost] response id: {}", response.getId());

        return responsePostMapper.toPost(response);
    }
}
