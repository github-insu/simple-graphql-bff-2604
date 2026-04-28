package com.example.simple_graphql_grpc_project_2604.usecase;

import com.example.simple_graphql_grpc_project_2604.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeleteUserUseCase {

    private final UserService userService;
    
    public Long deleteUser(Long userId) {
        log.info("[DeleteUserUseCase/deleteUser()] input id: {}", userId);
        // TODO: UserService gRPC통신
        try {
            userService.deleteUser(userId);
        } catch (Exception ex) {
            throw new IllegalArgumentException("작업 중 문제가 발생했습니다.");
        }

        return userId;
    }
}
