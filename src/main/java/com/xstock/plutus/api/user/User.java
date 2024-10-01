package com.xstock.plutus.api.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class User {
    @Id
    private UUID id;

    @Setter
    @NotNull
    @Column(columnDefinition = "jsonb", nullable = false)
    private String config;
}
