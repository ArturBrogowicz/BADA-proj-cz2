package com.badabdd.beautysal00n.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

public record Uslugi (
        @Id
        Integer idUslugi,
        @NotBlank
        String nazwa,
        @NotBlank
        String opis,
        @NotNull
        Double koszt,
        @NotNull
        char czyOferowana,
        @NotNull
        Integer idSalonu
) {
}
