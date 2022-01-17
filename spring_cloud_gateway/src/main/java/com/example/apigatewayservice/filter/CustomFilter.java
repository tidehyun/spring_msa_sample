package com.example.apigatewayservice.filter;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

//@Component
@Slf4j
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest serverHttpRequest = exchange.getRequest();
            ServerHttpResponse serverHttpResponse = exchange.getResponse();

            log.info("GLOBAL PRE FILTER base message : {}", config.getBaseMessage());
            if (config.isPreLogger()) {
                log.info("GLOBAL FILTER START : {} , uri : {} ", serverHttpRequest.getId(), serverHttpRequest.getURI());
            }
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("GLOBAL FILTER END : {}", serverHttpResponse.getStatusCode());
            }));
        };
    }

    @Setter
    @Getter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }


    public CustomFilter() {
        super(Config.class);
    }
}
