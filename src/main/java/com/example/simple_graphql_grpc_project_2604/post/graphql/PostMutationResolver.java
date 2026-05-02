package com.example.simple_graphql_grpc_project_2604.post.graphql;

import com.example.simple_graphql_grpc_project_2604.post.graphql.dto.DeletePostInput;
import com.example.simple_graphql_grpc_project_2604.post.graphql.dto.EditPostInput;
import com.example.simple_graphql_grpc_project_2604.post.graphql.dto.PublishPostInput;
import com.example.simple_graphql_grpc_project_2604.post.graphql.mapper.PostinputRequestMapper;
import com.example.simple_graphql_grpc_project_2604.post.graphql.model.Post;
import com.example.simple_graphql_grpc_project_2604.post.usecase.DeletePostUseCase;
import com.example.simple_graphql_grpc_project_2604.post.usecase.EditPostUseCase;
import com.example.simple_graphql_grpc_project_2604.post.usecase.PublishPostUseCase;
import com.example.simplegrpcpost2604.grpc.PostDeleteRequest;
import com.example.simplegrpcpost2604.grpc.PostEditRequest;
import com.example.simplegrpcpost2604.grpc.PostPublishRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostMutationResolver {

    private final PublishPostUseCase publishPostUseCase;
    private final EditPostUseCase editPostUseCase;
    private final DeletePostUseCase deletePostUseCase;

    private final PostinputRequestMapper postinputRequestMapper;

    @MutationMapping
    public Post publishPost(@Argument PublishPostInput input) {
        log.info("[PostMutationResolver/publishPost] request user id: {}", input.userId());
        PostPublishRequest request =  postinputRequestMapper.toPostPublishRequest(input);
        log.info("[PostMutationResolver/publishPost] request mapped user id: {}", request.getUserId());
        Post publishedPost = publishPostUseCase.publishPost(request);
        log.info("[PostMutationResolver/publishPost] response title: {}", request.getTitle());

        return publishedPost;
    }

    @MutationMapping
    public Post editPost(@Argument EditPostInput input) {
        log.info("[PostMutationResolver/editPost] request user id: {}", input.userId());
        log.info("[PostMutationResolver/editPost] request title: {}", input.title());
        PostEditRequest request = postinputRequestMapper.toPostEditRequest(input);
        log.info("[PostMutationResolver/editPost] request mapped user id: {}", request.getTitle());
        Post editedPost = editPostUseCase.editPost(request);
        log.info("[PostMutationResolver/editPost] request mapped user id: {}", editedPost.title());

        return editedPost;
    }

    @MutationMapping
    public Long deletePost(@Argument DeletePostInput input) {
        log.info("[PostMutationResolver/deletePost] request user id: {}", input.userId());
        log.info("[PostMutationResolver/deletePost] request post id: {}", input.id());
        PostDeleteRequest request = postinputRequestMapper.toPostDeleteRequest(input);
        log.info("[PostMutationResolver/deletePost] request mapped user id: {}", request.getUserId());
        Long deletedPostId = deletePostUseCase.deletePost((request));
        log.info("[PostMutationResolver/deletePost]  response post id: {}", deletedPostId);

        return deletedPostId;
    }
}
