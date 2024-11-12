package com.xstock.plutus.api.v1.ai.optimizePortfolio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Struct;
import com.google.protobuf.util.JsonFormat;
import com.xstock.grpcProto.optimizePortfolio.Asset;
import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistoricalService;
import com.xstock.plutus.utils.exception.GrpcResponseException;
import com.xstock.plutus.grpc.GrpcClient;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OptimizePortfolioService {
    private final GrpcClient grpcClient;

    private final StockHistoricalService stockHistoricalService;

    private final PageRequest defaultPageRequest;

    private final ObjectMapper objectMapper;

    public String getOptimizedPortfolio(Iterable<String> tickers) {
        try {
            List<Asset> assets = new ArrayList<>();
            for (String ticker : tickers) {
                var historical = stockHistoricalService
                        .getAllByTicker(ticker, defaultPageRequest, true)
                        .content();

                List<Struct> historicalStructs = new ArrayList<>();
                for (var data : historical) {
                    Struct.Builder structBuilder = Struct.newBuilder();
                    JsonFormat.parser().merge(objectMapper.writeValueAsString(data), structBuilder);
                    historicalStructs.add(structBuilder.build());
                }
                assets.add(Asset.newBuilder().setTicker(ticker).addAllHistorical(historicalStructs).build());
            }

            var response = grpcClient.optimizePortfolio(assets);
            var optimizedPortfolio = response.orElseThrow(GrpcResponseException::new);

            return JsonFormat.printer().print(optimizedPortfolio);
        } catch (Exception e) {
            throw new GrpcResponseException(e.getMessage());
        }
    }
}
