package com.example.simple_graphql_grpc_project_2604.post.usecase;

import com.example.simple_graphql_grpc_project_2604.post.graphql.model.Post;
import com.example.simple_graphql_grpc_project_2604.post.grpc.PostGrpcClient;
import com.example.simple_graphql_grpc_project_2604.post.usecase.mapper.ResponsePostMapper;
import com.example.simplegrpcpost2604.grpc.PostEditRequest;
import com.example.simplegrpcpost2604.grpc.PostEditResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EditPostUseCase {

    private final PostGrpcClient postGrpcClient;

    private final ResponsePostMapper responsePostMapper;

    public Post editPost(PostEditRequest request) {
        log.info("[EditPostUseCase/editPost]");
        PostEditResponse response = postGrpcClient.editPost(request);
        log.info("[EditPostUseCase/editPost]");

        return responsePostMapper.toPost(response);
    }
}
