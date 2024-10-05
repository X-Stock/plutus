package com.xstock.plutus.api.user.account;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/user/{uuid}/config")
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public String getConfig(@PathVariable UUID id) {
        return accountService.getConfig(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createConfig(@RequestParam UUID id, @RequestBody String config) {
        accountService.createConfig(id, config);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateConfig(@RequestParam UUID id, @RequestBody String config) {
        return accountService.updateConfig(id, config);
    }
}
