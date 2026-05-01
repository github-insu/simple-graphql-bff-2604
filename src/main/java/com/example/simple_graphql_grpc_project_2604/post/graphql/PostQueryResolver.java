package com.example.simple_graphql_grpc_project_2604.post.graphql;

import com.example.simple_graphql_grpc_project_2604.post.graphql.model.Post;
import com.example.simple_graphql_grpc_project_2604.post.usecase.ReadPostListUseCase;
import com.example.simple_graphql_grpc_project_2604.post.usecase.ReadPostOneUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostQueryResolver {

    private final ReadPostOneUseCase readPostOneUseCase;
    private final ReadPostListUseCase readPostListUseCase;

    @QueryMapping
    public Post post(@Argument Long userId,
                     @Argument Long postId) {
        log.info("[QueryResolver/readPostOne] request user id: {}", userId);
        log.info("[QueryResolver/readPostOne] request post id: {}", postId);
        Post postById = readPostOneUseCase.readPostOne(userId, postId);
        log.info("[QueryResolver/readPostOne] read user id: {}", postById.userId());
        log.info("[QueryResolver/readPostOne] read post id: {}", postById.id());

        return postById;
    }

    @QueryMapping
    public List<Post> posts() {
        log.info("[QueryResolver/readPostList] 호출");
        List<Post> postList = readPostListUseCase.readPostList();
        log.info("[QueryResolver/readPostList] list size: {}", postList.size());

        return postList;
    }
}
