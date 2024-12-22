package com.badabdd.beautysal00n.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

public record Adresy (
        @Id
        Integer idAdresu,
        @NotBlank
        String miasto,
        @NotBlank
        String ulica,
        @NotBlank
        String kodPocztowy,
        @NotNull
        Integer nrBudynku,
        Integer nrLokalu
) {
}
