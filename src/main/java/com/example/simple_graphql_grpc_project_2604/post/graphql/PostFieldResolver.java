package com.example.simple_graphql_grpc_project_2604.post.graphql;

import com.example.simple_graphql_grpc_project_2604.post.graphql.model.Post;
import com.example.simple_graphql_grpc_project_2604.post.usecase.AuthorMappingUseCase;
import com.example.simple_graphql_grpc_project_2604.user.graphql.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostFieldResolver {

    private final AuthorMappingUseCase authorMappingUseCase;

    @SchemaMapping(typeName = "Post", field = "author")
    public User author(Post post) {
        log.info("[PostFieldResolver/author] post writer id: {}", post.userId());
        log.info("[PostFieldResolver/author] post title: {}", post.title());
        User authorById = authorMappingUseCase.readAuthorOne(post);
        log.info("[PostFieldResolver/author] author id: {}", authorById.id());

        return authorById;
    }
}
