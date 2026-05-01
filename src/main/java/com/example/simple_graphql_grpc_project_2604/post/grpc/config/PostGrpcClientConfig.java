package com.example.simple_graphql_grpc_project_2604.post.grpc.config;

import com.example.simplegrpcpost2604.grpc.PostServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class PostGrpcClientConfig {

    @Bean
    public ManagedChannel postManagedChannel(@Value("${service.server.post-port}") String postServerPort) {
        log.info("postServerPort: {}", postServerPort);
        return ManagedChannelBuilder
                .forAddress("localhost", Integer.parseInt(postServerPort))
                .usePlaintext()
                .build();
    }

    @Bean
    public PostServiceGrpc.PostServiceBlockingStub postServiceBlockingStub(
            @Qualifier("postManagedChannel") ManagedChannel channel) {

        return PostServiceGrpc.newBlockingStub(channel);
    }
}
