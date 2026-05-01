package com.example.simple_graphql_grpc_project_2604.post.usecase;

import com.example.simple_graphql_grpc_project_2604.post.graphql.model.Post;
import com.example.simple_graphql_grpc_project_2604.post.usecase.mapper.ResponseAuthorMapper;
import com.example.simple_graphql_grpc_project_2604.user.graphql.model.User;
import com.example.simple_graphql_grpc_project_2604.user.grpc.UserGrpcClient;
import com.example.simplegraphqlgrpcproject2604.grpc.UserReadOneRequest;
import com.example.simplegraphqlgrpcproject2604.grpc.UserReadOneResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorMappingUseCase {

    private final UserGrpcClient userGrpcClient;

    private final ResponseAuthorMapper responseAuthorMapper;

    public User readAuthorOne(Post post) {

        UserReadOneRequest request =  UserReadOneRequest.newBuilder()
                .setId(post.userId())
                .build();

        UserReadOneResponse response = userGrpcClient.readUserOne(request);
        return responseAuthorMapper.toAuthor(response);
    }
}
