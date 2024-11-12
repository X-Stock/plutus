package com.xstock.plutus.grpc;

import com.xstock.grpcProto.optimizePortfolio.Asset;
import com.xstock.grpcProto.optimizePortfolio.OptimizePortfolioGrpc;
import com.xstock.grpcProto.optimizePortfolio.OptimizedPortfolioRequest;
import com.xstock.grpcProto.optimizePortfolio.OptimizedPortfolioResponse;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Optional;
import java.util.concurrent.TimeUnit;


public class GrpcClient {
    private static final Log log = LogFactory.getLog(GrpcClient.class.getName());

    private final ManagedChannel channel;

    private final OptimizePortfolioGrpc.OptimizePortfolioBlockingStub blockingStub;

    public GrpcClient(ManagedChannel channel) {
        this.channel = channel;
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

    public Optional<OptimizedPortfolioResponse> optimizePortfolio(Iterable<Asset> assets) {
        OptimizedPortfolioRequest request = OptimizedPortfolioRequest.newBuilder().addAllAssets(assets).build();

        OptimizedPortfolioResponse response;
        try {
            response = blockingStub.optimize(request);
        } catch (StatusRuntimeException e) {
            log.error("RPC failed: " + e.getStatus().getCause());
            return Optional.empty();
        }
        return Optional.of(response);
    }
}
