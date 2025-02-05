package com.xstock.plutus.config.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("direct_rpc");
    }

    @Bean
    public RabbitMqClient client(RabbitTemplate template, ObjectMapper objectMapper) {
        return new RabbitMqClient(template, exchange(), objectMapper);
    }
}
