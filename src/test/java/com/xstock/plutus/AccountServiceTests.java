package com.xstock.plutus;

import com.xstock.plutus.api.v1.user.account.Account;
import com.xstock.plutus.api.v1.user.account.AccountRepository;
import com.xstock.plutus.api.v1.user.account.AccountService;
import com.xstock.plutus.config.WebSecurityConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringJUnitConfig(classes = {WebSecurityConfig.class, AccountService.class})
public class AccountServiceTests {
    private static final String uuid = "051c7240-8bc3-4577-9161-4f3f28dab600";
    private static final UUID id = UUID.fromString(uuid);
    private static final String authority = "profile";
    private static String config;
    private static Account account;

    @Autowired
    private AccountService accountService;

    @MockitoBean
    private JwtDecoder jwtDecoder;

    @MockitoBean
    private AccountRepository accountRepository;

    @BeforeAll
    static void setUp() {
        config = "config";
        account = new Account(id, config);
    }

    @Test
    @WithMockUser(username = uuid)
    void test01ShouldDenyWhenWrongId() {
        assertThrows(AccessDeniedException.class, () -> accountService.getConfig(id));
        assertThrows(AccessDeniedException.class, () -> accountService.createConfig(id, config));
        assertThrows(AccessDeniedException.class, () -> accountService.updateConfig(id, config));
    }

    @Test
    @WithMockUser(authorities = authority)
    void test02ShouldDenyWhenWrongAuthority() {
        assertThrows(AccessDeniedException.class, () -> accountService.getConfig(id));
        assertThrows(AccessDeniedException.class, () -> accountService.createConfig(id, config));
        assertThrows(AccessDeniedException.class, () -> accountService.updateConfig(id, config));
    }

    @Test
    @WithMockUser(authorities = authority, username = uuid)
    void test03ShouldAllowAccessWhenAuthorized() {
        when(accountRepository.findById(id)).thenReturn(Optional.of(account));
        assertEquals(config, accountService.getConfig(id));
        assertDoesNotThrow(() -> accountService.createConfig(id, config));
        assertDoesNotThrow(() -> accountService.updateConfig(id, config));
    }

    @Test
    @WithMockUser(authorities = authority, username = uuid)
    void test05ShouldUpdateOrCreateConfig() {
        assertEquals(ResponseEntity.status(HttpStatus.CREATED).build(), accountService.updateConfig(id, config));
        when(accountRepository.findById(id)).thenReturn(Optional.of(account));
        assertEquals(ResponseEntity.status(HttpStatus.OK).build(), accountService.updateConfig(id, config));
    }
}
