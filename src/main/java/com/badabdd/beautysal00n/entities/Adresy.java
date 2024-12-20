package com.badabdd.beautysal00n.entities;

import jakarta.validation.constraints.NotBlank;
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
        @NotBlank
        Integer nrBudynku,
        Integer nrLokalu
) {
}
