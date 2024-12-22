package com.badabdd.beautysal00n.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

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
