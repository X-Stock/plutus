package com.xstock.plutus.api.v1.user.account;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Entity
@Table(name = "accounts", schema = "users")
public class Account {
    @Id
    private final UUID id;

    @Setter
    @NotNull
    @Column(columnDefinition = "jsonb", nullable = false)
    private String config;
}
