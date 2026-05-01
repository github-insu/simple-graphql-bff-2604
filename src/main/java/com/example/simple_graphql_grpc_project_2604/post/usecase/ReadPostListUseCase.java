package com.example.simple_graphql_grpc_project_2604.post.usecase;

import com.example.simple_graphql_grpc_project_2604.post.graphql.model.Post;
import com.example.simple_graphql_grpc_project_2604.post.grpc.PostGrpcClient;
import com.example.simple_graphql_grpc_project_2604.post.usecase.mapper.ResponsePostMapper;
import com.example.simplegrpcpost2604.grpc.PostReadListResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReadPostListUseCase {

    private final PostGrpcClient postGrpcClient;

    private final ResponsePostMapper responsePostMapper;

    public List<Post> readPostList() {
        log.info("[ReadPostListUseCase/readPostList] 호출");
        PostReadListResponse responseList = postGrpcClient.readPostList();

        return responseList.getPostReadOneResponseListList().stream()
                .map(responsePostMapper::toPost)
                .toList();
    }
}
