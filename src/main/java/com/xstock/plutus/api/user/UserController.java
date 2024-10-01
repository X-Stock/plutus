package com.xstock.plutus.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/user/{uuid}/config")
public class UserController {
    private final UserService userService;

    @GetMapping
    public String getConfig(@PathVariable UUID id) {
        return userService.getConfig(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createConfig(@RequestParam UUID id, @RequestBody String config) {
        userService.createConfig(id, config);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateConfig(@RequestParam UUID id, @RequestBody String config) {
            return userService.updateConfig(id, config);
    }
}
