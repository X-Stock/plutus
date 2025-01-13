package com.xstock.plutus.grpc;

import com.xstock.proto.optimizePortfolio.OptimizePortfolioGrpc;
import com.xstock.proto.optimizePortfolio.OptimizedPortfolioRequest;
import com.xstock.proto.optimizePortfolio.OptimizedPortfolioResponse;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
public class GrpcClient {
    private static final Log log = LogFactory.getLog(GrpcClient.class.getName());

    private final ManagedChannel channel;

    private final OptimizePortfolioGrpc.OptimizePortfolioBlockingStub blockingStub;

    public GrpcClient(@Value("${grpc.server}") String targetServer) {
        this.channel = Grpc.newChannelBuilder(targetServer, InsecureChannelCredentials.create())
                .build();
        blockingStub = OptimizePortfolioGrpc.newBlockingStub(channel);
        log.info("Started gRPC Client");
    }

    public void close() {
        log.info("Stopping gRPC Client...");
        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Unable to shut down gRPC Client. Timed out after 5 seconds.");
        }
    }

    public Optional<OptimizedPortfolioResponse> optimizePortfolio(OptimizedPortfolioRequest request) {
        OptimizedPortfolioResponse response = null;
        try {
            response = blockingStub.optimize(request);
        } catch (StatusRuntimeException e) {
            log.error("RPC failed: " + e.getStatus().getCause());
        }
        return Optional.ofNullable(response);
    }
}
