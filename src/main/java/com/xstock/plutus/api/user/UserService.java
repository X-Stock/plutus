package com.xstock.plutus.api.user;

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
public class UserService {
    private final UserRepository userRepository;

    public String getConfig(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        return user.getConfig();
    }

    @Transactional
    public void createConfig(UUID id, String config) {
        User user = new User(id, config);
        userRepository.save(user);
    }

    @Transactional
    public ResponseEntity<HttpStatus> updateConfig(UUID id, String config) {
        Optional<User> userConfig = userRepository.findById(id);

        if (userConfig.isPresent()) {
            User newConfig = userConfig.get();
            newConfig.setConfig(config);
            userRepository.save(newConfig);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            createConfig(id, config);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }
}
