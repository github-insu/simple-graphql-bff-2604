package com.example.simple_graphql_grpc_project_2604.user.graphql;

import com.example.simple_graphql_grpc_project_2604.user.graphql.model.User;
import com.example.simple_graphql_grpc_project_2604.user.usecase.ReadUserListUseCase;
import com.example.simple_graphql_grpc_project_2604.user.usecase.ReadUserOneUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserQueryResolver {

    private final ReadUserOneUseCase readUserOneUseCase;
    private final ReadUserListUseCase readUserListUseCase;

    @QueryMapping
    public User user(@Argument Long id) {
        log.info("[QueryResolver/user()] input user id: {}", id);

        return readUserOneUseCase.readUserOne(id);
    }

    @QueryMapping
    public List<User> users() {
        log.info("[QueryResolver/readUserList()] 호출 성공");

        return readUserListUseCase.readUserList();
    }
}
