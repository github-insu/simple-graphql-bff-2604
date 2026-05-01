package com.example.simple_graphql_grpc_project_2604.post.usecase;

import com.example.simple_graphql_grpc_project_2604.post.graphql.model.Post;
import com.example.simple_graphql_grpc_project_2604.post.grpc.PostGrpcClient;
import com.example.simple_graphql_grpc_project_2604.post.usecase.mapper.ResponsePostMapper;
import com.example.simplegrpcpost2604.grpc.PostReadOneRequest;
import com.example.simplegrpcpost2604.grpc.PostReadOneResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReadPostOneUseCase {

    private final PostGrpcClient postGrpcClient;

    private final ResponsePostMapper responsePostMapper;

    public Post readPostOne(Long userId, Long postId) {
        log.info("[ReadPostOneUseCase/readPostOne] request user id: {}", userId);
        log.info("[ReadPostOneUseCase/readPostOne] request post id: {}", postId);
        PostReadOneRequest request = PostReadOneRequest.newBuilder()
                        .setId(postId)
                        .setUserId(userId)
                        .build();
        PostReadOneResponse response = postGrpcClient.readPostOne(request);

        return responsePostMapper.toPost(response);
    }
}
