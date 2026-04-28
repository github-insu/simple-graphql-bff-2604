package com.example.simple_graphql_grpc_project_2604.service;

import com.example.simple_graphql_grpc_project_2604.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    public User signUp(User user) {
        log.info("[UserService/signUp()] input user name: {}", user.name());
        return User.restore(1L, user.name());
    }

    public User readOneUser(Long userId) {
        log.info("[UserService/readOneUser()] input user id: {}", userId);
        return User.restore(1L, "아무개");
    }

    public List<User> readUserList() {
        log.info("[UserService/readUserList()]");
        List<User> savedUserList= new ArrayList<>();
        for (long i = 0; i < 10; i++) {
            savedUserList.add(User.restore(i, "아무개"+i));
        }
        log.info("[UserService/readUserList()] saved user size: {}", savedUserList.size());
        return savedUserList;
    }

    public User editUser(User user) {
        log.info("[UserService/editUser()] input user name: {}", user.name());
        User savedUser = User.restore(2L, "아무개2");
        savedUser.changeName(user.name());
        log.info("[UserService/editUser()] edited user name: {}", savedUser.name());
        return savedUser;
    }

    public void deleteUser(Long userId) {
        log.info("[UserService/deleteUser()] input user id: {}", userId);
    }
}
