package com.example.simple_graphql_grpc_project_2604.post.grpc;

import com.example.simplegrpcpost2604.grpc.PostDeleteRequest;
import com.example.simplegrpcpost2604.grpc.PostDeleteResponse;
import com.example.simplegrpcpost2604.grpc.PostEditRequest;
import com.example.simplegrpcpost2604.grpc.PostEditResponse;
import com.example.simplegrpcpost2604.grpc.PostPublishRequest;
import com.example.simplegrpcpost2604.grpc.PostPublishResponse;
import com.example.simplegrpcpost2604.grpc.PostReadListResponse;
import com.example.simplegrpcpost2604.grpc.PostReadOneRequest;
import com.example.simplegrpcpost2604.grpc.PostReadOneResponse;
import com.example.simplegrpcpost2604.grpc.PostServiceGrpc;
import com.google.protobuf.Empty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
@Slf4j
public class PostGrpcClient {

    private final PostServiceGrpc.PostServiceBlockingStub stub;

    public PostPublishResponse publishPost(PostPublishRequest request) {
        log.info("[PostGrpcClient/publishPost] 호출");
        return stub.publishPost(request);
    }

    public PostReadOneResponse readPostOne(PostReadOneRequest request) {
        log.info("[PostGrpcClient/readPostOne] 호출");
        return stub.readPostOne(request);
    }

    public PostReadListResponse readPostList() {
        log.info("[PostGrpcClient/readPostList] 호출");
        return stub.readPostList(Empty.getDefaultInstance());
    }

    public PostEditResponse editPost(PostEditRequest request) {
        log.info("[PostGrpcClient/editPost] 호출");
        return stub.editPost(request);
    }

    public PostDeleteResponse deletePost(PostDeleteRequest request) {
        log.info("[PostGrpcClient/deletePost] 호출");
        return stub.deletePost(request);
    }
}
