package com.badabdd.beautysal00n.entities;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Narzedzia (
        @Id
        Integer idNarzedzia,
        @NotBlank
        String nazwa,
        @NotNull
        Double cena,
        @NotBlank
        String opis,
        @NotNull
        Integer idSalonu
) {
}
