package com.xstock.plutus;

import com.xstock.plutus.api.user.User;
import com.xstock.plutus.api.user.UserRepository;
import com.xstock.plutus.api.user.UserService;
import com.xstock.plutus.config.WebSecurityConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringJUnitConfig(classes = {WebSecurityConfig.class, UserService.class})
public class UserServiceTests {
    @Autowired
    private UserService userService;

    @MockBean
    private JwtDecoder jwtDecoder;

    @MockBean
    private UserRepository userRepository;

    private static final String uuid = "051c7240-8bc3-4577-9161-4f3f28dab600";
    private static final String authority = "profile";

    private static String config;
    private static UUID id;
    private static User user;

    @BeforeAll
    public static void setUp() {
        id = UUID.fromString(uuid);
        config = "config";
        user = new User(id, config);
    }

    @Test
    @WithMockUser(username = uuid)
    public void Should_Deny_When_WrongAuthority() {
        assertThrows(AccessDeniedException.class, () -> userService.getConfig(id));
        assertThrows(AccessDeniedException.class, () -> userService.createConfig(id, config));
        assertThrows(AccessDeniedException.class, () -> userService.updateConfig(id, config));
    }

    @Test
    @WithMockUser(authorities = authority)
    public void Should_Deny_When_WrongID() {
        assertThrows(AccessDeniedException.class, () -> userService.getConfig(id));
        assertThrows(AccessDeniedException.class, () -> userService.createConfig(id, config));
        assertThrows(AccessDeniedException.class, () -> userService.updateConfig(id, config));
    }

    @Test
    @WithMockUser(authorities = authority, username = uuid)
    public void Should_AllowAccess_When_Authorized() {
        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        assertEquals(config, userService.getConfig(id));
        assertDoesNotThrow(() -> userService.createConfig(id, config));
        assertDoesNotThrow(() -> userService.updateConfig(id, config));
    }

    @Test
    @WithMockUser(authorities = authority, username = uuid)
    public void Should_UpdateOrCreate_Config() {
        assertEquals(ResponseEntity.status(HttpStatus.CREATED).build(), userService.updateConfig(id, config));
        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        assertEquals(ResponseEntity.status(HttpStatus.OK).build(), userService.updateConfig(id, config));
    }
}
