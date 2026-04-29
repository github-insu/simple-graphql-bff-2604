package com.example.simple_graphql_grpc_project_2604.graphql;

import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserReadOnePayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class QueryResolver {


    @QueryMapping
    public UserReadOnePayload readOneUser(@Argument Long userId) {
        log.info("[QueryResolver/readOneUser()] input user id: {}", userId);

        return null;
    }

    @QueryMapping
    public List<UserReadOnePayload> readUserList() {
        log.info("[QueryResolver/readUserList()]");

        return null;
    }
}
