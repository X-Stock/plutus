package com.xstock.plutus.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.IpAddressMatcher;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class WebSecurityConfig {
    private static final Log log = LogFactory.getLog(WebSecurityConfig.class);

    private static final List<IpAddressMatcher> baseAllowedIps = List.of(
            new IpAddressMatcher("127.0.0.1"),
            new IpAddressMatcher("::1")
    );

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, @Value("${spring.allow-ips:}") String[] allowIps) throws Exception {
        Set<IpAddressMatcher> allowedIps = new HashSet<>(baseAllowedIps);
        for (String ip : allowIps) {
            try {
                allowedIps.add(new IpAddressMatcher(ip));
            } catch (IllegalArgumentException e) {
                log.warn(e.getMessage());
            }
        }
        IpAddressMatcher[] ipAddressMatchers = allowedIps.toArray(new IpAddressMatcher[0]);

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(ipAddressMatchers)
                        .permitAll()
                        .anyRequest().authenticated())
                .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
        return http.build();
    }
}
