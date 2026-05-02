package com.example.simple_graphql_grpc_project_2604.post.graphql.mapper;

import com.example.simple_graphql_grpc_project_2604.post.graphql.dto.DeletePostInput;
import com.example.simple_graphql_grpc_project_2604.post.graphql.dto.EditPostInput;
import com.example.simple_graphql_grpc_project_2604.post.graphql.dto.PublishPostInput;
import com.example.simplegrpcpost2604.grpc.PostDeleteRequest;
import com.example.simplegrpcpost2604.grpc.PostEditRequest;
import com.example.simplegrpcpost2604.grpc.PostPublishRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostinputRequestMapper {

    PostPublishRequest toPostPublishRequest(PublishPostInput input);
    PostEditRequest toPostEditRequest(EditPostInput input);
    PostDeleteRequest toPostDeleteRequest(DeletePostInput input);
}
