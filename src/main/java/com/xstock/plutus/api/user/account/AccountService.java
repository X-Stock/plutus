package com.xstock.plutus.api.user.account;

import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@PreAuthorize("hasAuthority('profile') and #id.toString == authentication.name")
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public String getConfig(UUID id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        return account.getConfig();
    }

    @Transactional
    public void createConfig(UUID id, String config) {
        Account account = new Account(id, config);
        accountRepository.save(account);
    }

    @Transactional
    public ResponseEntity<HttpStatus> updateConfig(UUID id, String config) {
        Optional<Account> userConfig = accountRepository.findById(id);

        if (userConfig.isPresent()) {
            Account newConfig = userConfig.get();
            newConfig.setConfig(config);
            accountRepository.save(newConfig);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            createConfig(id, config);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }
}
