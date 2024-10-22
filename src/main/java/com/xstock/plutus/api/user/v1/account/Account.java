package com.xstock.plutus.api.user.v1.account;

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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "accounts", schema = "user")
public class Account {
    @Id
    private UUID id;

    @Setter
    @NotNull
    @Column(columnDefinition = "jsonb", nullable = false)
    private String config;
}
