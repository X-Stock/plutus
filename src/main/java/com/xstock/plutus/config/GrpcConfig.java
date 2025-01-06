package com.xstock.plutus.config;

import com.xstock.plutus.grpc.GrpcClient;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class GrpcConfig {

    @Bean
    public ManagedChannel managedChannel(@Value("${grpc.server}") String targetServer) {
        return Grpc.newChannelBuilder(targetServer, InsecureChannelCredentials.create())
                .build();
    }

    @Bean
    public GrpcClient grpcClient(ManagedChannel managedChannel) {
        return new GrpcClient(managedChannel);
    }
}
