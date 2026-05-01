package com.example.simple_graphql_grpc_project_2604.user.grpc.config;

import com.example.simplegraphqlgrpcproject2604.grpc.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserGrpcClientConfig {

    @Bean
    public ManagedChannel userManagedChannel(@Value("${service.server.user-port}") String userServerPort) {
        return ManagedChannelBuilder
                .forAddress("localhost", Integer.parseInt(userServerPort))
                .usePlaintext()
                .build();
    }

    @Bean
    public UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub(
            @Qualifier("userManagedChannel") ManagedChannel channel) {

        return UserServiceGrpc.newBlockingStub(channel);
    }
}