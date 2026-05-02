package com.example.simple_graphql_grpc_project_2604.post.usecase.mapper;

import com.example.simple_graphql_grpc_project_2604.post.graphql.model.Post;
import com.example.simplegrpcpost2604.grpc.PostEditResponse;
import com.example.simplegrpcpost2604.grpc.PostPublishResponse;
import com.example.simplegrpcpost2604.grpc.PostReadOneResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponsePostMapper {

    Post toPost(PostPublishResponse response);
    Post toPost(PostReadOneResponse response);
    Post toPost(PostEditResponse response);}
