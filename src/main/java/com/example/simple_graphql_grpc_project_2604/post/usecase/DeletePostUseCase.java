package com.example.simple_graphql_grpc_project_2604.post.usecase;

import com.example.simple_graphql_grpc_project_2604.post.grpc.PostGrpcClient;
import com.example.simplegrpcpost2604.grpc.PostDeleteRequest;
import com.example.simplegrpcpost2604.grpc.PostDeleteResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeletePostUseCase {

    private final PostGrpcClient postGrpcClient;

    public Long deletePost(PostDeleteRequest request) {
        log.info("[DeletePostUseCase/deletePost] request user id: {}", request.getUserId());
        PostDeleteResponse response = postGrpcClient.deletePost(request);
        log.info("[DeletePostUseCase/deletePost] response post id: {}", response.getId());

        return response.getId();
    }
}
