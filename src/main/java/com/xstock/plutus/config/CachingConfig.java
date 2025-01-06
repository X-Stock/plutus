package com.xstock.plutus.config;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.xstock.plutus.utils.dto.PaginatedResponse;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.LoggingCacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@Configuration
@EnableCaching
class CachingConfig implements CachingConfigurer {
    private static final Duration TIME_TO_LIVE = Duration.ofHours(12);

    @Bean
    public RedisCacheConfiguration cacheConfiguration(ObjectMapper objectMapper) {
        objectMapper = objectMapper.copy();

        objectMapper = objectMapper
                .registerModule(new JavaTimeModule())
                .activateDefaultTyping(
                        objectMapper.getPolymorphicTypeValidator(),
                        ObjectMapper.DefaultTyping.NON_FINAL,
                        JsonTypeInfo.As.PROPERTY
                )
                .addMixIn(PaginatedResponse.class, MixIn.class);

        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(TIME_TO_LIVE)
                .disableCachingNullValues()
                .serializeValuesWith(
                        RedisSerializationContext.SerializationPair.fromSerializer(
                                new GenericJackson2JsonRedisSerializer(objectMapper)
                        )
                );
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return new LoggingCacheErrorHandler();
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
    private record MixIn() {
    }
}