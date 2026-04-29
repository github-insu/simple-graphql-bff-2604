package com.example.simple_graphql_grpc_project_2604.usecase;

import com.example.simple_graphql_grpc_project_2604.graphql.dto.UserReadOnePayload;
import com.example.simple_graphql_grpc_project_2604.grpc.UserGrpcClient;
import com.example.simplegraphqlgrpcproject2604.grpc.UserReadOneResponseList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReadUserListUseCase {

    private final UserGrpcClient userGrpcClient;

    public List<UserReadOnePayload> readUserList() {
        log.info("[ReadUserListUseCase/readUserList] 호출 성공");
        UserReadOneResponseList responseList = userGrpcClient.readUserList();

        return responseList.getUserReadOneResponseListList().stream()
                .map(oneResponse -> new UserReadOnePayload(
                        oneResponse.getId(), oneResponse.getName()
                ))
                .toList();
    }
}
