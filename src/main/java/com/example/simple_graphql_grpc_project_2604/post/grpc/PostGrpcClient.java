package com.example.simple_graphql_grpc_project_2604.post.grpc;

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

    public PostReadOneResponse readPostOne(PostReadOneRequest request) {
        log.info("[PostGrpcClient/readPostOne] 호출");
        return stub.readPostOne(request);
    }

    public PostReadListResponse readPostList() {
        log.info("[PostGrpcClient/readPostList] 호출");
        return stub.readPostList(Empty.getDefaultInstance());
    }
}
