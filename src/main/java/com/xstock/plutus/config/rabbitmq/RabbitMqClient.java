package com.xstock.plutus.config.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xstock.plutus.utils.exception.RabbitMqResponseException;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
public class RabbitMqClient {
    private final RabbitTemplate template;

    private final DirectExchange exchange;

    private final ObjectMapper objectMapper;

    public String sendAndReceive(Object object, String routingKey) {
        String message;
        try {
            message = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RabbitMqResponseException("Failed to serialize object", e);
        }

        byte[] response = (byte[]) template.convertSendAndReceive(exchange.getName(), routingKey, message);
        if (response == null) {
            throw new RabbitMqResponseException();
        }

        return new String(response, StandardCharsets.UTF_8);
    }
}
